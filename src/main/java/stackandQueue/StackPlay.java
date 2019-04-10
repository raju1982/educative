package stackandQueue;

public class StackPlay {

    int[] data;
    int tail = -1;

    public StackPlay(int size){
        data = new int[size];
    }

    public boolean isEmpty(){
        if(tail == -1){
            return true;
        }
        return false;
    }

    public void push(int input){
        if(tail == data.length-1){
            throw new RuntimeException("stack overflow exception");
        }
        data[++tail] = input;
    }

    public int pop(){
        return data[tail--];
    }

}
