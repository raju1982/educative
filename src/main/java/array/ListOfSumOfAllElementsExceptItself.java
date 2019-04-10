package array;

import java.util.Arrays;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class ListOfSumOfAllElementsExceptItself {
    public void sumImpl(int[] input){
        int[] result = new int[input.length];
        int tmp = 0;
        for(int i=0; i<input.length; i++){
            result[i] = tmp;
            tmp = tmp + input[i];
        }
        tmp=0;
        for(int i=input.length-1 ; i>=0; i--){
            result[i]=result[i]+tmp;
            tmp = tmp + input[i];
        }
        for(int i=0; i<input.length; i++){
            input[i] = result[i];
        }
    }


    @Test
    public void test(){
        int[] input = new int[]{4,7,2,9,12,10,3};
        sumImpl(input);
        System.out.println(Arrays.toString(input));
        //Assert.assertEquals(productImpl(input), {});
    }
}
