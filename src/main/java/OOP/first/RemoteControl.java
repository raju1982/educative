package OOP.first;

public class RemoteControl {
    private static final RemoteControl remoteControl = new RemoteControl();
    private Device device;

    public static RemoteControl getInstance() {
        return remoteControl;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public void deviceOff() {
        device.deviceOff();
    }

    public void deviceON() {
        device.deviceOn();
    }
}

class Projector implements Device {
    public void deviceOff() {
        System.out.println("Project off");
    }

    public void deviceOn() {
        System.out.println("Project on");
    }
}

class TV implements Device {
    public void deviceOff() {
        System.out.println("TV off");
    }

    public void deviceOn() {
        System.out.println("TV on");
    }
}

class SurroundSound implements Device {
    public void deviceOff() {
        System.out.println("SurroundSound off");
    }

    public void deviceOn() {
        System.out.println("SurroundSound on");
    }
}
