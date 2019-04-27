package core.lambda;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;

public class CollectionPlay {

    public static void main(String[] args) {

        List<car> data = new ArrayList<>();
        data.add(new car("honda", "fit"));
        data.add(new car("toyota","colora"));
        data.add(new car("jeep","wrangler"));

        printCars(data, (c) -> c.getBrand().equals("fit"));


        Function<car, String> brand = c -> c.getName();
        System.out.println(brand.apply(data.get(0)));
    }


    public static void printCars1(List<car> cars, carCondition condition){
        for(car c: cars){
            if(condition.test(c)){
                c.print();
            }
        }
    }


    public static void printCars(List<car> cars, Predicate<car> condition){
        for(car c: cars){
            if(condition.test(c)){
                c.print();
            }
        }
    }



}

@FunctionalInterface
interface carCondition{
    public boolean test(car c);
}

class car {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    String name, brand;

    public car(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "car{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }

    void print() {
        System.out.println(this);
    }
}