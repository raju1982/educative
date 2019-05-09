package array;

import java.util.Arrays;

public class MaxProductOfTwoNumbersInArrayAndMaxProductOfTwoAdjacentNumbersInArray {
    public static int MaxProductOfTwoAdjacentNumbersInArray(int[] input){
        //null ->
        //length < 2
        int max = input[0]*input[1];
        for(int i=0; i<input.length-1; i++){
            int tmp = input[i]*input[i+1];
            if(max<tmp){
                max=tmp;
            }
        }
       return max;
    }

    public static int MaxProductOfTwoNumbersInArray(int[] input){
        //IllegalArgumentException -> null ||  input.length < 2
        Arrays.sort(input);
        int[] result = new int[2];
        result[0]=input[input.length-1];
        result[1]=input[input.length-2];
        return result[0]*result[1];
    }

    public static void main(String[] args){
        System.out.println(MaxProductOfTwoAdjacentNumbersInArray(new int[] {8,1,4,7,10,1,15}));
        System.out.println(MaxProductOfTwoNumbersInArray(new int[] {8,1,4,7,10,1,15}));
    }
}
