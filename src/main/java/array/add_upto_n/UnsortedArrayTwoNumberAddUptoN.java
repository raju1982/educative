package array.add_upto_n;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

class UnsortedArrayTwoNumberAddUptoN {

   public static int[] sum100(int[] input, int sum){

        List hMap = new ArrayList<>();
        int[] result = new int[2];

        for(int i=0; i<input.length; i++){
            hMap.add(sum-input[i]);
        }

        for(int i=0; i<input.length; i++){
            if(hMap.contains(input[i])){
                result[0] = input[i];
                result[1] = sum-input[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //System.out.println(profit(new int[] {3,5,6,3,12,2,8,5,12}));
        int[] input = new int[]{10,11,20,4,5,9,6};
        //sum(input, 15);
        //System.out.println(Arrays.toString(sum(input, 15)));
        System.out.println(Arrays.toString(sum100(input, 15)));
    }

}

/* bad solution
    public static int[] sum(int[] input, int sum){

        Map<Integer, Boolean> hMap = new HashMap<>();
        int[] result = new int[2];

        for(int i=0; i<input.length; i++){
            hMap.put(sum-input[i],true);
        }

        for(int i=0; i<input.length; i++){
            if(hMap.containsKey(input[i])){
                result[0] = input[i];
                result[1] = sum-input[i];
            }
        }
        return result;
    }
 */