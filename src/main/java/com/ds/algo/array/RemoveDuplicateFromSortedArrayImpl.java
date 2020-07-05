package com.ds.algo.array;

import java.util.Arrays;
public class RemoveDuplicateFromSortedArrayImpl{

    //in  first pass get count.
    //in second pass load array
    // this will save space.


    public static int[] cleanupArray(int[] input){

        int[] res = new int[input.length];
        int j = 0;
        res[j++] = input[0];

        for(int i=0; i<input.length-1; i++){
            if(input[i+1]!= input[i]){
                res[j++] = input[i+1];
            }
        }

        System.out.println(Arrays.toString(res));

        int[] finalResult = new int[j];

        for(int i=0; i<j ; i++){
            finalResult[i] = res[i];
        }

        System.out.println(Arrays.toString(finalResult));

        return finalResult;
    }


    public static void main(String[] args){

        int[] input = new int[] {4,5,5,8,8,9,10,12};
        System.out.println(Arrays.toString(cleanupArray(input)));


    }


}