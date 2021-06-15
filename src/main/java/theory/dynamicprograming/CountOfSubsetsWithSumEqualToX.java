package theory.dynamicprograming;

import java.util.Arrays;

public class CountOfSubsetsWithSumEqualToX {

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
            memo[index][sum] = sol(set, sum, index-1) + sol(set, sum-set[index-1], index-1);
        }

        return memo[index][sum];
    }


    public static void main(String[] args){

        int[] set = {1,2,3,3};
        memo = new int[set.length+1][6+1];
        for(int i=0; i<memo.length; i++){
            Arrays.fill(memo[i], -1);
        }
        System.out.println(sol(set, 6, set.length));
        for(int i=0; i<memo.length; i++){
            for(int j=0; j<memo[0].length;j++){
                System.out.print(memo[i][j] + " , ");
            }
            System.out.println();
        }




        int[] set2 = {1, 1, 1, 1};
        memo = new int[set2.length+1][1+1];
        for(int i=0; i<memo.length; i++){
            Arrays.fill(memo[i], -1);
        }
        System.out.println(sol(set2, 1, set.length));
        for(int i=0; i<memo.length; i++){
            for(int j=0; j<memo[0].length;j++){
                System.out.print(memo[i][j] + " , ");
            }
            System.out.println();
        }
    }
}
