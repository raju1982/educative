package theory.hashing;

import java.util.*;

//Longest Subarray with equal number of 0s and 1s
public class LargestZeroSubarray {

    public static void main(String[] args) {
        System.out.println(largestZeroSubarray( new int[]{1, 1, 1, 0, 1, 0, 1, 1, 1}));
    }

    static int largestZeroSubarray(int[] arr) {
        Map<Integer, Integer> hm = new HashMap<>();
        int sum = 0, maxLen = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == 0) ? -1 : 1;
        }

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0) {
                maxLen = i + 1;
            }
            if (hm.containsKey(sum + n)) {
                if (maxLen < i - hm.get(sum + n)) {
                    maxLen = i - hm.get(sum + n);
                }
            } else {
                hm.put(sum + n, i);
            }
        }
        return maxLen;
    }
}
