package com.ds.algo.recursion;

import java.lang.*;

class PrintAllSubstring {

// str : Stores input string
// curr : Stores current subset
// index : Index in current subset, curr
    static void powerSet(String str, int index, String curr) {
        int n = str.length();

        // base case
        if (index == n)
        {
            System.out.println(curr);
            return;
        }

        // Two cases for every character
        // (i) We consider the character as part of current subset
        // (ii) We do not consider current character as part of current subset
        powerSet(str, index + 1, curr + str.charAt(index));
        powerSet(str, index + 1, curr);

    }

    // Java program to print all substrings of a string
        // Function to print all substring
        public static void SubString(String str, int n)
        {
            for (int i = 0; i < n; i++)
                for (int j = i+1; j <= n; j++)
                    System.out.println(str.substring(i, j));
        }


    public static void main(String[] args)
    {
        String str = "abc";
        int index = 0;
        String curr="";
        powerSet(str,index,curr);

        System.out.println("\n\n\n");

        SubString(str, str.length());
    }
}