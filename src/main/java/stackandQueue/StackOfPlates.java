package stackandQueue;
import java.util.Stack;

public class StackOfPlates {

    //https://github.com/wzhishen/cracking-the-coding-interview/blob/master/src/chap03/Q3.java

}

/*
public class Temp {

    Stack<Stack<Integer>> data = new Stack<>();
    int size=3;

    public Temp(){
        data.push(new Stack<>());
    }

    public void push(int input){
        if(data.peek().size() == size){
            Stack<Integer> tmp = new Stack<>();
            data.push(tmp);
        }
        data.peek().push(input);
    }

    public int pop(){
        if(data.peek().isEmpty()){
            data.pop();
        }
        return data.peek().pop();
    }

    public static void main(String[] args){
        Temp data = new Temp();
        data.push(5);
        data.push(8);
        data.push(3);
        data.push(9);
        data.push(7);
        data.push(1);
        data.push(12);
        System.out.println(data.pop());
        System.out.println(data.pop());
        data.push(1);
        data.push(6);
        System.out.println(data.pop());
    }
}
 */