package design.statepattern.vendingmachine;

public class MachineWarning extends Exception{
    public MachineWarning(String expMessage){
        super(expMessage);
    }
}
