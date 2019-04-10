package array;

import java.util.Arrays;

//quicksort -> pivot is zero
public class ReArrangePositiveANDNegativeValues {

    public static void reArrange(int[] input){

        int indexA = 0;
        int indexB = input.length-1;

        while(indexA<indexB){
            //get a postive Math
            while(input[indexA]<0){
                indexA++;
            }
            //get a negative Math
            while(input[indexB]>0){
                indexB--;
            }

            if(indexA<indexB) {
                swap(indexA, indexB, input);
            }
        }

    }

    public static void swap(int indexA, int indexB, int[] input){
        int tmp = input[indexA];
        input[indexA] = input[indexB];
        input[indexB] = tmp;
    }

    //another implementation
    public static void ReArrange(int[] input){
        int[] sol = new int[input.length];
        int j=0;
        for(int i=0; i<input.length; i++){
            if(input[i]<0){
                sol[j++]=input[i];
            }
        }

        for(int i=0; i<input.length && j<input.length; i++){
            if(input[i]>0){
                sol[j++]=input[i];
            }
        }

        for(int i=0; i<input.length; i++){
            input[i] = sol[i];
        }
    }

    public static void main(String[] args) {
        //System.out.println(profit(new int[] {3,5,6,3,12,2,8,5,12}));
        int[] input = new int[]{10,-1,20,4,5,-9,-6};
        ReArrange(input);
        System.out.println(Arrays.toString(input));
    }

}
