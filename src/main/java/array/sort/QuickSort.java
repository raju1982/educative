package array.sort;

import java.util.Arrays;

public class QuickSort {


    public static int findPivot(int[] input, int low, int high) {
        int pivot = input[low];
        int l = low;
        int h = high;

        while (l < h) {

            while (input[l] <= pivot && l < h) {
                l++;
            }

            while (input[h] > pivot) {
                h--;
            }

            if (l < h) {
                swap(input, l, h);
            }
        }

        swap(input, h, low);
        return h;

    }

    public static void swap(int[] input, int l, int h) {
        int tmp = input[l];
        input[l] = input[h];
        input[h] = tmp;
    }

    public static void sort(int[] input, int low, int high) {
        if (low >= high) {
            return;
        }

        int h = findPivot(input, low, high);
        sort(input, low, h - 1);
        sort(input, h+1, high);
    }


    public static void main(String[] args) {
        int[] input = new int[]{5, 7, 8, 2, 9, 4, 10, 3};
        sort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));
    }


}
