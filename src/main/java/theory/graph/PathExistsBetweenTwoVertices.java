package theory.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathExistsBetweenTwoVertices {

    private static void addEdge(List<ArrayList<Integer>> graph, int vertexA, int vertexB){
        graph.get(vertexA).add(vertexB);;
    }

    public static boolean checkPath(List<ArrayList<Integer>> graph, int startVertex, int endVertex){
        if(startVertex == endVertex){
            return true;
        }
        int vertexCount = graph.size();
        boolean[] visited = new boolean[vertexCount];
        Queue<Integer> queue= new LinkedList<>();
        queue.add(startVertex);

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            for(int i : graph.get(tmp)){
                if(!visited[i]){
                    if(i==endVertex){
                        return true;
                    }
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int vertexCount = 8;
        List<ArrayList<Integer>> graph = new ArrayList<>(vertexCount);
        for (int i = 0; i < vertexCount; i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 5);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 4, 2);
        addEdge(graph, 4, 5);
        addEdge(graph, 2, 5);
        addEdge(graph, 5, 6);
        addEdge(graph, 5, 7);
        addEdge(graph, 5, 3);
        addEdge(graph, 6, 7);

        System.out.println(checkPath(graph, 0, 6));
    }

}
