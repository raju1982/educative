package theory.matrix;

import java.util.*;

public class RemoveIslands {

    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void removeIsland(int[][] matrix){
        //find all non-island
        boolean[][] nonIsland = new boolean[matrix.length][matrix[0].length];

        markNonIsland(matrix, nonIsland);

        for(int i=0; i<nonIsland.length; i++){
            for(int j=0; j<nonIsland[0].length; j++){
                System.out.print(nonIsland[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        //mark everything which is NonIsland as 0
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(!nonIsland[i][j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void markNonIsland(int[][] matrix, boolean[][] nonIsland){
        for(int i=0; i<matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(!nonIsland[i][j]){
                    markNonIsland(matrix, nonIsland, i, j);
                }
            }
        }
    }

    public static void markNonIsland(int[][] matrix, boolean[][] nonIsland, int row, int column){
        //if nonIsland then search do BFS
        boolean borderRow = (row == 0) || (row == matrix.length-1);
        boolean borderColumn = (column == 0) || (column == matrix[0].length-1);
        boolean borderPoint =  borderRow || borderColumn;
        if(borderPoint){
            nonIsland[row][column] = true;
            if(matrix[row][column] == 1) {
                bfs(matrix, nonIsland, row, column);
            }
        }
    }

    public static void bfs(int[][] matrix, boolean[][] nonIsland, int row, int column){
        Queue<Point> queue = new LinkedList<>();
        Point point = new Point(row, column);
        queue.add(point);

        while(!queue.isEmpty()){
            for(Point tmp : getNeighbor(matrix, queue.poll())){
                if(!nonIsland[tmp.x][tmp.y]) {
                    queue.add(tmp);
                    nonIsland[tmp.x][tmp.y] = true;
                }
            }
        }

    }

    public static List<Point> getNeighbor(int[][] matrix, Point point){
        List<Point> neighbors = new ArrayList<>();
        neighbors.add(new Point(point.x - 1, point.y));
        neighbors.add(new Point(point.x + 1, point.y));
        neighbors.add(new Point(point.x, point.y - 1));
        neighbors.add(new Point(point.x, point.y + 1));

        Iterator<Point> iterator = neighbors.iterator();
        while (iterator.hasNext()) {
            Point tmp = iterator.next();
            if (tmp.x >= matrix.length || tmp.y >= matrix[0].length || tmp.x < 0 || tmp.y < 0 || matrix[tmp.x][tmp.y] == 0) {
                iterator.remove();
            }
        }
        return neighbors;
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{
                {1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1}
        };

        removeIsland(matrix);

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
