package design.implementation.LIbrarySystem;

import java.util.Date;

public class BookItem extends Book{
    private String barcode;
    private boolean isReferenceOnly;
    private Date borrowed;
    private Date dueDate;
    private BookStatus status = BookStatus.AVAILABLE;

    public void updateBookItemStatus(BookStatus bookStatus){}

    public BookItem(String barcode, boolean isReferenceOnly){}

    public String getBarCode(){
        return barcode;
    }

    public boolean checkout() { //String memberId
        return process(BookStatus.LOANED);
    }

    public boolean reserve() {  //String memberId
        return process(BookStatus.RESERVED);
    }

    private boolean process(BookStatus bookStatus){
        if(isReferenceOnly) {
            //ShowError("This book is Reference only and can't be issued");
            return false;
        }
        this.updateBookItemStatus(bookStatus);
        return true;
    }
}


//private String memberId;
//list of barcode -> memberID