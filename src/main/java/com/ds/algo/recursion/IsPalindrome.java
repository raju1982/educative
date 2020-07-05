package com.ds.algo.recursion;

public class IsPalindrome {

    public static boolean recursiveSolution(String input, int startIndex, int endIndex){

        if(startIndex>=endIndex){
            return true;
        }

        return (input.charAt(startIndex) == input.charAt(endIndex)) && recursiveSolution(input, ++startIndex, --endIndex);
    }

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


    public static void main(String[] args){
        System.out.println(recursiveSolution("aabjbaa", 0, "aabjbaa".length()-1));
        System.out.println(recursiveSolution("aabbaa", 0, "aabbaa".length()-1));
        System.out.println(recursiveSolution("aabba", 0, "aabba".length()-1));

        System.out.println(iterativeSolution("aabjbaa"));
        System.out.println(iterativeSolution("aabbaa"));
        System.out.println(iterativeSolution("aabba"));
    }

}

