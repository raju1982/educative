package theory.graph.matrix;

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class NumberOfIslands {

    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this. y =y;
        }
    }

    public static List<Point> getAllNeighbor(int[][] matrix, int x, int y){
        List<Point> neighbors = new ArrayList<>();
        neighbors.add(new Point(x-1, y));
        neighbors.add(new Point(x+1, y));
        neighbors.add(new Point(x, y-1));
        neighbors.add(new Point(x, y+1));

        Iterator<Point> iterator = neighbors.iterator();
        while(iterator.hasNext()){
            Point tmp = iterator.next();
            if(tmp.x>=matrix.length || tmp.y>=matrix[0].length || tmp.x<0 || tmp.y<0 || matrix[tmp.x][tmp.y]==0){
                iterator.remove();
            }
        }

        return neighbors;
    }

    public static void BFS(int[][] matrix, int x, int y, boolean[][] visited){
        Point startPoint = new Point(x,y);
        Queue<Point> queue = new LinkedList<>();
        queue.add(startPoint);
        visited[startPoint.x][startPoint.y] = true;

        while(!queue.isEmpty()){
            Point point = queue.poll();
            //get all neighbour
            List<Point> points = getAllNeighbor(matrix, point.x, point.y);
            //if neighbor are not visited add them to the queue, mark these neighbor as visited.
            for(Point tmp: points){
                if(!visited[tmp.x][tmp.y]){
                    queue.add(tmp);
                    visited[tmp.x][tmp.y] = true;
                }
            }
        }
    }

    //A group of connected 1s forms an island.
    public static int countIslands(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int islandCount = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 1 && !visited[i][j]){
                    BFS(matrix, i, j, visited);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};

        System.out.print(countIslands(matrix));
    }
}
