package theory.graph.matrix;

import theory.graph.Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumTimeRequiredSoThatAllOrangesBecomeRotten {
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static List<Point> getNeighbours(int[][] input, Point point){
        List<Point> points = new ArrayList<>();
        if(point.x+1<input.length && input[point.x+1][point.y] == 1){
            points.add(new Point(point.x+1, point.y));
        }

        if(point.x-1>=0 && input[point.x-1][point.y] == 1){
            points.add(new Point(point.x-1, point.y));
        }

        if(point.y+1<input[0].length && input[point.x][point.y+1] == 1){
            points.add(new Point(point.x, point.y+1));
        }

        if(point.y-1>=0 && input[point.x][point.y-1] == 1){
            points.add(new Point(point.x, point.y-1));
        }

        return points;
    }

    public static int minTime(int[][] input){
        //start the rotting process via BFS
        int count = -1;
        Queue<Point> queue = new LinkedList<>();
        for(int i=0; i<input.length; i++){
            for(int j=0; j<input.length; j++){
                if(input[i][j] == 2){
                    queue.add(new Point(i, j));
                }
            }
        }
        queue.add(new Point(-1,-1));

        while(!queue.isEmpty()){
            Point point = queue.poll();
            if(point.x != -1 && point.y !=-1) {
                for(Point tmp: getNeighbours(input, point)){
                    input[tmp.x][tmp.y] = 2;
                    queue.add(new Point(tmp.x, tmp.y));
                }
            }
            else{
                count++;
                if(!queue.isEmpty()){
                    queue.add(new Point(-1,-1));
                }
            }
        }
        return count;
    }


    public static void main(String[] args){
        int[][] input = {
                {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        };

        System.out.println(minTime(input));
    }
}
