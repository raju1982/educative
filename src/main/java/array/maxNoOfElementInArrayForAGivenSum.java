package array;
import java.util.Arrays;

public class maxNoOfElementInArrayForAGivenSum {
    public static int maxElementForAGivenSum(int[] input, int sum){
        Arrays.sort(input);

        int count=0, currentSum=0;
        for(int i=0; i<input.length; i++){
            if(currentSum<sum && input[i]<sum){
                int tmp = currentSum + input[i];
                if(tmp<sum){
                    currentSum=tmp;
                    count++;
                }
            }
        }
        return count;
    }
}
