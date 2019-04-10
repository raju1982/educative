package stackandQueue;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 3.6 - Animal Shelter
 * An animal shelter which holds only dogs and cats operates on FIFO. People must
 * adopt the oldest of all animals or select dog / cat. Create data structure to
 * maintain this system, and implement operations : enqueue, dequeueAny, dequeueDog
 * dequeueCat. You may use built-in LinkedList data structure
 */

class Animal{
    String type;
    Date arrived;
}

class Dog extends Animal{
    String name;
    public Dog(String name){
        super();
        this.name = name;
        type = "Dog";
    }
}

class Cat extends Animal{
    String name;
    public Cat(String name){
        super();
        this.name = name;
        type = "Cat";
    }
}

public class AnimalShelter{
    private Queue<Cat> cats;
    private Queue<Dog> dogs;

    public AnimalShelter(){
        cats = new LinkedList<Cat>();
        dogs = new LinkedList<Dog>();
    }

    public void enqueue(Animal animal) throws Exception{
        boolean isCat = animal.type.equals("Cat");
        boolean isDog = animal.type.equals("Dog");
        if(!isCat && !isDog)
            throw new Exception("Unknow type of animal!");

        animal.arrived = new Date();
        if(isCat) cats.offer((Cat) animal);
        else dogs.offer((Dog) animal);
    }

    public Animal dequeueAny() throws Exception{
        boolean noCat = cats.isEmpty();
        boolean noDog = dogs.isEmpty();

        if(noCat && noDog) throw new Exception("There are no more animals!");

        if(noDog) return cats.poll();
        if(noCat) return dogs.poll();
        return cats.peek().arrived.compareTo(dogs.peek().arrived) < 0 ? cats.poll() : dogs.poll();
    }

    public Cat dequeueCat() throws Exception{
        boolean noCat = cats.isEmpty();
        if(noCat) throw new Exception("There are no more cats!");
        return cats.poll();
    }

    public Dog dequeueDog() throws Exception{
        boolean noDog = dogs.isEmpty();
        if(noDog) throw new Exception("There are no more dogs!");
        return dogs.poll();
    }
}
