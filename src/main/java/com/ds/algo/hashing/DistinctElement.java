package com.ds.algo.hashing;

//find no. of distinct element (count) in O(n) complexity
//find count of frequency of array element in O(n) complexity

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DistinctElement {

    public static int distinctElement(int[] input){
        Set<Integer> data = new HashSet<>();

        for(int x: input){
            data.add(x);
        }

        return data.size();
    }


    public static Map<Integer, Integer> frequencyOfArrayElement(int[] input){
        Map<Integer, Integer> data = new HashMap<>();
        for(int x: input){
            if(data.get(x) == null){
                data.put(x, 1);
            }
            else {
                data.put(x, data.get(x) + 1);
            }
        }
        return data;
    }


    public static void main(String[] args){
        System.out.println(new DistinctElement().distinctElement(new int[]{5,7,2,6,1,9,3,5,6}));

        Map<Integer, Integer> result = frequencyOfArrayElement(new int[]{5,7,2,6,1,9,3,5,6,1,1});
        System.out.println(result.get(1));
        System.out.println(result.get(9));
    }

}
