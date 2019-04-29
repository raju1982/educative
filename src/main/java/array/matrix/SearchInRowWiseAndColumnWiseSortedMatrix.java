package array.matrix;

public class SearchInRowWiseAndColumnWiseSortedMatrix {

    //best solution
    public static void search(int[][] input, int searchElement){
            int i=0;
            int j=input[0].length-1;

            while(i<input.length && j>=0){
                if(searchElement==input[i][j]){
                    System.out.println("i=" + i + "j=" + j);
                    return;
                }
                if(searchElement>input[i][j]){
                    i++;
                    continue;
                }
                else{
                    j--;
                    continue;
                }
            }
        System.out.println("-1");
    }

    public static void main(String[] args){
        int[][] data = new int[][]{{1, 5, 9},
                {14, 20, 21},
                {30, 34, 43}};

        search(data, 20);
        search(data, 25);
    }

}
