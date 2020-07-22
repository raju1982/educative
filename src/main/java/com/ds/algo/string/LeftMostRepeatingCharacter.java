package com.ds.algo.string;

import java.util.Objects;

public class LeftMostRepeatingCharacter {

    public static void main(String[] args){
        System.out.println(findLeftMostRepeatingCharacter("geeksforgeeks"));
        System.out.println(findLeftMostRepeatingCharacter("abbcc"));
        System.out.println(findLeftMostRepeatingCharacter("abcd"));
    }

    public static int findLeftMostRepeatingCharacter(String input){
        if(Objects.isNull(input) || input.trim().length() == 0 ){
            throw new IllegalArgumentException("invalid value");
        }

        char[] charArray = input.trim().toCharArray();

        int[] inputArray = new int[256];

        for(int i=0; i<inputArray.length; i++){
            inputArray[i] = -1;
        }

        int result = Integer.MAX_VALUE;

        for(int i=0; i<charArray.length; i++){
            if(inputArray[charArray[i]] == -1){
                //store first index of character
                inputArray[charArray[i]] = i;
            }
            else{
                //result will be min of first index of characters
                result = Math.min(result, inputArray[charArray[i]]);
            }
        }
        return result==Integer.MAX_VALUE? -1: result;
    }
}
