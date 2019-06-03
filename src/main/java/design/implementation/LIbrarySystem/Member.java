package design.implementation.LIbrarySystem;

public class Member {
    //private Date dateOfMembership;
    private int totalBooksCheckedout;
    private String MemberID;

    //total no. of books checked out by user
    public int getTotalBooksCheckedout() {
        return totalBooksCheckedout;
    }

    public boolean reserveBookItem(BookItem bookItem) {
        return true;
    }

    public void returnBookItem(BookItem bookItem) {
        //this.checkForFine();
        BookReservation bookReservation = new BookReservation(bookItem.getBarCode());
        String memberId = bookReservation.getMemeberID();
        if (memberId != null) {
            bookItem.updateBookItemStatus(BookStatus.RESERVED);
            bookReservation.sendBookAvailableNotification(memberId);
        }
        bookItem.updateBookItemStatus(BookStatus.AVAILABLE);
        bookReservation.removeEntryFromReservationList(bookItem.getBarCode());
        totalBooksCheckedout--;
    }

    public boolean checkoutBookItem(BookItem bookItem) {
        //valide no. of books issued to memeber.
        if (this.totalBooksCheckedout >= Constants.MAX_BOOKS_ISSUED_TO_A_USER) {
            //ShowError("The user has already checkedout maximum number of books");
            return false;
        }
        //BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.getBarcode());
        BookReservation bookReservation = new BookReservation(bookItem.getBarCode());

        if (bookReservation.getMemeberID() != null) {
            if (bookReservation.getMemeberID() != this.MemberID) {
                // book item has a pending reservation from another user
                //ShowError("This book is reserved by another member");
                return false;
            } else {
                // book item has a pending reservation from the give member, update it
                //bookReservation.updateStatus(ReservationStatus.COMPLETED);
                bookItem.updateBookItemStatus(BookStatus.LOANED);
                BookReservation.addEntryToBookReservationList(bookItem.getBarCode(), this.MemberID);
            }
        }
        totalBooksCheckedout++;
        return true;
    }

    public boolean renewBookItem(BookItem bookItem) {
        //this.checkForFine();
        //BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.getBarcode());

        BookReservation bookReservation = new BookReservation(bookItem.getBarCode());

        if (bookReservation.getMemeberID() != null) {
            // book item has a pending reservation from another user
            //ShowError("This book is reserved by another member");
            bookItem.updateBookItemStatus(BookStatus.RESERVED);
            bookReservation.sendBookAvailableNotification(bookReservation.getMemeberID());
            totalBooksCheckedout--;
            return false;
        }

        //add lend book date
        //bookItem.updateDueDate(LocalDate.now().plusDays(Constants.MAX_LENDING_DAYS));
        return true;
    }


}
