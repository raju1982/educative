package stackandQueue;

import java.util.Stack;

public class StackMinGivesMinimumValueInO1 {

    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    //pop
    public int pop(){
        int val = mainStack.pop();
        //if(val == minStack.peek()){
            minStack.pop();
        //}
        return val;
    }


    //min
    public int min(){
        return minStack.peek();
    }

    //push
    public void push(int input){

        mainStack.push(input);

        if(minStack.isEmpty()){
            minStack.push(input);
        }

        if(input < minStack.peek()){
            minStack.push(input);
        }

    }

    public static void main(String[] args){
        StackMinGivesMinimumValueInO1 data =  new StackMinGivesMinimumValueInO1();
        data.push(5);
        data.push(8);
        data.push(3);
        data.push(9);
        data.push(7);
        data.push(1);

        System.out.println(data.min());
        System.out.println(data.pop());
        System.out.println(data.min());

        data.push(12);
        data.push(1);
        data.push(6);

        System.out.println(data.min());
    }


}


/*
public class Temp {

    int[] data;
    int index = -1;
    int size = 10;
    int[] minArray;

    Temp(){
        data = new int[size];
        minArray = new int[size];
    }

    public void push(int input){
        //stack overflow exception

        data[++index] = input;
        int min = input;

        for(int i=index-1; i>=0; i--){
            if(min>data[i]){
                min = data[i];
            }
        }
        minArray[index] = min;
    }

    public int min(){
        //emptystackexception
        return minArray[index];
    }

    public int pop(){
        return data[index--];
    }

    public static void main(String[] args){
        Temp data = new Temp();
        data.push(5);
        data.push(8);
        data.push(3);
        data.push(9);
        data.push(7);
        data.push(1);

        System.out.println(data.min());
        System.out.println(data.pop());
        System.out.println(data.min());

        data.push(12);
        data.push(1);
        data.push(6);

        System.out.println(data.min());
    }
}
 */