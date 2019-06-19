package design.dogdoor;

import java.util.List;
import java.util.ArrayList;

public class DogDoor {
    private boolean isOpen;
    private List<Bark> barkList;

    public void open(){
        this.isOpen = true;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        close();
    }

    public void close(){
        this.isOpen = false;
    }

    public boolean isDoorOpen(){
        return this.isOpen;
    }

    public void addBark(Bark bark){
        if(barkList == null){
            barkList = new ArrayList<>();
        }
        barkList.add(bark);
    }

    public List<Bark> getAllowedBarks(){
        return barkList;
    }

    public void addAllowedBark(Bark bark){
        if(barkList==null){
            barkList = new ArrayList<>();
        }
        barkList.add(bark);
    }
}
