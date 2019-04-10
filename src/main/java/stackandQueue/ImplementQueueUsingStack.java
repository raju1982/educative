package stackandQueue;
import java.util.Stack;

public class ImplementQueueUsingStack {

    //enqueue
    private Stack<Integer> tempStack = new Stack<Integer>();
    private Stack<Integer> mainStack = new Stack<Integer>();

    public void enqueue(int input){
        if(!mainStack.isEmpty()) {
            while(!mainStack.isEmpty()){
                tempStack.push(mainStack.pop());
            }
        }
        tempStack.push(input);
    }

    public int dequeue(){
        if(tempStack.isEmpty() && mainStack.isEmpty()){
            throw new RuntimeException("queue is empty");
        }

        if(!tempStack.isEmpty()) {
            while(!tempStack.isEmpty()){
                mainStack.push(tempStack.pop());
            }
        }
        return mainStack.pop();
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