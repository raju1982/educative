package string.sorting;

import java.util.Arrays;

public class MergeSortImpl {

    public static void sort(String[] input){
        if(input.length < 2){
            return;
        }

        int mid=input.length/2 + input.length%2;
        String[] rightArray = new String[mid];
        String[] leftArray = new String[input.length-mid];

        int i=0,j=0;
        while(i<input.length){
            if(i<rightArray.length){
                rightArray[i]=input[i];
            }
            else{
                leftArray[j]=input[i];
                j++;
            }
            i++;
        }

        sort(rightArray);
        sort(leftArray);
        merge(rightArray, leftArray, input);
    }


    public static void merge(String[] rightArray, String[]leftArray, String[]input){

        int i=0, j=0, k=0;

        while(i<rightArray.length && j<leftArray.length){

            if(rightArray[i].compareTo(leftArray[j]) < 0){
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
    }


    public static void main(String[] args){
        String[] input = new String[] {"Kring", "Panda", "Soliel", "Darryl", "Chan", "Matang", "Jollibee.", "Inasal"};
        sort(input);
        System.out.println(Arrays.toString(input));
    }
}


