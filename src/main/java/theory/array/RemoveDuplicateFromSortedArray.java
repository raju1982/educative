package theory.array;

import java.util.Arrays;

public class RemoveDuplicateFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int index = 1;
        for(int j = 1; j < nums.length; j++){
            if(nums[j] != nums[j-1]){
                nums[index++] = nums[j];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int res = removeDuplicates(arr);
        System.out.println(res);
        System.out.println(Arrays.toString(arr));
    }

}