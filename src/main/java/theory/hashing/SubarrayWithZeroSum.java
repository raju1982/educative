package theory.hashing;

import java.util.HashSet;
import java.util.Set;

public class SubarrayWithZeroSum {
    public static void main (String[] args) {
        System.out.println(ZeroSumSubArray(new int[] {1,4,13,-3,-10,5}));
    }

    static boolean ZeroSumSubArray(int[] input){
        Set<Integer> set = new HashSet<>();
        int prefix_sum = 0;
        for (int j : input) {
            prefix_sum += j;
            if (set.contains(prefix_sum)) {
                System.out.println(set);
                return true;
            }
            if(prefix_sum==0){
                return true;
            }
            set.add(prefix_sum);
        }
        return false;
    }
}

