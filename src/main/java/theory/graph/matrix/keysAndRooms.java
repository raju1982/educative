package theory.graph.matrix;

public class keysAndRooms {
    public static boolean dfs(int[][] input, int i){
        boolean[] visited = new boolean[input.length];
        dfs(input, i, visited);
        for(boolean x: visited){
            if(!x){
                return false;
            }
        }
        return true;
    }


    public static void dfs(int[][] input, int i, boolean[] visited){
        visited[i] = true;
        for(int j: input[i]){
            if(!visited[j]){
                dfs(input, j, visited);
            }
        }
    }

    public static void main(String[] args){
        System.out.println(dfs(new int[][] {{1},{2},{3},{}}, 0));
        System.out.println(dfs(new int[][] {{1,3},{3,0,1},{2},{0}}, 0));
        //[[1,3],[3,0,1],[2],[0]]
    }
}
