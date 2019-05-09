package array;

import java.util.Arrays;

public class FindMinimumValueInArrayAndTopTwoElement {

    public static void main(String[] args){
        System.out.println(solution(new int[] {9,2,3,6}));
        System.out.println(Arrays.toString(topTwoValues(new int[] {9,2,3,6})));
        System.out.println(Arrays.toString(topTwoValues(new int[] {9,-2,-3,-6})));
        System.out.println(Arrays.toString(topTwoValues(new int[] {-1,2,-3,-6})));
        System.out.println(Arrays.toString(topTwoValues(new int[] {8,1,4,7,10,1,15})));
    }

    public static int solution(int[] input){
        int answer = input[0];

        for(int i=1; i<input.length; i++)
            if(input[i] < answer){
                answer = input[i];
        }
        return answer;
    }

    //sort and pick top two values
    public static int[] topTwoValues(int[] input){
        Arrays.sort(input);
        int[] result = new int[2];
        result[0]=input[input.length-1];
        result[1]=input[input.length-2];
        return result;
    }


    //incorrect solution
    public static int[] topTwoValues2(int[] input){
        //IllegalArgumentException -> null ||  input.length < 2
        int max = input[0];;
        int secondMax = Integer.MIN_VALUE;
        for(int i=0; i<input.length; i++){
            if(max<=input[i]){
                max=input[i];
            }
            else if(secondMax<input[i]){
                secondMax=input[i];
            }
        }

        if(max != input[0]){
            secondMax = Math.max(secondMax, input[0]);
        }

        int[] result = new int[2];
        result[0]=max;
        result[1]=secondMax;

        return result;
    }


}