package array;

import java.util.Map;
import java.util.HashMap;

public class TwoUnsortedArraysWithDuplicatesHaveSameElement {

    public static boolean compare(int[] inputOne, int[] inputTwo){
        Map<Integer, Integer> data = new HashMap<>();
        for(int i=0; i<inputOne.length; i++){
            if(data.containsKey(inputOne[i])){
                data.put(inputOne[i], data.get(inputOne[i]) + 1);
            }
            else{
                data.put(inputOne[i], 1);
            }
        }

        for(int i=0; i<inputTwo.length; i++){
            if(data.containsKey(inputTwo[i]) && data.get(inputTwo[i])>0){
                data.put(inputTwo[i], data.get(inputTwo[i]) - 1);
            }
            else{
                return false;
            }
        }

        for(Map.Entry<Integer, Integer> tmp : data.entrySet()){
            if(tmp.getKey() != 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        int[] inputOne = {2, 5, 6, 8, 10, 2, 2};
        int[] inputTwo = {2, 5, 5, 6, 8, 5, 6};
        System.out.println (compare(inputOne, inputTwo));

        inputOne = new int[] {2, 5, 8, 6, 10, 2, 2};
        inputTwo = new int[] {2, 5, 6, 8, 2, 10, 2};
        System.out.println (compare(inputOne, inputTwo));

    }
}




/*Input : A = {2, 5, 6, 8, 10, 2, 2}
        B = {2, 5, 5, 6, 8, 5, 6}
Output : No

Input : A = {2, 5, 6, 8, 2, 10, 2}
        B = {2, 5, 6, 8, 2, 10, 2}
Output : Yes

Input : A = {2, 5, 8, 6, 10, 2, 2}
        B = {2, 5, 6, 8, 2, 10, 2}
Output : Yes*/