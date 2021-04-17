package theory.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CloneDirectedGraph {
    static void addEdge(List<ArrayList<Integer>> graph, int source, int destination){
        graph.get(source).add(destination);
    }

    static List<ArrayList<Integer>> clone(List<ArrayList<Integer>> graph){
        List<ArrayList<Integer>> clonedGraph = new ArrayList<>();
        int vertexCount = graph.size();
        for(int i=0; i<vertexCount; i++){
            clonedGraph.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[graph.size()];
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            for(int i:graph.get(tmp)){
                addEdge(clonedGraph, tmp, i);
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        return clonedGraph;
    }

    static void bfs(List<ArrayList<Integer>> graph){
        boolean[] visited = new boolean[graph.size()];
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            System.out.print(tmp + " ");
            for(int i:graph.get(tmp)){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args){
        int vertexCount = 5;
        List<ArrayList<Integer>> graph = new ArrayList<>(vertexCount);
        for(int i=0; i<vertexCount; i++){
            graph.add(new ArrayList<>());
        }
        addEdge(graph,0, 2);
        addEdge(graph,0, 3);
        addEdge(graph,0, 4);
        addEdge(graph,2, 0);
        addEdge(graph,4, 0);
        addEdge(graph,4, 3);
        addEdge(graph,4, 1);
        addEdge(graph,3, 2);
        addEdge(graph,1, 2);
        bfs(graph);
        System.out.println();
        List<ArrayList<Integer>> graph2 = clone(graph);
        bfs(graph2);
        System.out.println();
    }
}
