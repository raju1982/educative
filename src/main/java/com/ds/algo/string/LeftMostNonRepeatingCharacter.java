package com.ds.algo.string;

import java.util.Objects;

public class LeftMostNonRepeatingCharacter {

    private static final int ARRAY_LENGTH = 256;

    public static void main(String[] args){
        System.out.println(findLeftMostRepeatingCharacter("geeksforgeeks"));
        System.out.println(findLeftMostRepeatingCharacter("abbcc"));
        System.out.println(findLeftMostRepeatingCharacter("abcdabcd"));
    }

    public static int findLeftMostRepeatingCharacter(String input){
        if(Objects.isNull(input) || input.trim().length() == 0 ){
            throw new IllegalArgumentException("invalid value");
        }

        char[] charArray = input.trim().toCharArray();

        int[] resultArray = new int[ARRAY_LENGTH];

        for(int i=0; i<resultArray.length; i++){
            resultArray[i] = -1;
        }

        //store first index of non repeating character
        for(int i=0; i<charArray.length; i++){
            if(resultArray[charArray[i]] == -1){
                resultArray[charArray[i]] = i;
            }
            else{
                resultArray[charArray[i]] = -2;
            }
        }

        int result = Integer.MAX_VALUE;

        for(int i=0; i<ARRAY_LENGTH; i++){
            if(resultArray[i]>=0){
                result = Math.min(result, resultArray[i]);
            }
        }

        return result==Integer.MAX_VALUE? -1: result;
    }
}