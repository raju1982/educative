package array;

import java.util.Map;
import java.util.HashMap;

public class NonRepeateIntergerImpl {
    public static int nonRepeateInterger(int[] input){
        //null ->illegalargumentexcpetion

        Map<Integer, Integer> data = new HashMap<>();

        for(int i=0; i<input.length; i++){
            if(data.containsKey(input[i])){
                data.put(input[i], data.get(input[i]) + 1);
            }
            else{
                data.put(input[i], 1);
            }
        }

        for(int i=0; i<input.length; i++){
            if(data.get(input[i]) == 1){
                return input[i];
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[] input = new int[]{2,12,4,1,15,18,5,7,2,12,9};
        System.out.println(nonRepeateInterger(input));
    }
}
