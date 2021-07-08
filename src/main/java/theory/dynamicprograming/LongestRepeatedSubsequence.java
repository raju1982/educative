package theory.dynamicprograming;

import java.util.*;

public class LongestRepeatedSubsequence {
    static int[][] memo;
    public static int findLongestCommonSubsequence(String s1, String s2, int s1Index, int s2Index){
        if(s1Index==0 || s2Index==0){
            return 0;
        }

        if(memo[s1Index][s2Index]!=-1){
            return memo[s1Index][s2Index];
        }

        if(s1Index != s2Index && s1.charAt(s1Index-1) == s2.charAt(s2Index-1)){
            memo[s1Index][s2Index] = 1 + findLongestCommonSubsequence(s1, s2, s1Index-1, s2Index-1);
        }
        else{
            memo[s1Index][s2Index] = Math.max(findLongestCommonSubsequence(s1, s2, s1Index-1, s2Index), findLongestCommonSubsequence(s1, s2, s1Index, s2Index-1));
        }

        return memo[s1Index][s2Index];
    }

    public static void main(String[] args){
        String s1 = "tomorrow";
        String s2 = s1;
        memo = new int[s1.length()+1][s2.length()+1];
        for(int i=0; i<memo.length; i++){
            Arrays.fill(memo[i], -1);
        }
        System.out.println(findLongestCommonSubsequence(s1, s2, s1.length(), s2.length()));

        s1 = "aabdbcec";
        s2 = s1;
        memo = new int[s1.length()+1][s2.length()+1];
        for(int i=0; i<memo.length; i++){
            Arrays.fill(memo[i], -1);
        }
        System.out.println(findLongestCommonSubsequence(s1, s2, s1.length(), s2.length()));


        s1 = "fmff";
        s2 = s1;
        memo = new int[s1.length()+1][s2.length()+1];
        for(int i=0; i<memo.length; i++){
            Arrays.fill(memo[i], -1);
        }
        System.out.println(findLongestCommonSubsequence(s1, s2, s1.length(), s2.length()));
    }
}
