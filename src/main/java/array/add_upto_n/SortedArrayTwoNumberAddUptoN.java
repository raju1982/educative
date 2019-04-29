package array.add_upto_n;

import java.util.Arrays;

public class SortedArrayTwoNumberAddUptoN {

    public static void main(String[] args){
        int[] input = {1,21,3,14,5,60,7,6};
        Arrays.sort(input);
        solution(input, 27);
    }

    public static void solution(int[] input, int number){
        int beginningPointer=0;
        int endPointer=input.length-1;

        while(beginningPointer!=endPointer) {
            int sum = input[beginningPointer] + input[endPointer];
            if (sum < number) {
                beginningPointer++;
            }
            else if(sum > number) {
                endPointer--;
            }
            else{
                System.out.println(input[beginningPointer] + " " + input[endPointer]);
                break;
            }
        }
    }
}
