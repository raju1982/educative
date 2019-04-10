package stackandQueue.play;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.Exception;

class QueuePlay{

    public static void ReversingFirstkElementsOfQueue(Queue<Integer> input, int k){

        Stack<Integer> data = new Stack<>();
        Queue<Integer> door = new LinkedList<>();

        while(k>0){
            data.push(input.poll());
            k--;
        }

        while(!input.isEmpty()){
            door.offer(input.poll());
        }

        while(!data.isEmpty()){
            input.offer(data.pop());
        }

        while(!door.isEmpty()){
            input.offer(door.poll());
        }

    }

    public static void main(String[] args){
        LinkedList<Integer> data = new LinkedList<>();
        data.add(5);
        data.add(15);
        data.add(4);
        data.add(7);
        data.add(17);

        ReversingFirstkElementsOfQueue(data, 3 );

        System.out.println("hello");
    }


}