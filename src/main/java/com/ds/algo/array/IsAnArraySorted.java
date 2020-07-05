package com.ds.algo.array;

import java.util.Arrays;

public class IsAnArraySorted {

    //2. is an Array Sorted
    public static boolean isArraySorted(int[] input){
        for(int i=1; i<input.length; i++){
            if(input[i]<input[i-1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int[] inputArray = new int[]{4,7,1,8};
        System.out.println(isArraySorted(inputArray));
        Arrays.sort(inputArray);
        System.out.println(isArraySorted(inputArray));
    }

}
