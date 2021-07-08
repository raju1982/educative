package theory.dynamicprograming;

import java.util.Arrays;

public class LongestCommonSubsequence {
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
        String arr = "ABCDGH";
        String input = "AEDFHR";
        memo = new int[arr.length()+1][input.length()+1];
        for(int i=0; i<memo.length; i++){
            Arrays.fill(memo[i], -1);
        }
        System.out.println(LongestCommonSubsequence(arr, input, arr.length(), input.length()));

        for(int i=0; i<memo.length; i++){
            System.out.println(Arrays.toString(memo[i]));
        }


/*
        arr = "AGGTAB";
        input = "GXTXAYB";
        memo = new int[arr.length()+1][input.length()+1];
        for(int i=0; i<memo.length; i++){
            Arrays.fill(memo[i], -1);
        }
        System.out.println(LongestCommonSubsequence(arr, input, arr.length(), input.length(), 0));

        for(int i=0; i<memo.length; i++){
            System.out.println(Arrays.toString(memo[i]));
        }*/
    }

}
