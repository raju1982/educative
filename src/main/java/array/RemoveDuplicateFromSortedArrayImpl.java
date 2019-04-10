package array;

import java.util.Arrays;
public class RemoveDuplicateFromSortedArrayImpl{

    //in  first pass get count.
    //in second pass load array
    // this will save space.



    public static int[] removeDuplicate(int[] input){
        int[] tmp = new int[input.length];

        int j=0;
        for(int i=0; i<input.length-1; i++){
            if(input[i]!=input[i+1]){
                tmp[j++] = input[i];
            }
        }

        tmp[j] = input[input.length-1];

        System.out.println(Arrays.toString(tmp));

        int[] result = new int[j+1];
        for(int i=0; i<=j; i++){
            result[i] = tmp[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int[] res = removeDuplicate(arr);
        System.out.println(Arrays.toString(res));
    }

}