package array;
import java.util.Arrays;

public class moveZeroToLeftImpl{

    public static void moveZeroToLeft(int[] input){
        //illegal argument exception

        int readIndex=input.length-1;
        int writeIndex=readIndex;

        while(readIndex>=0){
            if(input[readIndex] != 0){
                input[writeIndex] = input[readIndex];
                writeIndex--;
            }
            readIndex--;
        }

        while(writeIndex>=0){
            input[writeIndex] = 0;
            writeIndex--;
        }

    }

    public static void main(String[] args){
        int[] input = new int[] {5,0,2,0,0,3,7,9,12};
        moveZeroToLeft(input);
        System.out.println(Arrays.toString(input));

        int[] v = new int[]{1, 10, -1, 11, 5, 0, -7, 0, 25, -35};
        moveZeroToLeft(v);
        System.out.println(Arrays.toString(v));
    }


}
