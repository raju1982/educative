package array;

public class LargestAndSmallestSumContiguousSubarray {

    static int maxSubArraySum(int a[])
    {
        int max_so_far = a[0];
        int curr_max = a[0];
        int start;
        int end;

        for (int i = 1; i < a.length; i++)
        {
            curr_max = Math.max(a[i], curr_max+a[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }

    //best solution
    static void printMaxSubArraySum(int a[])
    {
        int max_so_far = Integer.MIN_VALUE;
        int max_current = 0;
        int start = 0;
        int end = 0;
        int s = 0;

        for (int i = 0; i < a.length; i++)
        {
            max_current = max_current + a[i];

            if (max_so_far < max_current)
            {
                max_so_far = max_current;
                start = s;
                end = i;
            }

            if (max_current < 0)
            {
                max_current = 0;
                s = i + 1;
            }
        }
        System.out.println("Maximum contiguous sum is "
                + max_so_far);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);
    }

    static int lowestSubArraySum(int a[])
    {
        int min_so_far = a[0];
        int min_ending_here = a[0];
        int start;
        int end;

        for (int i = 1; i < a.length; i++)
        {
            min_ending_here = Math.min(a[i], min_ending_here+a[i]);
            // update min_so_far
            min_so_far = Math.min(min_so_far, min_ending_here);
        }
        return min_so_far;
    }


    public static void main (String[] args)
    {
        int [] a = {-2, -3, 4, -1, 2, -1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum(a));

        printMaxSubArraySum(a);

        int arr[] = {3, -4, 2, -3, -1, 7, -5};
        System.out.println("Minimum contiguous sum is " + lowestSubArraySum(arr));
    }

}
