package array.rotate_rearrange_reorder;

import java.util.Arrays;

public class moveZeroToRIght {
    public static void solution(int[] input){
        //illegalArgumentExcpetion -> null, input.length == 0
        int readIndex=0;
        int writeIndex=0;

        while(readIndex<input.length){
            if(input[readIndex]!=0){
                swap(writeIndex, readIndex, input);
                writeIndex++;
            }
            readIndex++;
        }

    }

    public static void swap(int i, int j, int[] input){
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

    public static void main(String[] str){
        int[] input = new int[]{0,1,0,3,12};
        solution(input);
        System.out.println(Arrays.toString(input));

        input = new int[]{0,1,0,-3,12,-4,7, 10};
        solution(input);
        System.out.println(Arrays.toString(input));
    }
}
