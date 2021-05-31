package theory.dynamicprograming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinNumberOfOperationsToReduceNTo0 {

    private static Set<Integer> getDigits(int number){
        Set<Integer> result = new HashSet<>();

        while(number > 0){
            result.add(number%10);
            number = number / 10;
        }

        return result;
    }

    private static int minSteps = Integer.MAX_VALUE;

    public static void sol(int number, int steps){
        System.out.println("number = " + number  +  " steps = " + steps);
        if(number == 0){
            minSteps = Math.min(minSteps, steps);
            return;
        }

        for(int i : getDigits(number)){
            if(i==0){
                continue;
            }
            sol(number-i, steps+1);
        }
    }

    private static int[] memo;
    public static int sol3(int number){
        if(number == 0){
            return 0;
        }

        if(number < 10){
            return 1;
        }

        memo = new int[number+1];
        memo[0] = 0;
        for(int i=1; i<10; i++){
            memo[i] = 1;
        }

        for(int i=10; i<=number ; i++){
            int tmpSteps = Integer.MAX_VALUE;
            for(int j : getDigits(i)){
                if(j==0){
                    continue;
                }
                tmpSteps = Math.min(tmpSteps, memo[i-j] + 1);
            }
            memo[i] = tmpSteps;
        }

        return memo[number];
    }

    public static void main(String[] args){
        //sol(27, 0);
        //System.out.println(minSteps);
        //System.out.println(sol2(27, 0));


        System.out.println(sol3(27));
        System.out.println(Arrays.toString(memo));
    }
}
