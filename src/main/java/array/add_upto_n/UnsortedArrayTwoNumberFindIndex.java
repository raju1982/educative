package array.add_upto_n;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UnsortedArrayTwoNumberFindIndex {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            if(m.get(target-nums[i]) != null){
                return new int[]{m.get(target-nums[i]), i};
            }
            m.put(nums[i],i);
        }
        return new int[]{0,0};
    }

    public static void main(String[] args) {
        int[] input = new int[]{12,11,20,4,5,9,7};
        System.out.println(Arrays.toString(twoSum(input, 15)));

        input = new int[]{3,3};
        System.out.println(Arrays.toString(twoSum(input, 6)));
    }
}
