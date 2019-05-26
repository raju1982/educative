package array;

import java.util.*;
/*
Given an array, print the Next Greater Element (NGE) for every element.
The Next greater Element for an element x is the first greater element on the right side of x in array.
Elements for which no greater element exist, consider next greater element as -1.
 */
public class NextBigElementInSequenceInArray {

    public static Map<Integer, Integer> nextElement(int[] input) {
        Stack<Integer> data = new Stack<>();
        Map<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            while (!data.isEmpty()) {
                //compare input to last stack value
                if (input[i] < data.peek()) {
                    //if input is small at it to stack.
                    data.push(input[i]);
                    break;
                } else {
                    //if input is greater at it to result , key = stack value, val = Math
                    result.put(data.pop(), input[i]);
                }
            }
            //first enter should go to stack.
            if (data.isEmpty()) {
                data.push(input[i]);
            }
        }
        return result;
    }

    //better solution
    public static Map solution(int[] input){
        Map<Integer, Integer> result = new HashMap<>();
        Stack<Integer> data = new Stack<>();

        for(int i=0 ; i<input.length; i++){
            while(!data.isEmpty()){
                int num = data.peek();
                if(num<input[i]){
                    result.put(num, input[i]);
                    data.pop();
                }
                else{
                    break;
                }
            }
            data.push(input[i]);
        }
        return result;
    }

    public static void main(String[] str) {
        Map<Integer, Integer> result = nextElement(new int[] {2,1,6,5,7,4,2,3,5});

        for(Map.Entry<Integer, Integer> val :result.entrySet()){
            System.out.println(val.getKey() + " " + val.getValue());
        }

        System.out.println("\n\n");

        result = solution(new int[] {2,1,6,5,7,4,2,3,5});

        for(Map.Entry<Integer, Integer> val :result.entrySet()){
            System.out.println(val.getKey() + " " + val.getValue());
        }
    }

}
