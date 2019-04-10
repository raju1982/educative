package stackandQueue;

public class TwoStackUsingSingleArray {
    int top1;
    int[] data;
    int top2;

    public TwoStackUsingSingleArray(int size){
        data =  new int[size];
        top1 = -1;
        top2=size;
    }

    //top2
    public void headPush(int input){
        if(top1<top2-1) {
            data[--top2] = input;
        }
    }

    //top1
    public void tailPush(int input){
        if(top1<top2-1) {
            data[++top1] = input;
        }
    }

    //top2
    public int headPop(){
        if(top2<data.length) {
            return data[top2++];
        }
        return -1;
    }

    //top1
    public int tailPop(){
        if(top1>0) {
            return data[top1--];
        }
        return -1;
    }
}
