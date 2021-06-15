package theory.dynamicprograming;

import java.util.*;

public class CoinChange {

    static int[][] memo;
    public static int sol(int[] set, int sum, int index){
        if(sum==0){
            return 1;
        }

        if(index==0){
            return 0;
        }

        if(memo[index][sum]!= -1){
            return memo[index][sum];
        }

        if(set[index-1]>sum){
            memo[index][sum] = sol(set, sum, index-1);
        }
        else{
            memo[index][sum] = sol(set, sum, index-1) + sol(set, sum-set[index-1], index);
        }

        return memo[index][sum];
    }

    public static void main(String[] args){
        int[] set = {1,2,3};
        int sum = 4;
        int index = set.length;
        memo = new int[index+1][sum+1];

        for(int i=0; i<memo.length; i++){
            Arrays.fill(memo[i],-1);
        }

        System.out.println(sol(set, sum, index));
    }
}