package theory.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MotherVertex {

    public static int findMotherVertex(List<ArrayList<Integer>> graph){
        int vertexCount = graph.size();
        boolean[] visited = new boolean[vertexCount];
        int lastVertex=0;
        for(int i=0; i<vertexCount; i++){
            if(!visited[i]){
                modifiedDFS(graph, i, visited);
                lastVertex = i;
            }
        }
        Arrays.fill(visited, false);
        modifiedDFS(graph, lastVertex, visited);
        for(int i=0; i<vertexCount; i++){
            if(!visited[i]){
                return -1;
            }
        }

        return lastVertex;
    }

    private static void modifiedDFS(List<ArrayList<Integer>> graph, int startVertex, boolean[] visited){
        visited[startVertex]=true;
        for(int i: graph.get(startVertex)) {
            if (!visited[i]) {
                modifiedDFS(graph, i, visited);
            }
        }
    }

    /*
    The DFS of the whole graph works in O(V + E).
    If a mother vertex exists, the second DFS takes O(V + E) as well.
    Therefore, the complete time complexity for this algorithm is O(V + E).
     */
    public static void main(String[] args){
        int vertexCount = 4;
        List<ArrayList<Integer>> graph = new ArrayList<>(vertexCount);
        for(int i=0; i<vertexCount; i++){
            graph.add(new ArrayList<Integer>());
        }

        graph.get(3).add(0);
        graph.get(3).add(1);
        graph.get(0).add(1);
        graph.get(1).add(2);

        System.out.println(findMotherVertex(graph));
    }
}
