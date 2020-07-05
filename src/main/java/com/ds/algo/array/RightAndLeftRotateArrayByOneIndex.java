package com.ds.algo.array;

import java.util.Arrays;

public class RightAndLeftRotateArrayByOneIndex {
    public static void rightRotateArrayByOneIndex(int[] input){

        int tmp = input[input.length-1];

        for(int i=input.length-1; i>0; i--){
            input[i]=input[i-1];
        }

        input[0]=tmp;
    }

    public static void leftRotateArrayByOneIndex(int[] input){

        int tmp = input[0];

        for(int i=1; i<input.length; i++){
            input[i-1] = input[i];
        }

        input[input.length-1] = tmp;
    }

    public static void leftRotateArrayByOneIndex2(int[] input){

        int tmp = input[0];

        for(int i=0; i<input.length-1; i++){
            input[i] = input[i+1];
        }

        input[input.length-1] = tmp;
    }

    public static void main(String[] args) {

        int[] input = new int[]{0, 3, 5, 6, 8, 12};
        rightRotateArrayByOneIndex(input);
        System.out.println(Arrays.toString(input));

        int[] x = new int[]{0, 3, 5, 6, 8, 12};
        leftRotateArrayByOneIndex(x);
        System.out.println(Arrays.toString(x));

         x = new int[]{0, 3, 5, 6, 8, 12};
        leftRotateArrayByOneIndex2(x);
        System.out.println(Arrays.toString(x));
    }
}
