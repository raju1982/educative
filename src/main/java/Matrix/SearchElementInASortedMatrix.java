package Matrix;

public class SearchElementInASortedMatrix {

    // JAVA Code for Search in a row wise and
// column wise sorted matrix

    /* Searches the element x in mat[][]. If the
    element is found, then prints its position
    and returns true, otherwise prints "not found"
    and returns false */
    private static void search(int[][] mat, int n, int x) {

        int i = 0, j = n - 1; //set indexes for top right
        // element

        while (i < n && j >= 0) {
            if (mat[i][j] == x) {
                System.out.println("n Found at " + i + " " + j);
                return;
            }
            if (mat[i][j] > x)
                j--;
            else // if mat[i][j] < x
                i++;
        }

        System.out.println("n Element not found");
        return; // if ( i==n || j== -1 )

    }


    public static boolean binarySearchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m * n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int midX = mid / n;
            int midY = mid % n;

            if (matrix[midX][midY] == target)
                return true;

            if (matrix[midX][midY] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }


    // driver program to test above function
    public static void main(String[] args) {
        int mat[][] = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};

        //search(mat, 4, 29);

        System.out.println(binarySearchMatrix(mat,  29));

    }

}
