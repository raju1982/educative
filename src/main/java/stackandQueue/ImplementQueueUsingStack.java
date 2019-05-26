package stackandQueue;
import java.util.Stack;

public class ImplementQueueUsingStack {

    //enqueue
    private Stack<Integer> enqueueStack = new Stack<Integer>();
    private Stack<Integer> dequeueStack = new Stack<Integer>();

    public void enqueue(int input){
        //if(!dequeueStack.isEmpty()) {
            while(!dequeueStack.isEmpty()){
                enqueueStack.push(dequeueStack.pop());
            }
        //}
        enqueueStack.push(input);
    }

    public int dequeue(){
        if(enqueueStack.isEmpty() && dequeueStack.isEmpty()){
            throw new RuntimeException("queue is empty");
        }

        //if(!enqueueStack.isEmpty()) {
            while(!enqueueStack.isEmpty()){
                dequeueStack.push(enqueueStack.pop());
            }
        //}
        return dequeueStack.pop();
    }

    public static void main(String[] args){
        ImplementQueueUsingStack implementQueueUsingStack = new ImplementQueueUsingStack();
        implementQueueUsingStack.enqueue(1);
        implementQueueUsingStack.enqueue(2);
        implementQueueUsingStack.enqueue(3);
        implementQueueUsingStack.enqueue(4);

        System.out.println(implementQueueUsingStack.dequeue());
        System.out.println(implementQueueUsingStack.dequeue());

        implementQueueUsingStack.enqueue(5);
        implementQueueUsingStack.enqueue(6);

        System.out.println(implementQueueUsingStack.dequeue());
        System.out.println(implementQueueUsingStack.dequeue());
    }
}