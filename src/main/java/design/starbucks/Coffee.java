package design.starbucks;

public class Coffee extends Beverage{

    public Coffee(){
        description = "coffee";
    }

    public float cost(){
        if(this.getSize()  == Size.medium){
            return 1f;
        }
        if(this.getSize()  == Size.large){
            return 2f;
        }
        return 3f;
    }
}
