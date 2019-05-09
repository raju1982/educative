package array.matrix;

import java.util.Arrays;

public class RowWiseSorting {
    public static void sortMatrix(int[][] input){
        int[] tmp = new int[input.length * input[0].length];

        for(int i=0,k=0; i<input.length; i++){
            for(int j=0; j<input[0].length; j++){
                tmp[k++]=input[i][j];
            }
        }

        //replace with quicksort
        Arrays.sort(tmp);

        for(int i=0,k=0; i<input.length; i++){
            for(int j=0; j<input[0].length; j++){
                input[i][j]=tmp[k++];
            }
        }
    }

    public static void main(String[] args){
        int[][] input = {
                {5, 4, 7},
                {1, 3, 8},
                {2, 9, 6} };
        System.out.println(Arrays.deepToString(input));
        sortMatrix(input);
        System.out.println(Arrays.deepToString(input));
    }
}
