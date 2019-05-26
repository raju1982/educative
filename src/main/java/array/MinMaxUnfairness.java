package array;

/*
You will be given a list of integers, , and a single integer . You must create an array of length from elements of such that its unfairness is minimized.
Call that array . Unfairness of an array is calculated as

Where:
- max denotes the largest integer in
- min denotes the smallest integer in

As an example, consider the array  with a  of . Pick any two elements, test .

Testing for all pairs, the solution  provides the minimum unfairness.
 */

import java.util.Arrays;

public class MinMaxUnfairness {
    static int maxMin(int k, int[] arr) {
        Arrays.sort(arr);
        int currentIndex = 0;
        int nextIndex = k-1;

        int unfairness = arr[nextIndex++] - arr[currentIndex++];
        while(nextIndex < arr.length) {
            int difference = arr[nextIndex++] - arr[currentIndex++];
            if(unfairness > difference) {
                unfairness = difference;
            }
        }
        return unfairness;
    }

    public static void main(String[] args){
        System.out.println(maxMin(3, new int[]{10,100,300,200,20,30}));
    }
}
