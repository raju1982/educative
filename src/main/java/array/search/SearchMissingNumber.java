package array.search;

public class SearchMissingNumber {
    public static int missingNumber(int[] nums) {
        int sum = 0;
        for(int i : nums) {
            sum += i;
        }

        int min = nums[0];
        for(int i : nums) {
            if(min>i){
                min = i;
            }
        }
        if(min == 0){
            return ((nums.length)*(nums.length + 1))/2 - sum;
        }
        else {
            return ((nums.length + 1) * (nums.length + 2)) / 2 - sum;
        }
    }
    public static void main(String[] args){
        System.out.println(missingNumber(new int[]{3,0,1}));
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println(missingNumber(new int[]{1,2,4,6,3,7,8}));
    }
}
