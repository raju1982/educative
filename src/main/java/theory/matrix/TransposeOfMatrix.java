package theory.matrix;

public class TransposeOfMatrix {
    public static void solution(int[][] input){
        int row = input.length; //5
        int column = input[0].length; //5
        int tmp;
        for(int i=0; i<row ; i++){
            for(int j=i+1; j<column ; j++){
                tmp = input[i][j];
                input[i][j] = input[j][i];
                input[j][i] = tmp;
            }
        }
    }

    public static void print(int[][] input){
        int row = input.length; //5
        int column = input[0].length; //5
        for(int i=0; i<row ; i++){
            for(int j=0; j<column ; j++){
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[][] input = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
        solution(input);
        print(input);
    }
}
