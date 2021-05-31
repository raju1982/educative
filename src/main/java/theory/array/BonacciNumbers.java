package theory.array;

import java.util.Arrays;

public class BonacciNumbers {
    public static void sol(int windowSize, int size){
        int[] data = new int[size];

        //populate initial numbers
        for(int i=0; i<windowSize; i++){
            if(i<windowSize-1){
                data[i] = 0;
            }
            else{
                data[i] = 1;
            }
        }

        int tmpSum = 1;
        for(int i=windowSize; i<size; i++){
            data[i] = tmpSum;
            tmpSum = tmpSum + data[i] - data[i-windowSize];
        }

        System.out.println(Arrays.toString(data));
    }


    public static void main(String[] args){
        sol(3, 8);
    }
}
