package array;

import java.util.Arrays;

public class FindMinimumValueInArrayAndTopTwoElement {

    public static void main(String[] args){
        System.out.println(solution(new int[] {9,2,3,6}));
        System.out.println(Arrays.toString(topTwoValues(new int[] {9,2,3,6})));
    }

    public static int solution(int[] input){
        int answer = input[0];

        for(int i=1; i<input.length; i++)
            if(input[i] < answer){
                answer = input[i];
        }
        return answer;
    }

    public static int[] topTwoValues(int[] input){
        //IllegalArgumentException -> null ||  input.length < 2
        int max = input[0];
        int secondMax = 0;
        for(int i=1; i<input.length; i++){
            if(max<=input[i]){
                max=input[i];
            }
            else if(secondMax<input[i]){
                secondMax=input[i];
            }
        }
        int[] result = new int[2];
        result[0]=max;
        result[1]=secondMax;

        return result;
    }


}