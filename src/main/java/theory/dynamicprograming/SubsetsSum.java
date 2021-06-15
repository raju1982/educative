package theory.dynamicprograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsSum {
    public static boolean sol(int[] set, int sum, int index, List<Integer> currentSol){
        if(sum == 0){
            System.out.println(currentSol);
            return true;
        }

        if(index == 0){
            return false;
        }

        if(set[index-1] > sum){
            if(sol(set, sum, index-1, currentSol)){
                return true;
            }
        }
        else{
            if(sol(set, sum, index-1, currentSol)){
                return true;
            }
            currentSol.add(set[index-1]);
            if(sol(set, sum-set[index-1], index-1, currentSol)){
                return true;
            }
            currentSol.remove(currentSol.size()-1);
        }

        return false;
    }


    public static boolean sol2(int[] set, int sum, int index){
        if(sum == 0){
            return true;
        }

        if(index == 0){
            return false;
        }

        if(set[index-1] > sum){
            return sol2(set, sum, index-1);
        }
        else{
            return (
                    sol2(set, sum, index-1) ||
                            sol2(set, sum-set[index-1], index-1));

        }
    }

    static int[][] memo;
    public static int memo_sol(int[] set, int sum, int index){
        if(sum == 0){
            return 1;
        }

        if(index == 0){
            return 0;
        }

        if(memo[index][sum]!= -1){
            return memo[index][sum];
        }

        if(set[index-1] > sum){
            memo[index][sum] = memo_sol(set, sum, index-1);
            //return memo[index][sum];
        }
        else{
            if((memo_sol(set, sum, index-1) == 1) || (memo_sol(set, sum-set[index-1], index-1) == 1)){
                memo[index][sum] = 1;
            }
            else{
                memo[index][sum] = 0;
            }
        }
        return memo[index][sum];
    }


    public static void main(String[] args){
        int[] values = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println(sol(values, sum, values.length, new ArrayList<>()));
        System.out.println(sol2(values, sum, values.length));

        int[] values2 = {3, 34, 4, 12, 5, 2};
        System.out.println(sol(values2, 30, values2.length, new ArrayList<>()));
        System.out.println(sol2(values2, 30, values2.length));


        memo = new int[values.length+1][sum+1];

        for(int i=0; i<memo.length; i++){
            Arrays.fill(memo[i], -1);
        }

        System.out.println(memo_sol(values, 9, values.length));

        for(int i=0; i<memo.length; i++){
            for(int j=0; j<memo[0].length; j++){
                System.out.print(memo[i][j] + " , ");
            }
            System.out.println();
        }

        memo = new int[values2.length+1][30+1];

        for(int i=0; i<memo.length; i++){
            Arrays.fill(memo[i], -1);
        }

        System.out.println(memo_sol(values2, 30, values2.length));

        for(int i=0; i<memo.length; i++){
            for(int j=0; j<memo[0].length; j++){
                System.out.print(memo[i][j] + " , ");
            }
            System.out.println();
        }
    }
}
