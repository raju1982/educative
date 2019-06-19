package design.dogdoor;

public class Remote {
    private DogDoor door;

    public Remote(DogDoor door){
        this.door = door;
    }

    public void pressButton(){
        if(door.isDoorOpen()){
            door.close();
        }
        else{
            door.open();
        }
    }
}
