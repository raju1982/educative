package stackandQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class ReversingFirstkElementsOfQueue {

    public static void reverseKelement(Queue<Integer> queue, int k ){
        Stack<Integer> stack = new Stack<Integer>();
        int count=0;

        while(count<k){
            stack.push(queue.poll());
            count++;
        }

        while(!stack.isEmpty()){
            queue.offer(stack.pop());
        }

        count = queue.size() - k;
        while(count > 0){
            queue.offer(queue.poll());
            count--;
        }
    }

    public static void main(String[] args){
        LinkedList<Integer> data = new LinkedList<>();
        data.add(5);
        data.add(15);
        data.add(4);
        data.add(7);
        data.add(17);

        reverseKelement(data, 3 );

        System.out.println("hello");
    }



}
