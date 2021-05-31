package theory.array;

public class FindMaximumCircularSumSubarrayOfGivenArray {

    public static int maxSumSubArray(int[] input){
        int maxSum = input[0];
        int runningSum = input[0];
        for(int i=1; i<input.length; i++){
            runningSum = Math.max(input[i], input[i] + runningSum);
            maxSum = Math.max(runningSum, maxSum);
        }
        return maxSum;
    }

    public static int minSumSubArray(int[] input){
        int maxSumSubArray = maxSumSubArray(input);
        int sum = 0;
        for(int i=0; i<input.length; i++){
            sum = sum + input[i];
            input[i] = -input[i];
        }
        System.out.println("minSumSubArray = " + maxSumSubArray(input));
        int circularSumSubArray = sum + maxSumSubArray(input);

        return Math.max(maxSumSubArray, circularSumSubArray);
    }

    public static void main (String[] args){
        int [] input = {8, -4, 3, -5, 4};
        System.out.println("Maximum contiguous sum is " + maxSumSubArray(input));
        System.out.println("Minimum contiguous sum is " + minSumSubArray(input));
    }

}
