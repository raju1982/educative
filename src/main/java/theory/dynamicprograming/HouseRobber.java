package theory.dynamicprograming;

import java.util.*;

public class HouseRobber {
    //bottom up
    public static int sol(int[] input) {
        if(input.length == 0){
            return 0;
        }

        if(input.length == 1){
            return input[0];
        }

        int[] memo = new int[input.length];

        memo[0] = input[0];
        memo[1] = Math.max(input[0], input[1]);

        for(int i=2; i<input.length; i++){
            memo[i] = Math.max(memo[i-1],  memo[i-2] + input[i]);
        }
        System.out.println(Arrays.toString(memo));
        return memo[input.length-1];
    }

    public static void main(String[] args) {
        System.out.println(sol(new int[]{2, 7, 9, 3, 1}));
        System.out.println(sol(new int[]{1, 2, 3, 1}));
    }
}
