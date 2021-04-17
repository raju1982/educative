package theory.heap;

import java.util.PriorityQueue;

public class BuyingTheMaximumItemsWithAGivenSum {

    public static int solution(int[] input, int totalSum){
        //add all values into a min heap
        PriorityQueue<Integer> queue = new PriorityQueue<>(input.length);
        for(int i: input){
            queue.add(i);
        }
        int count = 0;
        int tmpValue = 0;

        //if totalSum is less than min value in array. [count = 0]
        while(!queue.isEmpty()){
            if(tmpValue+queue.peek() <= totalSum){
                count++;
                tmpValue = tmpValue + queue.poll();
            }
            else{
                break;
            }
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[]{20, 10, 5, 30, 100}, 35));
    }
}
