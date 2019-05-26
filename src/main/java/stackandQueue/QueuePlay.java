package stackandQueue;

public class QueuePlay{
    int[] data;
    int front;
    int back;
    int numberOfitems;

    public QueuePlay(int size){
        data = new int[size];
        front=0;
        back=-1;
    }

    public boolean isEmpty(){
        if(numberOfitems == 0)
            return true;
        return false;
    }

    public boolean isFull(){
        if(numberOfitems==data.length){
            return true;
        }
        return false;
    }

    //enqueue add back
    public void enqueue(int input){
        if(isFull()){
            throw new RuntimeException("queue is full.");
        }
        /*if (back == data.length - 1) {
            back = -1;
        }*/
        numberOfitems++;
        data[++back] = input;
    }

    public int dequeue(){
        if(isEmpty()){
            throw new RuntimeException("stack is empty.");
        }
        if (front == numberOfitems ) {
            front = 0;
        }
        numberOfitems--;
        return data[front++];
    }
}