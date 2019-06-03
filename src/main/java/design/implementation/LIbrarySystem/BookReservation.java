package design.implementation.LIbrarySystem;

import java.util.Map;
import java.util.HashMap;

public class BookReservation {
    private String bookItemBarcode;
    private String memberId;
    private static volatile Map<String, String> bookReservationList;
    private static BookReservation bookReservation = null;

    public  BookReservation(String barcode){
        this.bookItemBarcode = barcode;
        this.memberId = bookReservationList.get(barcode);
    }

    public String getMemeberID(){
        return this.memberId;
    }

    public void sendBookAvailableNotification(String memberId){

    }

    public static synchronized void addEntryToBookReservationList(String bookItemBarcode, String memberId){
        if(bookReservationList == null){
            bookReservationList = new HashMap<>();
        }
        bookReservationList.put(bookItemBarcode, memberId);
    }

    public static synchronized void removeEntryFromReservationList(String bookItemBarcode){
        if(bookReservationList!=null) {
            bookReservationList.remove(bookItemBarcode);
        }
    }
}