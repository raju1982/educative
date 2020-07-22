package com.ds.algo.string;

import java.util.Arrays;
import java.util.Objects;

public class PatternMatchingAlgoKMP {

    //identified a pattern , we have found a prefix which is also a suffix and it's ending at this position.
    private static int[] buildPattern(String substring){
        int[] pattern = new int[substring.length()];
        //-1 represent that we have found no patterns, all character are unique
        Arrays.fill(pattern,-1);
        int j=0;
        int i=1;
        while(i < substring.length()){
            if(substring.charAt(i) == substring.charAt(j)){
                //identified a pattern , we have found a prefix which is also a suffix and it's ending at this position.
                pattern[i] = j;
                i++;
                j++;
            }
            else if (j>0){
                j=pattern[j-1] + 1;
            }
            else{
                //no pattern found, keep value as -1 for pattern[i]
                i++;
            }
        }

        return pattern;
    }

    public static boolean doesMatch(String string, String substring){

        if(Objects.isNull(string) || Objects.isNull(substring) || string.trim().length() == 0 || substring.trim().length() == 0){
            throw new IllegalArgumentException("invalid value");
        }

        //search is case in-sensitive
        string = string.trim().toLowerCase();
        substring = substring.trim().toLowerCase();

        int[] longestProperPrifixWhichIsAlsoSuffixIndex = buildPattern(substring);

        int i=0, j=0;

        while(i<string.length() && j<substring.length()){
            if(string.charAt(i) == string.charAt(j)){
                i++;
                j++;
            }
            else if(j>0){
                j = longestProperPrifixWhichIsAlsoSuffixIndex[j-1] + 1;
            }
            else{
                i++;
            }
        }

        if(j==substring.length()-1){
            return true;
        }

        return false;
    }

    // O(n+m) time | O(m) space
    public static void main(String[] input){
        //System.out.println(doesMatch("aefoaefcdaefcdaed", "aefcdaed"));
        //System.out.println(doesMatch("abcxabcdabcdabcy", "abcdabcy"));
        System.out.println(doesMatch("abcxabcdabcdabcy", "abcxdabcy"));
    }

}
