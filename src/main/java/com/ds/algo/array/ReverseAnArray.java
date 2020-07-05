package com.ds.algo.array;

import java.util.Arrays;

public class ReverseAnArray {

    public static void solution(int[] input){
        int startIndex=0, endIndex=input.length-1;

        while(startIndex<endIndex){
            swapElement(startIndex, endIndex, input);
            startIndex++;
            endIndex--;
        }

    }


    private static void swapElement(int i, int j, int[] input){
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }


    public static void main(String[] args){
        int[] input = new int[] {0,5,6,0,0,8,7};
        solution(input);
        System.out.println(Arrays.toString(input));
    }
}
