package theory.dynamicprograming;

import java.util.*;

public class MinimumNumberOfCoinsThatMakeAChange {

    static int[][] memo;
    public static int sol(int[] set, int sum, int index){
        if(sum==0){
            return 0;
        }

        if(index==0){
            return Integer.MAX_VALUE;
        }

        if(memo[index][sum]!= -1){
            return memo[index][sum];
        }

        int minCSB = Integer.MAX_VALUE;
        if(set[index-1]<=sum){
            minCSB = sol(set, sum-set[index-1], index);
            if(minCSB!=Integer.MAX_VALUE){
                minCSB = minCSB + 1;
            }
        }

        int minCSA = sol(set, sum, index-1);
        memo[index][sum] = Math.min(minCSA, minCSB);

        return memo[index][sum];
    }

    public static void main(String[] args){
        int[] set = {1,2,3};
        int sum = 11;
        int index = set.length;
        memo = new int[index+1][sum+1];

        for(int i=0; i<memo.length; i++){
            Arrays.fill(memo[i],-1);
        }

        System.out.println(sol(set, sum, index));

        System.out.println("\n");

        for(int i=0; i<memo.length; i++){
            System.out.println(Arrays.toString(memo[i]));
        }


    }




}