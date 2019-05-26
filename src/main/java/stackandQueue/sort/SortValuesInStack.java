package stackandQueue.sort;
import java.util.Stack;

public class SortValuesInStack {

    public static void sort(Stack<Integer> input){
        //illegal argument exception null , size=1

        Stack<Integer> tmp = new Stack<>();

        while(!input.isEmpty()){
            int num = input.pop();

            if(!tmp.isEmpty() && num<tmp.peek()){
                while(!tmp.isEmpty()){
                    input.push(tmp.pop());
                }
            }
            tmp.push(num);
        }

        while(!tmp.isEmpty()){
            input.push(tmp.pop());
        }

    }

    public static void main(String[] args){
        Stack<Integer> input = new Stack<>();
        input.push(5);
        input.push(6);
        input.push(3);
        input.push(10);
        input.push(1);

        sort(input);

        while(!input.isEmpty()){
            System.out.println(input.pop());
        }
    }
}
