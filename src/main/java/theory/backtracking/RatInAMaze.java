package theory.backtracking;

public class RatInAMaze {

    public static int size;

    public static boolean solution(int[][] input){
        int[][] result = new int[size][size];

        if(!solutionRec(result, input, 0, 0)){
            return false;
        }

        printMatrix(result);
        return true;
    }

    private static boolean solutionRec(int[][] result, int[][] input, int i, int j){

        if((i== size -1) && (j== size -1) && input[i][j] == 1) {
            result[i][j] = 1;
            return true;
        }

        if(safeMove(input, i, j)){
            result[i][j] = 1;
            if(solutionRec(result,input, i+1, j)){
                return true;
            }
            if(solutionRec(result,input,i, j+1)){
                return true;
            }
            result[i][j] = 0;
        }

        return false;
    }

    private static boolean safeMove(int[][] input, int i, int j){
        if(i< size && j< size && input[i][j] == 1){
            return true;
        }
        return false;
    }


    public static void printMatrix(int[][] input){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[][] input = {{ 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 }};
        size = 4;
        System.out.println(solution(input));
    }
}
