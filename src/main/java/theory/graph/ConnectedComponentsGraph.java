package theory.graph;

import java.util.*;

public class ConnectedComponentsGraph {

    private static List<ArrayList<Integer>> getTranspose(List<ArrayList<Integer>> graph){
        int vertexCount = graph.size();
        List<ArrayList<Integer>> transposedGraph = new ArrayList<>(vertexCount);
        for(int i=0; i<vertexCount; i++){
            transposedGraph.add(new ArrayList<>());
        }

        for(int i=0; i<vertexCount; i++){
            for(int j=0; j<graph.get(i).size(); j++){
                transposedGraph.get(graph.get(i).get(j)).add(i);
            }
        }

        return transposedGraph;
    }

    static void fillOrder(List<ArrayList<Integer>> graph, int v, boolean[] visited, Stack<Integer> stack){
        visited[v] = true;

        for(int i : graph.get(v)){
            if(!visited[i]){
                fillOrder(graph, i, visited, stack);
            }
        }

        //after all adjacent is processed we are pushing the vertex to stack.
        stack.push(v);
    }

    private static void dFSUtil(List<ArrayList<Integer>> graph, int vertex, boolean[] visited){
        visited[vertex] = true;
        System.out.print(vertex+ "\t");

        for(int i: graph.get(vertex)){
            if(!visited[i]){
                dFSUtil(graph, i, visited);
            }
        }
    }

    static void printSCCs(List<ArrayList<Integer>> graph) {
        int vertexCount = graph.size();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertexCount];

        //dfs for disconnected graph
        for (int i = 0; i < vertexCount; i++){
            if (!visited[i]) {
                fillOrder(graph, i, visited, stack);
            }
        }

        List<ArrayList<Integer>> transposedGraph = getTranspose(graph);
        Arrays.fill(visited, false);

        while (!stack.isEmpty()){
            int v = stack.pop();
            if (!visited[v]){
                dFSUtil(transposedGraph, v, visited);
                System.out.println();
            }
        }

        System.out.println();
    }


    public static void main(String[] args){
        int vertexCount = 5;
        List<ArrayList<Integer>> graph = new ArrayList<>(vertexCount);
        for(int i=0; i<vertexCount; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(0);
        graph.get(0).add(2);
        graph.get(2).add(1);
        graph.get(0).add(3);
        graph.get(3).add(4);

        printSCCs(graph);
    }
}
