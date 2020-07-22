package com.ds.algo.string;

import java.util.Objects;

public class Anagram {

    public static void main(String[] args){
        System.out.println(isAnagram("Listen", "SILENT"));
        System.out.println(isAnagram("Liston", "SILENT"));
    }

    public static boolean isAnagram(String stringA, String stringB){
        if(Objects.isNull(stringA) || Objects.isNull(stringB) || stringA.trim().length() == 0 || stringB.trim().length() == 0 || stringA.trim().length()!=stringB.trim().length()){
            throw new IllegalArgumentException("invalid value");
        }

        char[] charArray1 = stringA.trim().toLowerCase().toCharArray();
        char[] charArray2 = stringB.trim().toLowerCase().toCharArray();

        int[] inputArray1 = new int[26];

        for(int i=0 ; i<charArray1.length; i++) {
            inputArray1[charArray1[i]-97]++;
            inputArray1[charArray2[i]-97]--;
        }

        for(int i=0; i<inputArray1.length; i++){
            if(inputArray1[i]!=0){
                return false;
            }
        }

        return true;
    }
}
