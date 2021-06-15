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

    //memo
    static int[] memo;
    public static int sol(int[] set, int length){
        if(length >= set.length){
            return 0;
        }

        int a;
        if(length+2<set.length) {
            if (memo[length + 2] != -1) {
                a = memo[length + 2];
            } else {
                a = sol(set, length + 2);
            }
        }
        else{
            a = 0;
        }

        int b;
        if(length+1<set.length){
            if(memo[length+1]!=-1) {
                b = memo[length + 1];
            }else{
                b = sol(set, length+1);
            }
        }
        else{
            b = 0;
        }

        memo[length] = Math.max(set[length] + a, b);
        return memo[length];
    }


    public static void main(String[] args) {
        System.out.println(sol(new int[]{2, 7, 9, 3, 1}));
        System.out.println(sol(new int[]{1, 2, 3, 1}));


        int[] set = {2, 7, 9, 3, 1};
        memo = new int[set.length];
        Arrays.fill(memo, -1);
        System.out.println(sol(set, 0));
        System.out.println(Arrays.toString(memo));

        set = new int[] {1, 2, 3, 1};
        memo = new int[set.length];
        Arrays.fill(memo, -1);
        System.out.println(sol(set, 0));
        System.out.println(Arrays.toString(memo));
    }
}
