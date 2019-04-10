package Matrix;

public class Convert2dMatrixInto1DMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[5][6];

        int counter = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                matrix[i][j] = counter++;
            }
        }

        int[] array = new int[matrix.length * matrix[0].length];
        int k = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                array[k++] = matrix[i][j];
            }
        }


        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
