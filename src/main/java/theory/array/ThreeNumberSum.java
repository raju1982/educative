package theory.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        List<Integer[]> result = new ArrayList<>();
        Arrays.sort(array);

        for(int i=0; i<array.length-2; i++){
            int low = i+1;
            int high = array.length-1;
            if(i>0 && array[i] == array[i-1]){
                continue;
            }
            while(low<high){
                int tmpSum = array[i] + array[low] + array[high];
                if(tmpSum == targetSum){
                    result.add(new Integer[]{array[i], array[low], array[high]});
                    low++;
                    high--;
                }
                else if (tmpSum>targetSum){
                    high--;
                }
                else{
                    low++;
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        List<Integer[]> finalResult = threeNumberSum(new int[] {12,3,1,2,-6,5,-8,6}, 0);
        System.out.println(finalResult);
    }
}
