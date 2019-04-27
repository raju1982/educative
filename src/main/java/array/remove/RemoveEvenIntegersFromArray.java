package array.remove;

import java.util.Arrays;

public class RemoveEvenIntegersFromArray {
    //5
    /*public static int minValue(int[] data){

        int min = data[0];
        for(int i=0; i<data.length-1; i++){
            if(min>data[i]){
                min = data[i];
            }
        }
        return min;
    }

    public static void main(String[] args){
         System.out.println(minValue(new int[] {5,7,8,1,3,18,10}));
    }
    */

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


