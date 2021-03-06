package theory.binarysearchtree;

import java.util.TreeSet;

//store element by default in the lexicographic order.
//always print in the sorted order.
public class TreeSetExample {

    public static void main(String[] args){
        TreeSet<Integer> data = new TreeSet<>();
        data.add(4);
        data.add(8);
        data.add(12);
        data.add(17);
        data.add(1);

        //sorted order
        for(int x : data){
            System.out.print(x + "\t");
        }
        System.out.println();
        System.out.println(data.contains(12));

        data.remove(12);

        for(int x : data){
            System.out.print(x+ "\t");
        }
        System.out.println();

        // Prints the largest value lower than 5
        System.out.println(data.lower(8));

        //Prints the largest value lower than 5 or the value itself.
        System.out.println(data.floor(8));

        // Prints the smallest value larger than 8
        System.out.println(data.higher(8));

        //Prints the smallest value larger than 8 or the value itself.
        System.out.println(data.ceiling(8));

        //highest in the TreeSet
        System.out.println(data.first());
        //lowest in the TreeSet
        System.out.println(data.last());
    }


}
