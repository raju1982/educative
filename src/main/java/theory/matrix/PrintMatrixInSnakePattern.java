package theory.matrix;

public class PrintMatrixInSnakePattern {
    public static void solution(int[][] input){
        int row = input.length; //3
        int column = input[0].length; //5
        for(int i=0;i<row; i++){
            if(i%2==0) {
                for(int j=0;j<column; j++){
                    System.out.print(input[i][j] + " ");
                }
            }
            else{
                for(int j=column-1;j>=0; j--){
                    System.out.print(input[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[][] input = {{1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15}};
        solution(input);
    }
}
