package theory.array.sort;

import java.util.Arrays;

public class QuickSort {

    private static int pivot(int[] input, int l, int h){
        int pivot = input[l];
        int low = l;
        int high = h;

        while(low<high){

            while(input[low]<=pivot && low<high){
                low++;
            }

            while(input[high]>pivot){
                high--;
            }

            if(low<high){
                swap(input, low, high);
            }
        }
        swap(input, l, high);
        return high;
    }

    private static void swap(int[] input, int l, int h){
        int tmp = input[l];
        input[l] = input[h];
        input[h] = tmp;
    }

    public static void sort(int[] input, int l, int h){
        if (l < h) {
            int pivot = pivot(input, l, h);
            sort(input, l, pivot - 1);
            sort(input, pivot + 1, h);
        }
    }

    public static void main(String[] args){
        int[] input = new int[]{5, 7, 8, 2, 9, 4, 10, 3};
        sort(input, 0, input.length-1);
        System.out.println(Arrays.toString(input));
    }

}
