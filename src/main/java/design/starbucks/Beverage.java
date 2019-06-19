package design.starbucks;

public abstract class Beverage {
    public enum Size{
        medium, large, extraLarge
    }

    protected String description = "unknown beverage";
    private Size size;

    public void setSize(Size size){
        this.size = size;
    }

    public Size getSize(){
        return size;
    }

    public String getDescription(){
        return description;
    }

    public abstract float cost();
}
