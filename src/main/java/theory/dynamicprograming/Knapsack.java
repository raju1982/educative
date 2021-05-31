package theory.dynamicprograming;

import java.util.*;

public class Knapsack {
    private static int[][] memo;
    public static int solWithMemoization(int[] value, int[] weight, int currentWeight, int index){
        if(currentWeight==0 || index==0){
            return 0;
        }

        if(memo[currentWeight][index] != -1){
            return memo[currentWeight][index];
        }

        if(weight[index-1]>currentWeight){
            memo[currentWeight][index] = solWithMemoization(value, weight, currentWeight, index-1);
        }
        else{
            memo[currentWeight][index] =  Math.max(solWithMemoization(value, weight, currentWeight, index-1),
                    value[index-1] + solWithMemoization(value, weight, currentWeight-weight[index-1], index-1));
        }

        return memo[currentWeight][index];
    }

    public static void main(String[] args){
        int[] value = new int[]{60, 100, 120};
        int[] weight = new int[]{10,20,30};
        int currentWeight =  50;
        int size = value.length;
        memo = new int[currentWeight+1][size+1];

        for(int i=0; i<memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        System.out.println(solWithMemoization(value, weight, currentWeight, size));

        System.out.println(Arrays.toString(memo));

    }













//Plain recursive code
/*
    public static int sol(int[] weights, int[] values, int currentWeight, int currentIndex){

        if(currentIndex==0 || currentWeight==0){
            return 0;
        }

        if(currentWeight<weights[currentIndex-1]){
            return sol(weights, values, currentWeight, currentIndex-1);
        }
        else{
            return Math.max(sol(weights, values, currentWeight, currentIndex-1),
                    values[currentIndex-1] + sol(weights, values, currentWeight-weights[currentIndex-1], currentIndex-1));
        }

    }

    public static void main(String[] args){
        int values[] = new int[] { 60, 100, 120 };
        int weights[] = new int[] { 10, 20, 30 };
        System.out.println(sol(weights, values, 50, weights.length));
    }
*/
}
