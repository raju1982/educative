package com.ds.algo.string;

public class Palindrome {

    public static boolean iterativeSolution(String input){
        char[] inputCharArray = input.toCharArray();
        int startIndex = 0;
        int endIndex  = inputCharArray.length-1;
        while(startIndex<endIndex){
            if(inputCharArray[startIndex] != inputCharArray[endIndex]){
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }

}
