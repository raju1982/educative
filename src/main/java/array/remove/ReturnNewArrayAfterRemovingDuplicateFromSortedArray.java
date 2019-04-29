package array.remove;

import java.util.Arrays;

public class ReturnNewArrayAfterRemovingDuplicateFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int i = 0;
        nums[i++] = nums[0];
        for(int j = 1; j < nums.length; j++){
            if(nums[j] != nums[j-1]){
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int res = removeDuplicates(arr);
        System.out.println(res);
    }

}