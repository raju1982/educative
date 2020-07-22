package com.ds.algo.string;

import java.util.Arrays;
import java.util.Objects;

/*
[Input : str = geeksforgeeks, k = 3
 Output : r
 First non-repeating character is f,
 second is o and third is r.]
 */
public class KthNonRepeatingCharacter {

    private static final int ARRAY_INDEX = 256;

    public static void main(String[] args){
        final String input = "geeksforgeeks";
        int res = kthNonRepeatingCharacterIndex(input, 3);

        System.out.println(res);
    }

    public static int kthNonRepeatingCharacterIndex(String input, int index){
        if(Objects.isNull(input) || input.trim().length() == 0 || index<1){
            throw new IllegalArgumentException("invalid input value");
        }

        int inputSize = input.trim().length();

        int[] resultArray = new int[ARRAY_INDEX];

        for(int i=0; i<resultArray.length; i++){
            resultArray[i] = inputSize;
        }

        char[] charArray = input.trim().toCharArray();

        //store first index of non repeating character
        for(int i=0; i<charArray.length; i++){
            if(resultArray[charArray[i]] == inputSize){
                resultArray[charArray[i]] = i;
            }
            else{
                resultArray[charArray[i]] = inputSize+1;
            }
        }

        Arrays.sort(resultArray);

        return resultArray[index-1]!=inputSize? resultArray[index-1]: -1;
    }

}
