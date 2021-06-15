package theory.dynamicprograming;

import java.util.Arrays;

public class MinimumJumpsToReachEnd {
    static int[] memo;
    public static int sol(int[] set, int length){
        if(length == set.length-1){
            memo[length] = 0;
            return 0;
        }
        if(memo[length]!=-1){
            return memo[length];
        }
        int res = Integer.MAX_VALUE;
        for(int i=length+1; i<=length+set[length] && i<set.length; i++){
            int jump = sol(set, i);
            if(jump!=Integer.MAX_VALUE) {
                res = Math.min(res, 1 + jump);
            }
        }
        memo[length] = res;
        return res;
    }

    public static void main(String[] args){
        int[] set = {1,1,3,6,9,3,0,1,3};
        memo = new int[set.length];
        Arrays.fill(memo, -1);
        System.out.println(sol(set, 0));
        System.out.println(Arrays.toString(memo));

        int[] set2 = {2,1,1,1,4};
        memo = new int[set2.length];
        Arrays.fill(memo, -1);
        System.out.println(sol(set2, 0));
        System.out.println(Arrays.toString(memo));
    }

}
