package stackandQueue.play;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Play {

    public static String decimalTOBinary(int number) {

        Stack<Integer> data = new Stack<>();

        while (number > 0) {
            data.push(number % 2);
            number = number / 2;
        }

        StringBuilder str = new StringBuilder();

        while (!data.isEmpty()) {
            str.append(data.pop());
        }
        return str.toString();
    }


    public static void revesing(Queue<Integer> input, int reverse) {
        Stack<Integer> data = new Stack<>();
        int count = 1;

        while (count <= reverse) {
            data.push(input.poll());
            count++;
        }

        while (!data.isEmpty()) {
            input.offer(data.pop());
        }

        count = input.size() - reverse;

        while (count > 0) {
            input.offer(input.poll());
            count--;
        }

    }


    public static void sorting(Stack<Integer> input) {

        Stack<Integer> tmp = new Stack<>();

        while (!input.isEmpty()) {
            int val = input.pop();

            if (tmp.isEmpty()) {
                tmp.push(val);
            } else {
                if (val >= tmp.peek()) {
                    tmp.push(val);
                } else {
                    while (!tmp.isEmpty()) {
                        input.push(tmp.pop());
                    }
                    tmp.push(val);
                }
            }
        }
        while (!tmp.isEmpty()) {
            input.push(tmp.pop());
        }

    }


    public static Map<Integer, Integer> nextElement(int[] input) {
        Stack<Integer> data = new Stack<>();
        Map<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            while (!data.isEmpty()) {
                if (input[i] < data.peek()) {
                    data.push(input[i]);
                    break;
                } else {
                    result.put(data.pop(), input[i]);
                }
            }

            if (data.isEmpty()) {
                data.push(input[i]);
            }
        }
        return result;
    }


    public static void experiment(){
        Stack<Stack<String>> tmp = new Stack<>();



    }

    public static String decimalToBinary(int number){
        if(number<0){
            throw new IllegalArgumentException();
        }
        Stack<Integer> tmp = new Stack<>();
        while(number>0){
            tmp.push(number%2);
            number=number/2;
        }
        StringBuilder result = new StringBuilder();
        while(!tmp.isEmpty()){
            result.append(tmp.pop());
        }

        return result.toString();
    }

    public static void ReversingFirstkElementsOfQueue(Queue<Integer> data, int input){

        if(data == null){
            throw new IllegalArgumentException();
        }

        if(data.size() == 1){
            return;
        }

        Stack<Integer> tmp = new Stack<>();
        int tmp3 = input;
        while(tmp3>0){
            tmp.push(data.poll());
            tmp3--;
        }

        while(!tmp.isEmpty()){
            data.offer(tmp.pop());
        }

        int tmp2=data.size()-input;
        while(tmp2>0){
            data.offer(data.poll());
            tmp2--;
        }

    }

    public static boolean CheckForBalancedParentheses(String input) {
        //char[] tmpArray=input.toCharArray();
        Set<Character> closingBracket = new HashSet<>();
        closingBracket.add('}');
        closingBracket.add(')');
        closingBracket.add(']');

        Map<Character, Character> mappingTable = new HashMap<>();
        mappingTable.put('}', '{');
        mappingTable.put(')', '(');
        mappingTable.put(']', '[');

        Stack<Character> tmpStack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char tmp = input.charAt(i);
            if (closingBracket.contains(tmp)) {
                if (tmpStack.pop() != mappingTable.get(tmp)) {
                    return false;
                }
            }
            else {
                tmpStack.add(tmp);
            }
        }
        return true;
    }

    public static void main(String[] str) {
        /*System.out.println(decimalToBinary(7));
        System.out.println(decimalToBinary(6));

        System.out.println(decimalTOBinary(7));
        System.out.println(decimalTOBinary(6));*/

        System.out.println(CheckForBalancedParentheses("{[({})]}"));
        System.out.println(CheckForBalancedParentheses("[{(}]"));

/*
        Queue<Integer> input = new LinkedList<>();
        input.offer(5);
        input.offer(8);
        input.offer(10);
        input.offer(15);
        input.offer(20);
        input.offer(24);

        //revesing(input, 4);
        ReversingFirstkElementsOfQueue(input, 4);

        System.out.println("hello");

        Stack<Integer> inputStack = new Stack<>();
        inputStack.push(5);
        inputStack.push(3);
        inputStack.push(10);
        inputStack.push(2);
        inputStack.push(20);
        inputStack.push(1);

        sorting(inputStack);

        System.out.println("hello");

        Map<Integer, Integer> result = nextElement(new int[] {5,3,2,10,6,8,1,4,12,7,4});

        for(Map.Entry<Integer, Integer> val :result.entrySet()){
            System.out.println(val.getKey() + " " + val.getValue());
        }*/
    }

}
