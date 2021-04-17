package theory.heap;

import java.util.PriorityQueue;

public class CalculateKLargestElementsInAnUnsortedArray {

    public static void solution(int[] input, int K){
        //min heap of size K
        PriorityQueue<Integer> queue = new PriorityQueue<>(K);

        for(int i=0; i<input.length; i++){
            if(i<K){
                queue.add(input[i]);
            }
            else{
                if(input[i]>queue.peek()) {
                    queue.add(input[i]);
                    queue.poll();
                }
            }
        }

        while(!queue.isEmpty()){
            System.out.print(queue.poll() + " ");
        }
    }

    public static void main(String[] args){
        solution(new int[] {11,3,2,1,15,5,4,45,88,96,50,45}, 3);
    }
}
