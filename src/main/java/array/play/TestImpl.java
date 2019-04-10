package array.play;

import java.util.Arrays;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;

public class TestImpl {


    public static int MissingNumberInArithmeticProgression(int[] input){
        int sum=0;

        for(int i=0; i<input.length-1; i++){
            sum = sum + input[i+1]-input[i];
        }
        int avg = sum/(input.length-1);

        for(int i=0; i<input.length-1; i++){
            if(input[i]+avg != input[i+1]){
                return input[i]+avg;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int ar1[] = {2, 5, 8, 12, 14, 17};
        System.out.println(MissingNumberInArithmeticProgression(ar1));

        ar1 = new int[] {1, 5, 10, 20, 40, 80};

        ar1 = new int[] {1, 5, 10, 20, 40, 80};
   }

 }
