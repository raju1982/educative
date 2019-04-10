package OOP.first;

public class Person {
    public static void main(String[] args){
        RemoteControl remoteControl = RemoteControl.getInstance();

        remoteControl.setDevice(new SurroundSound());
        remoteControl.deviceOff();
        remoteControl.deviceON();
    }
}
