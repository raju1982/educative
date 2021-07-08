package theory.backtracking;

import java.util.*;

public class RatInAMaze2 {

    static int[][] result = null;
    public static boolean solution(int[][] input){
        int size = input.length;
        result = new int[size][size];
        boolean[][] visited = new boolean[size][size];
        visited[0][0] = true;
        if(solutionRec(new int[size][size], input, visited, 0, 0)){
            return true;
        }
        return false;
    }

    static int[] X_AXIS = {0,0,1,-1};
    static int[] Y_AXIS = {1,-1,0,0};
    public static boolean solutionRec(int[][] runningResult, int[][] input, boolean[][] visited, int i , int j){
        if(i==input.length-1 && j==input[0].length-1){
            runningResult[i][j] = 1;
            result = runningResult;
            for(int n=0; n<runningResult.length; n++){
                result[n] = Arrays.copyOf(runningResult[n], runningResult[n].length);
            }
            return true;
        }

        for(int k=0; k<X_AXIS.length; k++){
            int p = i+X_AXIS[k];
            int q = j+Y_AXIS[k];

            if(p<input.length && p>=0 && q<input[0].length && q>=0  && !visited[p][q] && input[p][q]==1){
                visited[p][q] = true;
                runningResult[p][q] = 1;
                if(solutionRec(runningResult, input, visited, p, q)){
                    return true;
                }
                runningResult[p][q] = 0;
                visited[p][q] = false;
            }

        }
        return false;
    }


    public static void printMatrix(int[][] input){
        for(int i=0; i<input.length; i++){
            for(int j=0; j<input[0].length; j++){
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[][] input = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 }};
        System.out.println(solution(input));
        printMatrix(result);
    }
}
