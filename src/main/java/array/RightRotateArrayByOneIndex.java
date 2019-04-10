package array;

import java.util.Arrays;

public class RightRotateArrayByOneIndex {
    public static void rotate(int[] input){

        int tmp = input[input.length-1];
        for(int i=input.length-1; i>0; i--){
            input[i]=input[i-1];
        }

        input[0]=tmp;
    }



    public static int[] rotate2(int[] input){
        int[] output = new int[input.length];

        for(int i=input.length-1; i>0;i--){
            output[i-1] = input[i];
        }
        output[input.length-1] = input[0];
        return output;
    }

    public static void main(String[] args) {
        //System.out.println(profit(new int[] {3,5,6,3,12,2,8,5,12}));
        int[] input = new int[]{0, 3, 5, 6, 8, 12};
        rotate(input);
        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(rotate2(new int[]{0, 3, 5, 6, 8, 12})));
    }
}
