package theory.graph.matrix;

import theory.graph.Solution;

import java.util.*;

public class Nearest1InBinaryMatrix {
    static int[][] result;

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static List<Point> getNeighbours(int[][] input, Point point){
        int row = input.length;
        int column = input[0].length;
        List<Point> result = new ArrayList<>();
        if(point.x-1>=0 && input[point.x-1][point.y] == 0){
            result.add(new Point(point.x-1, point.y));
        }

        if(point.x+1<row && input[point.x+1][point.y] == 0){
            result.add(new Point(point.x+1, point.y));
        }

        if(point.y-1>=0 && input[point.x][point.y-1] == 0){
            result.add(new Point(point.x, point.y-1));
        }

        if(point.y+1<column && input[point.x][point.y+1] == 0){
            result.add(new Point(point.x, point.y+1));
        }
        return result;
    }


    public static void findNearestDist(int[][] input){

        for(int i=0; i<input.length; i++){
            for(int j=0; j<input[0].length; j++){
                result[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<Point> queue = new LinkedList<>();

        for(int i=0; i<input.length; i++){
            for(int j=0; j<input[0].length; j++){
                if(input[i][j]==1){
                    queue.add(new Point(i, j));
                    result[i][j] = 0;
                }
            }
        }

        while(!queue.isEmpty()){
            Point point = queue.poll();

            for(Point tmp: getNeighbours(input, point)){
                if(result[tmp.x][tmp.y] > result[point.x][point.y] + 1){
                    result[tmp.x][tmp.y] = result[point.x][point.y] + 1;
                    queue.add(new Point(tmp.x, tmp.y));
                }
            }
        }
    }

    public static void main(String[] args){
        int[][] input = {
                {0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 0}
        };

        result =  new int[input.length][input[0].length];

        findNearestDist(input);

        for(int i=0; i<result.length; i++){
            System.out.println(Arrays.toString(result[i]));
        }

    }
}
