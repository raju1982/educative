package theory.backtracking;

public class Sudoku {
    public static void sol(int[][] input) {
        int i = -1, j = -1;
        boolean found = false;
        for (int p = 0; p < input.length; p++) {
            for (int q = 0; q < input.length; q++) {
                if (input[p][q] == 0) {
                    i = p;
                    j = q;
                    found = true;
                    break;
                }
            }
            if(found){
                break;
            }
        }

        if (!found) {
            //print the matrix
            for (int p = 0; p < input.length; p++) {
                for (int q = 0; q < input.length; q++) {
                    System.out.print(input[p][q]+",");
                }
                System.out.println();
            }
            return;
        }

        for (int num = 1; num < 10; num++) {
            if (isSafe(input, i, j, num)) {
                input[i][j] = num;
                sol(input);
                input[i][j] = 0;
            }
        }
    }


    private static boolean isSafe(int[][] input, int row, int col, int num) {

        for (int i = 0; i < input.length; i++) {
            if (input[row][i] == num) {
                return false;
            }
        }


        for (int i = 0; i < input.length; i++) {
            if (input[i][col] == num) {
                return false;
            }
        }

        int sqrt = (int) Math.sqrt(input.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart; d < boxColStart + sqrt; d++) {
                if (input[r][d] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        sol(new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        });
    }
}
