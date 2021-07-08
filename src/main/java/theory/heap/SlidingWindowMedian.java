package theory.heap;

import java.util.*;

/*
Time complexity #
The time complexity of our algorithm is O(N*K)O(N∗K) where ‘N’ is the total number of elements in the input array and ‘K’ is the size of the sliding window. This is due to the fact that we are going through all the ‘N’ numbers and, while doing so, we are doing two things:

Inserting/removing numbers from heaps of size ‘K’. This will take O(logK)O(logK)
Removing the element going out of the sliding window. This will take O(K)O(K) as we will be searching this element in an array of size ‘K’ (i.e., a heap).
 */
class SlidingWindowMedian {
    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] res=new double[nums.length-k+1];
        int index=0;
        PriorityQueue<Double> topContainer=new PriorityQueue();
        PriorityQueue<Double> bottomContainer=new PriorityQueue(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++)
        {
            bottomContainer.add((double)nums[i]);
            topContainer.add(bottomContainer.poll());
            if(topContainer.size()>bottomContainer.size())
            {
                bottomContainer.add(topContainer.poll());
            }
            if(i>=k-1)
            {
                if(k%2!=0)
                {
                    res[index++]= bottomContainer.peek();
                } else {
                    res[index++] = (topContainer.peek()+bottomContainer.peek())/2;
                }

                int numToRemove=nums[i-k+1];
                if(bottomContainer.peek()>=numToRemove)
                {
                    bottomContainer.remove((double)numToRemove);
                }else {
                    topContainer.remove((double)numToRemove);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        double[] result = medianSlidingWindow(new int[]{1, 2, -1, 3, 5}, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();


        result = medianSlidingWindow(new int[]{1, 2, -1, 3, 5}, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }

}

//{1, 2, -1, 3, 5}
//{1.5,0.5,1,4}

