package theory.graph;

import java.util.*;

public class ShortestPathInUnweightedGraph {

    private static void addEdge(List<ArrayList<Integer>> graph, int pointA, int pointB){
        graph.get(pointA).add(pointB);
        graph.get(pointB).add(pointA);
    }

    //bfs traveres the edges in the shortest path style
    public static void bfs(List<ArrayList<Integer>> graph, int startPoint, int nodeCount){
        boolean[] visited = new boolean[nodeCount];

        Queue<Integer> data = new LinkedList<>();
        data.add(startPoint);
        visited[startPoint] = true;

        while(!data.isEmpty()){
            int tmp = data.poll();
            System.out.print(tmp + " , ");
            for(int x: graph.get(tmp)){
                if(!visited[x]) {
                    data.add(x);
                    visited[x] = true;
                }
            }
        }
    }

    public static int[] solution(List<ArrayList<Integer>> graph, int startPoint){
        int[] result = new int[graph.size()];
        Arrays.fill(result, Integer.MAX_VALUE);

        result[startPoint] = 0;

        boolean[] visited = new boolean[graph.size()];

        Queue<Integer> data = new LinkedList<>();
        data.add(startPoint);
        visited[startPoint] = true;

        while(!data.isEmpty()){
            int tmp = data.poll();
            for(int x: graph.get(tmp)){
                if(!visited[x]) {
                    result[x] = result[tmp] + 1;
                    data.add(x);
                    visited[x] = true;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int nodeCount = 5;
        List<ArrayList<Integer>> graph = new ArrayList<>(nodeCount);

        for(int i=0; i<nodeCount; i++){
            graph.add(new ArrayList<>());
        }

        addEdge(graph,0,1);
        addEdge(graph,0,2);
        addEdge(graph,2,3);
        addEdge(graph,1,3);
        addEdge(graph,1,4);
        addEdge(graph,3,4);

        bfs(graph, 0, nodeCount);
        System.out.println();
        System.out.println(Arrays.toString(solution(graph, 0)));
    }

}
