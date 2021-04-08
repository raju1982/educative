package theory.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSortingDFSBased {

    private static void addEdge(List<ArrayList<Integer>> graph, int startPoint, int endPoint) {
        graph.get(startPoint).add(endPoint);
    }

    private static void dfs(List<ArrayList<Integer>> graph, int vertexCount) {
        boolean[] visited = new boolean[vertexCount];
        Stack data = new Stack();
        for (int i = 0; i < vertexCount; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited, data);
            }
        }
        System.out.println();
        while (!data.isEmpty()) {
            System.out.print(data.pop() + "\t");
        }
    }

    private static void dfs(List<ArrayList<Integer>> graph, int vertex, boolean[] visited, Stack data) {
        visited[vertex] = true;
        System.out.print(vertex + "\t");
        for (int i : graph.get(vertex)) {
            if (!visited[i]) {
                dfs(graph, i, visited, data);
            }
        }
        data.add(vertex);
    }

    public static void main(String[] args) {
        int vertexCount = 5;

        List<ArrayList<Integer>> graph = new ArrayList<>(vertexCount);

        for (int i = 0; i < vertexCount; i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(graph, 0, 2);
        addEdge(graph, 0, 3);
        addEdge(graph, 2, 3);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);

        dfs(graph, vertexCount);
    }

}
