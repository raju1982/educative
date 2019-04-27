package array.rotate_rearrange_reorder;

import java.util.Arrays;
import java.util.List;

public class RotateArrayGeneric {

    public static void rotateArray(List<Integer> input, int rotateNum){
        int size = input.size();
        rotateNum=rotateNum%size;
        if(rotateNum<0){
            rotateNum = rotateNum+size;
        }

        swapNUmberfromBothends(input, 0, size-1);
        swapNUmberfromBothends(input, rotateNum, size-1);
        swapNUmberfromBothends(input, 0, rotateNum-1);
    }

    public static void swapNUmberfromBothends(List<Integer> input, int min, int max){

        while(min<max){
            int tmp=input.get(min);
            input.set(min, input.get(max));
            input.set(max, tmp);
            min++;
            max--;
        }

    }

    //easy solution
    public static void RightRotateArrayByOneIndex(int[] input){
        int tmp = input[0];
        for(int i=1; i<input.length; i++){
            input[i-1]=input[i];
        }
        input[input.length-1] = tmp;
    }

    public static void genericRotate(int[] input, int num){
        if(num < 0){
            num = num + input.length;
        }
        for(int i=1; i<=num; i++){
            RightRotateArrayByOneIndex(input);
        }
    }

    public static void main(String[] args){
        List<Integer> v1 = Arrays.asList(1, 2, 3, 4, 5);
        rotateArray(v1,3);

        System.out.println(Arrays.toString(v1.toArray()));
    }
}
