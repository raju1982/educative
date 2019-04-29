package array.matrix;

public class SpiralPrint {
    // Java program to print a given matrix in spiral form
    // Function print matrix in spiral form
    static void spiralPrint(int a[][]) {
        int i, startingRowIndex = 0, startingColumnIndex = 0, endingRowIndex=a.length, endingColumnIndex=a[0].length;
		/* startingRowIndex - starting row index
		endingRowIndex - ending row index
		startingColumnIndex - starting column index
		endingColumnIndex - ending column index
		i - iterator
		*/

        while (startingRowIndex < endingRowIndex && startingColumnIndex < endingColumnIndex) {
            // Print the first row from the remaining rows
            for (i = startingColumnIndex; i < endingColumnIndex; ++i) {
                System.out.print(a[startingRowIndex][i] + " ");
            }
            startingRowIndex++;

            // Print the last column from the remaining columns
            for (i = startingRowIndex; i < endingRowIndex; ++i) {
                System.out.print(a[i][endingColumnIndex - 1] + " ");
            }
            endingColumnIndex--;

            // Print the last row from the remaining rows */
            if (startingRowIndex < endingRowIndex) {
                for (i = endingColumnIndex - 1; i >= startingColumnIndex; --i) {
                    System.out.print(a[endingRowIndex - 1][i] + " ");
                }
                endingRowIndex--;
            }

            // Print the first column from the remaining columns */
            if (startingColumnIndex < endingColumnIndex) {
                for (i = endingRowIndex - 1; i >= startingRowIndex; --i) {
                    System.out.print(a[i][startingColumnIndex] + " ");
                }
                startingColumnIndex++;
            }
        }
    }

    // driver program
    public static void main(String[] args) {
        int R = 3;
        int C = 6;
        int a[][] = {{1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };
        spiralPrint(a);
    }
}

//1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11