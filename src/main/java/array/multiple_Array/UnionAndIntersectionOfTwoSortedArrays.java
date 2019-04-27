package array.multiple_Array;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class UnionAndIntersectionOfTwoSortedArrays {

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
    }

    public static int[] removeDuplicate(int[] input){
        int[] tmp = new int[input.length];

        int j=0;
        for(int i=0; i<input.length-1; i++){
            if(input[i]!=input[i+1]){
                tmp[j++] = input[i];
            }
        }

        tmp[j] = input[input.length-1];

        int[] result = new int[j+1];
        for(int i=0; i<=j; i++){
            result[i] = tmp[i];
        }
        return result;
    }

    static Integer[] intersection(int arr1[], int arr2[])
    {
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<Integer>();
        while (i < arr1.length && j < arr2.length)
        {
            if (arr1[i] < arr2[j])
                i++;
            else if (arr2[j] < arr1[i])
                j++;
            else
            {
                result.add(arr2[j++]);
                i++;
            }
        }

        Integer[] res = new Integer[result.size()];
        res = result.toArray(res);
        return res;
    }

    public static void main(String args[]){
        int arr1[] = {1, 2, 4, 5, 6};
        int arr2[] = {2, 3, 5, 7};
        int solution[] = new int[arr1.length + arr2.length];
        merge(arr1, arr2, solution);
        //merge
        System.out.println(Arrays.toString(solution));
        //merge without duplicates
        System.out.println(Arrays.toString(removeDuplicate(solution)));

        System.out.println(Arrays.toString(intersection(arr1, arr2)));
        //Collections.intersection(arr1, arr2);
    }

}
