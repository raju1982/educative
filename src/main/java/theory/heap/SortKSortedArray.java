package theory.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortKSortedArray {

    public static void sort(int[] input, int k){
        //k size min heap
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for(int i=0; i<=k; i++){
            queue.add(input[i]);
        }
        //queue = {2, 3, 6, 12}
        int index=0;
        for(int i=k+1; i<input.length; i++){
            input[index++] = queue.poll();
            queue.add(input[i]);
        }
        // queue = {6, 8, 12, 56}
        // input = {2, 3, 3, 12, 56, 8}

        while(!queue.isEmpty()){
            input[index++] = queue.poll();
        }
    }

    public static void main(String[] args){
        int arr[] = { 2, 6, 3, 12, 56, 8 };
        System.out.println(Arrays.toString(arr));
        sort(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

}
