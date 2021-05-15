package theory.array;

import java.util.Arrays;

public class RemoveEvenIntegersFromUnsortedArray {
    public static int[] arrayCoversion(int[] input){
        if(input == null){
            throw new IllegalArgumentException();
        }
        int count=0;

        for(int i=0; i<input.length; i++){
            if(input[i]%2 != 0){
                count++;
            }
        }
        int[] output = new int[count];
        for(int i=0, j=0; i<input.length; i++){
            if(input[i]%2 != 0){
                output[j] = input[i];
                j++;
            }
        }

        return output;
    }

    public static void main(String[] args){
        int[] output = arrayCoversion(new int[] {5,8,9,1,3,4,6,11});

        System.out.println(Arrays.toString(output));
    }

}


