package theory.graph;

import java.util.ArrayList;
import java.util.List;

public class CountNumberOfEdgesInUndirectedGraph {

    private static void addEdge(List<ArrayList<Integer>> graph, int vertexA, int vertexB){
        graph.get(vertexA).add(vertexB);
        graph.get(vertexB).add(vertexA);
    }

    //Time Complexity: O(V)
    public static int edgeCount(List<ArrayList<Integer>> graph){
        int count = 0;

        for(int i=0; i<graph.size(); i++){
            count = count + graph.get(i).size();
        }

        return count/2;
    }

    //Mother Vertex" in a Directed Graph
    public static void main(String[] args){
        int vertexCount = 8;
        List<ArrayList<Integer>> graph = new ArrayList<>(vertexCount);
        for(int i=0; i<vertexCount; i++){
            graph.add(new ArrayList<>());
        }

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 4, 2);
        addEdge(graph, 4, 5);
        addEdge(graph, 2, 5);
        addEdge(graph, 5, 6);
        addEdge(graph, 5, 7);
        addEdge(graph, 5, 3);
        addEdge(graph, 6, 7);

        System.out.println(edgeCount(graph));
    }
}
