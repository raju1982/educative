package theory.array;

import java.util.Arrays;

public class ReverseAnArray {
    public static void reverse(int[] input){
        if(input.length<2){
            return;
        }
        int i=0;
        int j=input.length-1;
        while(i<j){
            int tmp = input[i];
            input[i] = input[j];
            input[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args){
        int[] input = new int[] {10,5,7,30};
        reverse(input);
        System.out.println(Arrays.toString(input));
    }
}
