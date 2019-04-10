package stackandQueue;

import java.util.*;

public class NextBigElementInSequenceInArray {

    public static Map<Integer, Integer> nextElement(int[] input) {
        Stack<Integer> data = new Stack<>();
        Map<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            while (!data.isEmpty()) {
                //compare Math to last stack value
                if (input[i] < data.peek()) {
                    //if Math is small at it to stack.
                    data.push(input[i]);
                    break;
                } else {
                    //if Math is greater at it to result , key = stack value, val = Math
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


    public static void main(String[] str) {
        System.out.println("hello");
        //{5,3,2,10,6,8,1,4,12,7,4}
        Map<Integer, Integer> result = nextElement(new int[] {2,1,3,5,7,4,2,3,5});

        for(Map.Entry<Integer, Integer> val :result.entrySet()){
            System.out.println(val.getKey() + " " + val.getValue());
        }
    }

}
