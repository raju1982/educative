package theory.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
O(log N) time to insert (enqueing) and delete (dequeing) each element in the priority queue.
For the remove(Object) and contains(Object) methods, the time complexity is linear
For the retrieval methods, it has constant time complexity
*/



public class ImplementMInAndMaxHeapUsingProirityQueue {

    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);

        /*
                PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
         */


        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        int[] ia = {1, 10, 5, 3, 4, 7, 6, 9, 8};

        for (int item : ia) {
            minHeap.add(item);
            maxHeap.add(item);
        }

        System.out.println("Min heap:");

        while (minHeap.size() != 0) {
            System.out.print(minHeap.peek() + " ");
            System.out.print(minHeap.poll() + " ");
        }

        System.out.println("\nMax heap:");
        while (maxHeap.size() != 0) {
            System.out.print(maxHeap.peek() + " ");
            System.out.print(maxHeap.poll() + " ");
        }
    }


}
