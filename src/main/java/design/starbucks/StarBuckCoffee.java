package design.starbucks;

public class StarBuckCoffee {
    public static void main(String[] args){
        Beverage coffee = new Coffee();
        coffee.setSize(Beverage.Size.large);

        Beverage beverage = new WhippedCream(coffee);
        System.out.println(beverage.getDescription());
        System.out.println(beverage.cost());
    }
}
