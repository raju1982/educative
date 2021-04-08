package theory.graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class TopologicalSortingKahnBFS {

    public static void addEdge(List<ArrayList<Integer>> graph, int start, int end, int[] inDegree){
        graph.get(start).add(end);
        inDegree[end] = inDegree[end] + 1;
    }

    public static void topologicalSort(List<ArrayList<Integer>> graph, int[] inDegree){

        //we can calculate indegree here also. O(E) -> E is no. of edges
        /*
         for (int u = 0; u < V; u++) {
            for (int x:adj.get(u))
                in_degree[x]++;
        }
         */


        Queue<Integer> queue =  new LinkedList<>();
        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            System.out.print(tmp + "\t");

            for(int i : graph.get(tmp)){
                inDegree[i] = inDegree[i] - 1;
                if(inDegree[i]==0){
                    queue.add(i);
                }
            }

        }
    }

    public static void main(String[] args){
        int verticesCount = 5;
        List<ArrayList<Integer>> graph = new ArrayList<>(verticesCount);
        for(int i=0; i<verticesCount; i++){
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[verticesCount];
        addEdge(graph, 0, 2, inDegree);
        addEdge(graph, 0, 3, inDegree);
        addEdge(graph, 2, 3, inDegree);
        addEdge(graph, 1, 3, inDegree);
        addEdge(graph, 1, 4, inDegree);
        topologicalSort(graph, inDegree);
    }
}
