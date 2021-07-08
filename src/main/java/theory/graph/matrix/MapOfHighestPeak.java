package theory.graph.matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak {
    public static void getPeakMap(int[][] input){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[input.length][input[0].length];

        for(int i=0; i<input.length; i++){
            for(int j=0; j<input[0].length; j++){
                if(input[i][j] == 1){
                    input[i][j] = 0;
                    queue.add(new int[]{i,j});
                    visited[i][j]=true;
                }
            }
        }


        int[] xCoordinates = new int[] {0,0,1,-1};
        int[] yCoordinates = new int[] {1,-1,0,0};

        int height = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] arr = queue.poll();

                for(int j=0; j<xCoordinates.length; j++){
                    int x = arr[0]+xCoordinates[j];
                    int y = arr[1]+yCoordinates[j];

                    if(x<0 || x>=input.length || y<0 || y>=input[0].length || visited[x][y]){
                        continue;
                    }
                    input[x][y] = height;
                    queue.add(new int[]{x,y});
                    visited[x][y] = true;
                }

            }
            height++;
        }
    }


    public static void main(String[] args){
        int[][] input = {{0,1},{0,0}};
        getPeakMap(input);

        for(int[] arr : input){
            System.out.println(Arrays.toString(arr));
        }


        int[][] input2 = {{0,0,1},{1,0,0},{0,0,0}};
        getPeakMap(input2);

        for(int[] arr : input2){
            System.out.println(Arrays.toString(arr));
        }

    }
}
