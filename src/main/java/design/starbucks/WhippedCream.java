package design.starbucks;

public class WhippedCream extends CondimentDecorator{

    Beverage beverage;

    public WhippedCream(Beverage beverage){
        this.beverage = beverage;
        description = beverage.getDescription() + " with whipped cream.";
    }

    public float cost(){
        float cost = this.beverage.cost();

        if(this.beverage.getSize() == Size.extraLarge){
            cost = cost + 3;
        }
        else if(this.beverage.getSize() == Size.large){
            cost = cost + 2;
        }
        else {
            cost = cost + 1;
        }
        return cost;
    }

}
