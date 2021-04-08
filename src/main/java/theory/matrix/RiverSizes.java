package theory.matrix;

import java.util.*;

public class RiverSizes {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static List<Point> getAllNeighbor(int[][] matrix, int x, int y) {
        List<Point> neighbors = new ArrayList<>();
        neighbors.add(new Point(x - 1, y));
        neighbors.add(new Point(x + 1, y));
        neighbors.add(new Point(x, y - 1));
        neighbors.add(new Point(x, y + 1));

        Iterator<Point> iterator = neighbors.iterator();
        while (iterator.hasNext()) {
            Point tmp = iterator.next();
            if (tmp.x >= matrix.length || tmp.y >= matrix[0].length || tmp.x < 0 || tmp.y < 0 || matrix[tmp.x][tmp.y] == 0) {
                iterator.remove();
            }
        }

        return neighbors;
    }

    public static void BFS(int[][] matrix, int x, int y, boolean[][] visited, List<Integer> riverSize) {
        Point startPoint = new Point(x, y);
        Queue<Point> queue = new LinkedList<>();
        queue.add(startPoint);
        visited[startPoint.x][startPoint.y] = true;
        int size = 1;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            //get all neighbour
            List<Point> points = getAllNeighbor(matrix, point.x, point.y);
            //if neighbor are not visited add them to the queue, mark these neighbor as visited.
            for (Point tmp : points) {
                if (!visited[tmp.x][tmp.y]) {
                    queue.add(tmp);
                    visited[tmp.x][tmp.y] = true;
                    size++;
                }
            }
        }
        riverSize.add(size);
    }

    //A group of connected 1s forms an island.
    public static List<Integer> countIslands(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<Integer> riverSize = new ArrayList<>();
        int islandCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    BFS(matrix, i, j, visited, riverSize);
                }
            }
        }
        return riverSize;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}};

        System.out.print(countIslands(matrix).toString());
    }
}