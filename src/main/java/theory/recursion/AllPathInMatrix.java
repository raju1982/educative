package theory.recursion;

public class AllPathInMatrix {
    static int totalPath=0;
    public static void sol(int row, int column, int i, int j, String path){
        if(i==row-1 && j==column-1){
            System.out.println(path);
            totalPath++;
            return;
        }
        if(i<row-1){
            sol(row, column, i+1, j, path + " Down");
        }
        if(j<column-1){
            sol(row, column, i, j+1, path + " Right" );
        }
        if(i<row-1 && j<column-1){
            sol(row, column, i+1, j+1, path + " Diagonal");
        }
    }

    public static void main(String[] args){
        sol(3,3, 0, 0, "");
        System.out.println(totalPath);
    }
}
