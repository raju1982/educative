package theory.binarysearchtree;

import java.util.*;

public class TreeMapExample {

    public static void main(String[] args) {
        // Initialization of a TreeMap using Generics
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        // Inserting the Elements
        treeMap.put(10, "geeks");
        treeMap.put(15, "ide");
        treeMap.put(5, "courses");
        treeMap.put(8, "hello");

        // Prints the TreeMap
        System.out.println(treeMap);

        // Check for the key in the map
        System.out.println(treeMap.containsKey(10));

        // Iterating over TreeMap
        for (Map.Entry<Integer, String> e : treeMap.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());

        //remove and size
        System.out.println(treeMap.size());
        treeMap.remove(8);
        System.out.println(treeMap.size());

        // returns the smallest key greater
        // than the passed key i.e., 15
        System.out.println(treeMap.higherKey(10));

        // returns the greatest smaller key
        // than the passed key i.e., 5
        System.out.println(treeMap.lowerKey(10));

        // greatest key <= passed key i.e., 10
        System.out.println(treeMap.floorKey(10));

        // greatest key >= passed key i.e., 10
        System.out.println(treeMap.ceilingKey(10));



        // returns the key-value pair corresponding
        // to higher key and prints the associated value
        System.out.println(treeMap.higherEntry(10).getValue());

        // returns the key-value pair corresponding
        // to lower key prints the associated value
        System.out.println(treeMap.lowerEntry(10).getValue());

        // returns a key-value mapping associated
        // with the greatest key <= to the given key
        System.out.println(treeMap.floorEntry(10).getValue());

        // returns a key-value mapping associated
        // with the least key >= to the given key
        System.out.println(treeMap.ceilingEntry(10).getValue());
    }

}
