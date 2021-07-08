package theory.dynamicprograming;

import java.util.Arrays;

public class PrintLongestCommonSubsequence {
    static int[][] memo;
    public static int LongestCommonSubsequence(String arr, String input, int arrIndex, int inputIndex){
        if(arrIndex == 0 || inputIndex == 0){
            return 0;
        }

        if(memo[arrIndex][inputIndex]!=-1){
            return memo[arrIndex][inputIndex];
        }

        if(arr.charAt(arrIndex-1) == input.charAt(inputIndex-1)){
            memo[arrIndex][inputIndex] = 1+LongestCommonSubsequence(arr, input, arrIndex-1, inputIndex-1);
        }
        else{
            memo[arrIndex][inputIndex] =  Math.max(LongestCommonSubsequence(arr, input, arrIndex-1, inputIndex),
                    LongestCommonSubsequence(arr, input, arrIndex, inputIndex-1));
        }

        return memo[arrIndex][inputIndex];
    }

    public static void main(String[] args){
        String arr = "AGGTAB";
        String input = "GXTXAYB";
        memo = new int[arr.length()+1][input.length()+1];
        for(int i=0; i<memo.length; i++){
            Arrays.fill(memo[i], -1);
        }
        System.out.println(LongestCommonSubsequence(arr, input, arr.length(), input.length()));

        for(int i=0; i<memo.length; i++){
            System.out.println(Arrays.toString(memo[i]));
        }

        int i=0;
        int j =0;
        String ans = "";
        while(i < arr.length() && j < input.length()){
            if(arr.charAt(i)==input.charAt(j)){
                ans = ans + arr.charAt(i);
                i++;
                j++;
            }
            else if(memo[i+1][j]<memo[i][j+1]){
                j++;
            }
            else{
                i++;
            }
        }

        System.out.println(ans);
    }
}



/**
 https://leetcode.com/problems/shortest-common-supersequence/
 https://python.plainenglish.io/print-shortest-common-supersequence-day-61-python-bba3ca1c288
 https://leetcode.com/problems/shortest-common-supersequence/discuss/940346/DP-Memoization-Approach-Using-LCS


 https://atharayil.medium.com/printing-longest-common-subsequence-day-58-python-878add9ec408
 https://www.hackerrank.com/challenges/dynamic-programming-classics-the-longest-common-subsequence/problem

 **/