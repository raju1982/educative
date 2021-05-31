package theory.array;

import java.util.Arrays;

public class EquilibriumPoint {

    public static int sol(int[] input){
        //prefix sum array [sum of element on left side] = {0,3,7,15,6,26}
        int[] leftSum = new int[input.length];
        leftSum[0] = 0;
        for(int i=1; i<input.length; i++){
            leftSum[i] = leftSum[i-1] + input[i-1];
        }

        System.out.println(Arrays.toString(leftSum));

        //sum of element on right side  = {29,25,17,26,6,0}
        int[] rightSum = new int[input.length];
        rightSum[input.length-1] = 0;

        if(rightSum[input.length-1] == leftSum[input.length-1]){
            return input.length-1;
        }

        for(int i=input.length-2; i>=0; i--){
            rightSum[i] = rightSum[i+1] + input[i+1];
            if(rightSum[i] == leftSum[i]){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        System.out.println(sol(new int[]{3,4,8,-9,20,6}));
        System.out.println(sol(new int[]{4, -2, 2}));
        System.out.println(sol(new int[]{4, 2, 2}));
    }


}
