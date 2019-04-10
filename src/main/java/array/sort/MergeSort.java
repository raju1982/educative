package array.sort;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] input){
        if(input.length < 2){
            return;
        }

        int mid=input.length/2 + input.length%2;
        int[] rightArray = new int[mid];

        for(int i=mid, j=0; i<input.length && j<rightArray.length; i++, j++){
            rightArray[j] = input[i];
        }

        int[] leftArray = new int[input.length-mid];
        for(int i=0; i<mid; i++){
            leftArray[i] = input[i];
        }




        sort(rightArray);
        sort(leftArray);
        merge(rightArray, leftArray, input);
        System.out.println(Arrays.toString(input));
    }


    public static void merge(int[] rightArray, int[]leftArray, int[]input){

        int i=0, j=0, k=0;

        while(i<rightArray.length && j<leftArray.length){

            if(rightArray[i] < leftArray[j]){
                input[k++] = rightArray[i++];
            }
            else{
                input[k++] = leftArray[j++];
            }
        }

        while(i<rightArray.length){
            input[k++] = rightArray[i++];
        }

        while(j<leftArray.length){
            input[k++] = leftArray[j++];
        }

        System.out.println(Arrays.toString(rightArray));
        System.out.println(Arrays.toString(leftArray));
        System.out.println(Arrays.toString(input));

    }



    public static void main(String[] args){
        int[] input = new int[] {5,7,8,2,9,4,10,3};
        sort(input);
        System.out.println(Arrays.toString(input));
    }
}
