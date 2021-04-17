package theory.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfNodesInAGivenGraphLevel {

    private static void addEdge(List<ArrayList<Integer>> graph, int source, int destination){
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    public static int bfs(List<ArrayList<Integer>> graph, int startVertex, int level){
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[graph.size()];
        queue.add(startVertex);
        visited[startVertex] = 1;

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            for(int i:graph.get(tmp)){
                if(visited[i]!=1){
                    visited[i] = visited[tmp] + 1;
                    if(visited[i]<level){
                        queue.add(i);
                    }
                }
            }
        }
        int count = 0;
        for(int i=0; i<visited.length; i++){
            if(visited[i]==level){
                System.out.print(i + "\t");
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        int vertices = 6;
        List<ArrayList<Integer>> graph = new ArrayList<>(vertices);
        for(int i=0; i<vertices; i++){
            graph.add(new ArrayList<>());
        }

        addEdge(graph, 0,1);
        addEdge(graph, 0,2);
        addEdge(graph, 1,3);
        addEdge(graph, 2,3);
        addEdge(graph, 3,5);
        addEdge(graph, 2,4);

        //System.out.println(bfs(graph, 0, 1));
        System.out.println(bfs(graph, 0, 2));
        System.out.println(bfs(graph, 0, 3));
    }
}
