package theory.graph;

import java.util.*;

public class DetectCycleInUndirectedGraph {

    private static void addEdge(List<ArrayList<Integer>> graph, int pointA, int pointB){
        graph.get(pointA).add(pointB);
        graph.get(pointB).add(pointA);
    }

    //solution 1
    public static boolean bfsCycleDetection(List<ArrayList<Integer>> graph, int nodeCount){
        boolean[] visited = new boolean[nodeCount];

        // Set parentIndex vertex for every vertex as -1.
        int parentIndex[] = new int[nodeCount];
        Arrays.fill(parentIndex, -1);

        for(int i=0; i<nodeCount; i++) {
            if(!visited[i]) {
                if(bfsCycleDetection(graph, i, visited, parentIndex)){
                    return true;
                }
            }
        }

        return false;
    }

    //bfs traverse the edges in the shortest path style
    public static boolean bfsCycleDetection(List<ArrayList<Integer>> graph, int startPoint, boolean[] visited, int[] parentIndex){
        Queue<Integer> data = new LinkedList<>();
        data.add(startPoint);
        visited[startPoint] = true;

        while(!data.isEmpty()){
            int tmp = data.poll();
            for(int x: graph.get(tmp)){
                if(!visited[x]) {
                    data.add(x);
                    visited[x] = true;
                    parentIndex[x] = tmp;
                }
                else if (parentIndex[tmp]!=x){
                    return true;
                }
            }
        }
        return false;
    }


    //solution 2
    public static boolean dfsCycleDetection(List<ArrayList<Integer>> graph, int nodeCount){
        boolean[] visited = new boolean[nodeCount];
        for(int i=0; i<nodeCount; i++) {
            if(!visited[i]) {
                if (dfsCycleDetection(graph, i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfsCycleDetection(List<ArrayList<Integer>> graph, int startPoint, boolean[] visited, int parentIndex){
        visited[startPoint] = true;
        for(int i : graph.get(startPoint)) {
            if(!visited[i]) {
                if(dfsCycleDetection(graph, i, visited, startPoint)){
                    return true;
                }
            }
            else if(parentIndex != i){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int nodeCount = 7;
        List<ArrayList<Integer>> graph = new ArrayList<>(nodeCount);

        for(int i=0; i<nodeCount; i++){
            graph.add(new ArrayList<>());
        }

        // Adding edges one by one
        addEdge(graph,0,1);
        addEdge(graph,0,2);
        addEdge(graph,2,3);
        addEdge(graph,1,3);
        addEdge(graph,4,5);
        addEdge(graph,5,6);

        System.out.println(bfsCycleDetection(graph, nodeCount));
        System.out.println(dfsCycleDetection(graph, nodeCount));
    }
}
