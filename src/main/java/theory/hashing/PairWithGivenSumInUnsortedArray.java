package theory.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairWithGivenSumInUnsortedArray {

    static boolean solution(int[] input, int sum){
        Set<Integer> set = new HashSet<>();
        for(int i: input){
            if(set.contains(sum-i)){
                return true;
            }
            set.add(i);
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[]{3,2,8,15,-8}, 17));
        System.out.println(solution(new int[]{2,1,6,3}, 6));
    }
}
