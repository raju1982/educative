package theory.graph.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {

    public static int[] rowCoordinate = new int[]{0,0,1,-1};
    public static int[] columnCoordinate = new int[]{1,-1,0,0};

    public static int findMinFlip(int[][] input){

        boolean[][] visited = new boolean[input.length][input[0].length];
        Queue<int[]> nodes = new LinkedList<>();
        boolean bfsFlag =  false;
        for(int i=0; i<input.length; i++){
            if(bfsFlag){
                break;
            }
            for(int j=0; j<input[0].length; j++){
                if(input[i][j]==1){
                    bfs(input, visited, nodes, new int[] {i,j});
                    bfsFlag = true;
                    break;
                }
            }
        }

        int count = 0;
        while(!nodes.isEmpty()){

            int size = nodes.size();

            for(int j=0; j<size; j++){
                int[] arr = nodes.poll();

                for(int i=0; i<rowCoordinate.length; i++){
                    int x = arr[0] + rowCoordinate[i];
                    int y = arr[1] + columnCoordinate[i];

                    if(x<0 || x>=input.length || y<0 || y>=input[0].length || visited[x][y]){
                        continue;
                    }

                    if(input[x][y] == 1){
                        return count;
                    }

                    nodes.add(new int[] {x,y});
                    visited[x][y] = true;
                }
            }

            count++;
        }

        return -1;
    }


    public static void bfs(int[][] input, boolean[][] visited, Queue<int[]> nodes, int[] node){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(node);
        nodes.add(node);
        visited[node[0]][node[1]] = true;

        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            for(int i=0; i<rowCoordinate.length; i++){
                int x = arr[0] + rowCoordinate[i];
                int y = arr[1] + columnCoordinate[i];

                if(x<0 || x>=input.length || y<0 || y>=input[0].length || visited[x][y] || input[x][y] == 0){
                    continue;
                }

                queue.add(new int[] {x,y});
                nodes.add(new int[] {x,y});
                visited[x][y] = true;
            }
        }
    }


    public static void main(String[] args){
        int[][] input = new int[][]{{0,1,0},{0,0,0},{0,0,1}};
        System.out.println(findMinFlip(input));

        input = new int[][]{{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
        System.out.println(findMinFlip(input));
    }

}
