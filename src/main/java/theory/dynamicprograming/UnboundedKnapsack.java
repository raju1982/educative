package theory.dynamicprograming;

import java.util.Arrays;

public class UnboundedKnapsack {
    private static int[][] memo;
    public static int solWithMemoization(int[] value, int[] weight, int currentWeight, int index){
        if(currentWeight==0 || index==0){
            return 0;
        }

        if(memo[index][currentWeight] != -1){
            return memo[index][currentWeight];
        }

        if(weight[index-1]>currentWeight){
            memo[index][currentWeight] = solWithMemoization(value, weight, currentWeight, index-1);
        }
        else{
            memo[index][currentWeight] =  Math.max(solWithMemoization(value, weight, currentWeight, index-1),
                    value[index-1] + solWithMemoization(value, weight, currentWeight-weight[index-1], index));
        }

        return memo[index][currentWeight];
    }

    public static void main(String[] args){
        int[] value = {1, 30};
        int[] weight = {1, 50};
        int currentWeight =  100;
        int size = value.length;
        memo = new int[size+1][currentWeight+1];

        for(int i=0; i<memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        System.out.println(solWithMemoization(value, weight, currentWeight, size));


        int[] value2 = {10, 40, 50, 70};
        int[] weight2 = {1, 3, 4, 5};
        int currentWeight2 =  8;
        int size2 = value2.length;
        memo = new int[size2+1][currentWeight2+1];

        for(int i=0; i<memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        System.out.println(solWithMemoization(value2, weight2, currentWeight2, size2));

    }
}
