package array.matrix;

import java.util.Arrays;

public class RotateMatrixBy90Degree {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 0 || n == 1) {
            return;
        }

        int startRow = 0;
        int endRow = n - 1;
        int startCol = 0;
        int endCol = n - 1;
        while (startRow < endRow) {
            for (int i = 0; startRow + i < endRow; i++) {
                int temp = matrix[startRow][startCol + i];
                matrix[startRow][startCol + i] = matrix[endRow - i][startCol];
                matrix[endRow - i][startCol] = matrix[endRow][endCol - i];
                matrix[endRow][endCol - i] = matrix[startRow + i][endCol];
                matrix[startRow + i][endCol] = temp;
            }
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
    }

    public static void main(String[] args){
        int[][] matrix =
                {{1,2,3},
                {4,5,6},
                {7,8,9}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
