package stackandQueue.play;
import stackandQueue.ImplementQueueUsingStack;

import java.util.Stack;


class QueueImpl{
    Stack<Integer> firstStack = new Stack<>();
    Stack<Integer> secondStack = new Stack<>();

    public void offer(int i){
        while(!secondStack.isEmpty()){
            firstStack.push(secondStack.pop());
        }
        firstStack.push(i);
    }

    public int poll(){
        while(!firstStack.isEmpty()){
            secondStack.push(firstStack.pop());
        }
        return secondStack.pop();
    }

    public static void main(String[] args){

        QueueImpl implementQueueUsingStack = new QueueImpl();
        implementQueueUsingStack.offer(1);
        implementQueueUsingStack.offer(2);
        implementQueueUsingStack.offer(3);
        implementQueueUsingStack.offer(4);

        System.out.println(implementQueueUsingStack.poll());
        System.out.println(implementQueueUsingStack.poll());

        implementQueueUsingStack.offer(5);
        implementQueueUsingStack.offer(6);

        System.out.println(implementQueueUsingStack.poll());
        System.out.println(implementQueueUsingStack.poll());

    }


}

/*
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

 */