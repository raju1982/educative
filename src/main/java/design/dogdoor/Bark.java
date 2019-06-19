package design.dogdoor;

public class Bark {
    private String sound;

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }
    public Bark(String sound){
        this.sound = sound;
    }

    @Override
    public boolean equals(Object bark) {
        if (bark == null || !(bark instanceof Bark)) {
            return false;
        }
        Bark tmp = (Bark) bark;

        if (this.sound.equalsIgnoreCase(tmp.getSound())) {
            return true;
        }
        return false;
    }
}
