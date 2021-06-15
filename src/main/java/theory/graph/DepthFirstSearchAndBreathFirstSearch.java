package theory.graph;

import java.util.*;

public class DepthFirstSearchAndBreathFirstSearch {
    public static void depthFirstSearch(List<ArrayList<Integer>> graph){
        boolean[] visited = new boolean[graph.size()];

        for(int i=0; i<graph.size(); i++){
            if(!visited[i]){
                depthFirstSearch(graph, visited, i);
            }
        }

    }

    public static void depthFirstSearch(List<ArrayList<Integer>> graph, boolean[] visited, int i){
        System.out.print(i + "->");
        visited[i] = true;

        for(int j : graph.get(i)){
            if(!visited[i]){
                depthFirstSearch(graph, visited, j);
            }
        }

    }

    public static void breathFirstSearch(List<ArrayList<Integer>> graph){
        boolean[] visited = new boolean[graph.size()];

        for(int i=0; i<graph.size(); i++){
            if(!visited[i]){
                breathFirstSearch(graph, visited, i);
            }
        }
    }

    public static void breathFirstSearch(List<ArrayList<Integer>> graph, boolean[] visited, int i){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;
        while(!queue.isEmpty()){
            int j = queue.poll();
            System.out.print(j + "->");
            for(int k : graph.get(j)){
                if(!visited[k]){
                    queue.add(k);
                    visited[k] = true;
                }
            }
        }
    }

    public static void addEdge(List<ArrayList<Integer>> graph, int pointA, int pointB){
        graph.get(pointA).add(pointB);
        graph.get(pointB).add(pointA);
    }

    public static void main(String[] args){
        List<ArrayList<Integer>> graph = new ArrayList<>();
        int size = 8;
        for(int i=0; i<size; i++){
            graph.add(new ArrayList<>());
        }

        addEdge(graph,0,1);
        //addEdge(graph,1,5);
        addEdge(graph,5,6);
        addEdge(graph,6,7);
        addEdge(graph,5,7);
        addEdge(graph,1,2);
        addEdge(graph,2,4);
        addEdge(graph,2,3);

        depthFirstSearch(graph);
        System.out.println("\n");
        breathFirstSearch(graph);
    }
}
