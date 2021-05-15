package theory.array;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class removeDuplicateFromUnsortedArray {

    public static int[] removeDuplicate(int[] input){
        Set<Integer> data = new HashSet<>();
        for(int i=0; i<input.length; i++){
            data.add(input[i]);
        }
        int[] result = new int[data.size()];
        int i=0;
        for(int val : data){
            result[i++] = val;
        }
        return result;
    }


    public static void main(String[] args) {
        int arr[] = {1, 5, 2, 3, 4, 3, 4, 2, 5};
        int[] res = removeDuplicate(arr);
        System.out.println(Arrays.toString(res));
    }
}
