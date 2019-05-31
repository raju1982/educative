package design.statepattern;

public class MachineWarning extends Exception{
    public MachineWarning(String expMessage){
        super(expMessage);
    }
}
