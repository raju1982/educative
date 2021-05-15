package theory.array;

public class LargestAndSmallestSumContiguousSubarray {

    static int maxSubArraySum(int[] arr){
        int res = arr[0];
        int maxEnding = arr[0];

        for(int i = 1; i < arr.length; i++){
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            res = Math.max(maxEnding, res);
        }

        return res;
    }

    static int lowestSubArraySum(int a[]){
        int min_so_far = a[0];
        int min_ending_here = a[0];

        for (int i = 1; i < a.length; i++)
        {
            min_ending_here = Math.min(a[i], min_ending_here+a[i]);
            // update min_so_far
            min_so_far = Math.min(min_so_far, min_ending_here);
        }
        return min_so_far;
    }


    public static void main (String[] args){
        int [] a = {-2, -3, 4, -1, 2, -1, 5, -3};
        System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));


        int arr[] = {3, -4, 2, -3, -1, 7, -5};
        System.out.println("Minimum contiguous sum is " + lowestSubArraySum(arr));
    }

}
