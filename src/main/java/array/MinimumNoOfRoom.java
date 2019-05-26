package array;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
//https://www.youtube.com/watch?v=x7eABYgjN5c

public class MinimumNoOfRoom {

    public static int calculate(Map<Integer, Integer> input, int day){
        int[] data = new int[day+1];
        for(Map.Entry<Integer, Integer> tmp :input.entrySet()){
            for(int i=tmp.getKey(); i<= day && i<=tmp.getValue(); i++){
                data[i] = data[i] + 1;
            }
            System.out.println(Arrays.toString(data));
        }
        return data[day];
    }

    public static void main(String[] args){
        Map<Integer, Integer> input = new HashMap<>();
        input.put(1,3);
        input.put(2,5);
        input.put(3,7);
        input.put(6,8);

        System.out.println(calculate(input, 3));
    }

}
