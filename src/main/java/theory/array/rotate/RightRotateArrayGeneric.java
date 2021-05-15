package theory.array.rotate;

import java.util.Arrays;
import java.util.List;

public class RightRotateArrayGeneric {

    public static void rotate(int[] input, int num){
        //input = null -> throw new IllegalArguentException();
        int len = input.length;
        if(num<0){
            num = num + input.length;
        }

        num = num%input.length;

        reverse(input, 0, input.length-1);
        reverse(input, 0, num-1);
        reverse(input, num, input.length-1);
    }

    public static void reverse(int[] input, int min, int max){
        while(min<max){
            swap(min, max, input);
            min++;
            max--;
        }
    }

    public static void swap(int i, int j , int[] input){
        int tmp = input[i];
        input[i] = input[j];
        input[j] =  tmp;
    }

    public static void main(String[] args){
        int[] input = new int[]{1,2,3,4,5,6};
        rotate(input, 3);
        System.out.println(Arrays.toString(input));

        int[] input1 = new int[]{1,2,3,4,5,6};
        rotate(input1, -2);
        System.out.println(Arrays.toString(input1));
        //{1,2,3,4,5,6}
        //[3,4,5,6,1,2]
    }
}

