package stackandQueue.tmp;

import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.EmptyStackException;

public class Temp {
    private int[] data;
    private int size=10;
    private int index=-1;
    private int min=0;

    public Temp(){
        data = new int[size];
    }

    public boolean isEmpty(){
        return min>index?true:false;
    }

    public void push(int num){
        if(index>size-1){
            throw new StackOverFlowException();
        }
        data[++index] = num;
    }

    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }

        return data[min++];
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return data[min];
    }

    public static void main(String[] args){
        Temp data = new Temp();
        System.out.println(data.isEmpty());
        data.push(1);
        System.out.println(data.isEmpty());
        data.push(2);
        data.push(3);
        System.out.println(data.pop());
        System.out.println(data.peek());
        System.out.println(data.pop());
        System.out.println(data.isEmpty());
        System.out.println(data.pop());
        System.out.println(data.isEmpty());
    }
}

class StackOverFlowException extends RuntimeException{

}