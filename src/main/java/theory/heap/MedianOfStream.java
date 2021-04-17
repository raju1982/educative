package theory.heap;

import java.util.PriorityQueue;

//The space complexity will be O(N) because, as at any time, we will be storing all the numbers.
public class MedianOfStream {

    static void solution(int[] input){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a1, a2) -> (a2-a1));
        //smaller element goes to maxHeap
        //larger element goes to minHeap
        //maxHeap size will be either same as minHeap size or more than minHeap size by 1.
        //first element is added to maxHeap
        maxHeap.add(input[0]);
        System.out.print((maxHeap.peek() + " "));
        for(int i=1; i<input.length; i++){
            int tmp = input[i];
            if(maxHeap.size()>minHeap.size()){
                if(tmp>maxHeap.peek()){
                    minHeap.add(tmp);
                }
                else{
                    maxHeap.add(tmp);
                    minHeap.add(maxHeap.poll());
                }
                System.out.print((maxHeap.peek()+minHeap.peek())/2.0  + " ");
            }
            else{
                if(tmp>minHeap.peek()){
                    minHeap.add(tmp);
                    maxHeap.add(minHeap.poll());
                }
                else{
                    maxHeap.add(tmp);
                }
                System.out.print((maxHeap.peek() + " "));
            }
        }
    }


    public static void main(String[] args){
        solution(new int[]{12, 15, 10, 5, 8, 7, 16});
    }

}
