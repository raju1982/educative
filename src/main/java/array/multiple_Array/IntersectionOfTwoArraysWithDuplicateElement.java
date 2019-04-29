package array.multiple_Array;
/*
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */

import java.util.*;

public class IntersectionOfTwoArraysWithDuplicateElement {
    public static int[] interection(int[] input1, int[] input2){
        Map<Integer, Integer> data = new HashMap<>();
        for(int i=0 ; i<input1.length; i++){
            if(data.containsKey(input1[i])){
                data.put(input1[i], data.get(input1[i]) + 1);
            }
            else{
                data.put(input1[i], 1);
            }

        }

        List<Integer> resultList = new ArrayList<>();
        for(int i=0 ; i<input2.length; i++){
            if(data.containsKey(input2[i]) && data.get(input2[i])>0){
                resultList.add(input2[i]);
                data.put(input2[i], data.get(input2[i])-1);
            }
        }

        int[] result = new int[resultList.size()];
        int i=0;
        for(int num: resultList){
            result[i++] = num;
        }
        return result;
    }


    public static void main(String[] args){
        int[] nums1 = new int[] {1,2,2,1};
        int[] nums2 = new int[] {2,2};
        System.out.println(Arrays.toString(interection(nums1, nums2)));
        nums1 = new int[] {4,9,5};
        nums2 = new int[] {9,4,9,8,4};
        System.out.println(Arrays.toString(interection(nums1, nums2)));
    }
}
