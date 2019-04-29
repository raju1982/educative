package array;

import java.util.HashSet;
import java.util.Set;

public class ReturnTrueIfAnyValueAppearsAtLeastTwiceInArray {
    public static boolean dupCheck(int[] input){
        Set<Integer> tmp = new HashSet<>();
        for(int i=0; i<input.length; i++){
            if(tmp.contains(input[i])){
                return true;
            }
            tmp.add(input[i]);
        }
        return false;
    }

    public static void main(String[] args){
        int[] input = new int[]{1,2,3,4,5,6};
        System.out.println(dupCheck(input));
        input = new int[] {1,1,1,3,3,4,3,2,4,2};
        System.out.println(dupCheck(input));
    }

}

