package theory.graph.matrix;


import java.util.LinkedList;
import java.util.Queue;

// Java program to find the shortest path between a given source cell to a destination cell.
public class ShortestPathInBinaryMaze {


    /*
        static class Point{
        int x;
        int y;
        int dist;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        Point(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static List<Point> getNeighbours(int[][] input, Point point){
        int row = input.length;
        int column = input[0].length;
        List<Point> result = new ArrayList<>();
        if(point.x-1>=0 && input[point.x-1][point.y] == 1){
            result.add(new Point(point.x-1, point.y));
        }

        if(point.x+1<row && input[point.x+1][point.y] == 1){
            result.add(new Point(point.x+1, point.y));
        }

        if(point.y-1>=0 && input[point.x][point.y-1] == 1){
            result.add(new Point(point.x, point.y-1));
        }

        if(point.y+1<column && input[point.x][point.y+1] == 1){
            result.add(new Point(point.x, point.y+1));
        }
        return result;
    }

    public static int findDist(int[][] input, Point PointA, Point PointB){
        boolean[][] visited = new boolean[input.length][input[0].length];
        visited[PointA.x][PointA.y] = true;
        int result = -1;
        Queue<Point> queue = new LinkedList<>();
        queue.add(PointA);

        while(!queue.isEmpty()){
            Point point = queue.poll();

            for(Point tmp : getNeighbours(input, point)){
                //check for destination node
                if(tmp.x == PointB.x && tmp.y == PointB.y){
                    return point.dist+1;
                }

                if(!visited[tmp.x][tmp.y]){
                    queue.add(new Point(tmp.x, tmp.y, point.dist+1));
                    visited[tmp.x][tmp.y] = true;
                }

            }

        }
        return result;
    }

     */

















    static int ROW = 9;
    static int COL = 10;

    // To store matrix cell coordinates
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    ;

    // A Data Structure for queue used in BFS
    static class queueNode {
        Point pt; // The coordinates of a cell
        int dist; // cell's distance of from the source

        public queueNode(Point pt, int dist) {
            this.pt = pt;
            this.dist = dist;
        }
    }

    ;

    // check whether given cell (row, col)
// is a valid cell or not.
    static boolean isValid(int row, int col) {
        // return true if row number and
        // column number is in range
        return (row >= 0) && (row < ROW) &&
                (col >= 0) && (col < COL);
    }

    // These arrays are used to get row and column numbers of 4 neighbours of a given cell
    static int rowNum[] = {-1, 0, 0, 1};
    static int colNum[] = {0, -1, 1, 0};

    // function to find the shortest path between a given source cell to a destination cell.
    static int BFS(int mat[][], Point src, Point dest) {
        // check source and destination cell
        // of the matrix have value 1
        if (mat[src.x][src.y] != 1 || mat[dest.x][dest.y] != 1) {
            return -1;
        }

        boolean[][] visited = new boolean[ROW][COL];

        // Mark the source cell as visited
        visited[src.x][src.y] = true;

        // Create a queue for BFS
        Queue<queueNode> queue = new LinkedList<>();

        // Distance of source cell is 0
        queueNode s = new queueNode(src, 0);
        queue.add(s); // Enqueue source cell

        // Do a BFS starting from source cell
        while (!queue.isEmpty()) {
            queueNode curr = queue.peek();
            Point pt = curr.pt;

            // If we have reached the destination cell,
            // we are done
            if (pt.x == dest.x && pt.y == dest.y)
                return curr.dist;

            // Otherwise dequeue the front cell
            // in the queue and enqueue
            // its adjacent cells
            queue.remove();

            for (int i = 0; i < 4; i++) {
                int row = pt.x + rowNum[i];
                int col = pt.y + colNum[i];

                // if adjacent cell is valid, has path
                // and not visited yet, enqueue it.
                if (isValid(row, col) &&
                        mat[row][col] == 1 &&
                        !visited[row][col]) {
                    // mark cell as visited and enqueue it
                    visited[row][col] = true;
                    queueNode Adjcell = new queueNode
                            (new Point(row, col),
                                    curr.dist + 1);
                    queue.add(Adjcell);
                }
            }
        }

        // Return -1 if destination cannot be reached
        return -1;
    }

    // Driver Code
    public static void main(String[] args) {
        int mat[][] = {
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}
        };

        Point source = new Point(0, 0);
        Point dest = new Point(3, 4);

        int dist = BFS(mat, source, dest);

        if (dist != -1)
            System.out.println("Shortest Path is " + dist);
        else
            System.out.println("Shortest Path doesn't exist");
    }
}