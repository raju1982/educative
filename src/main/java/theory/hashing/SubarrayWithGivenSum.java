package theory.hashing;

import java.util.Set;
import java.util.HashSet;

public class SubarrayWithGivenSum {

    static boolean isSum(int[] input, int sum) {
        Set<Integer> set = new HashSet<>();
        int pre_sum = 0;
        for (int j : input) {
            if (pre_sum == sum) {
                return true;
            }
            pre_sum += j;
            if (set.contains(pre_sum - sum)) {
                return true;
            }
            set.add(pre_sum);
        }
        return false;
    }

    public static void main (String[] args){
        int[] arr = {5, 8, 6, 13, 3, -1};
        int sum=22;
        System.out.println(isSum(arr, sum));
    }
}
