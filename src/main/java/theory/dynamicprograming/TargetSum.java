package theory.dynamicprograming;

import java.util.*;

public class TargetSum {
    static int[][] memo;
    public static int sol(int[] data, int runningTarget, int runningIndex){
        if(runningIndex == 0){
            if(runningTarget == 0){
                return 1;
            }
            return 0;
        }

        /*
        if(runningTarget == 0){
            return 1;
        }

        if(runningIndex == 0){
            return 0;
        }
         */

        /*
        if (i == nums.length) {
            if (sum == S)
                return 1;
            else
                return 0;
         */



        if(memo[runningIndex][runningTarget]!=-1){
            return memo[runningIndex][runningTarget];
        }

        if(data[runningIndex-1] > runningTarget){
            memo[runningIndex][runningTarget] = sol(data, runningTarget, runningIndex-1);
        }
        else{
            memo[runningIndex][runningTarget] = sol(data, runningTarget, runningIndex-1) + sol(data, runningTarget-data[runningIndex-1], runningIndex-1);
        }

        return memo[runningIndex][runningTarget];

    }

    public static int sol(int[] data, int target){
        int sum = 0;
        for(int i=0; i<data.length; i++){
            sum = sum + data[i];
        }

        if(sum<target){
            return 0;
        }

        if((sum + target)%2!=0){
            return 0;
        }

        int finalTarget = (sum + target)/2;

        System.out.println("finalTarget " + finalTarget);

        memo = new int[data.length+1][finalTarget+1];
        for(int i=0; i<memo.length; i++){
            Arrays.fill(memo[i], -1);
        }

        return sol(data, finalTarget, data.length);
    }



    public static void main(String[] args){
        int[] data = new int[] {1,1,1,1,1};
        int target = 3;
        System.out.println(sol(data, target));

        int[] data1 = new int[] {1};
        int target1 = 1;
        System.out.println(sol(data1, target1));

        int[] data2 = {1};
        int target2 = 2;
        System.out.println(sol(data2, target2));


        int[] data3 = {0,0,0,0,0,0,0,0,1};
        int target3 = 1;
        System.out.println(sol(data3, target3));

        int[] data4 = {7,9,3,8,0,2,4,8,3,9};
        int target4 = 0;
        System.out.println(sol(data4, target4));


/*
        for(int i=0; i<memo.length; i++){
            for(int j=0; j<memo[0].length; j++){
                System.out.print(memo[i][j] + " , ");
            }
            System.out.println();
        }
*/
    }



}
