package stackandQueue.tmp;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.LinkedList;

public class Temp{

    public static void sort(Stack<Integer> input){
        Stack<Integer> result = new Stack<>();

        while(!input.isEmpty()){
            int tmp = input.pop();

            if(result.isEmpty()){
                result.push(tmp);
                continue;
            }

            if(tmp>=result.peek()){
                result.push(tmp);
            }
            else{
                while(!result.isEmpty()){
                    input.push(result.pop());
                }
                result.push(tmp);
            }
        }

        while(!result.isEmpty()){
            input.push(result.pop());
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

        System.out.println();
    }



}