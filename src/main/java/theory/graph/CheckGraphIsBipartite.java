package theory.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheckGraphIsBipartite {
    static void addEdge(List<ArrayList<Integer>> graph, int source, int destination){
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    static boolean isBipartite(List<ArrayList<Integer>> graph){
        boolean[] visited = new boolean[graph.size()];
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int[] color = new int[graph.size()];
        color[0] = 1;

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            for(int i : graph.get(tmp)){
                if(!visited[i]){
                    visited[i] = true;
                    color[i] = color[tmp]==1?-1:1;
                    queue.add(i);
                }
                else{
                    if(color[i] == color[tmp]){
                        return false;
                    }
                }
            }
        }

        return true;
    }


    static boolean isBipartiteDFS(List<ArrayList<Integer>> graph){
        boolean[] visited = new boolean[graph.size()];
        visited[0] = true;
        boolean[] color = new boolean[graph.size()];
        color[0] = true;
        return dfsRec(graph, 1, visited, color);
    }

    static boolean dfsRec(List<ArrayList<Integer>> graph, int source, boolean[] visited, boolean[] color){
        for(int i : graph.get(source)){
            if(!visited[i]){
                visited[i] = true;
                color[i] = !color[source];
                if(!dfsRec(graph, i, visited, color)){
                    return false;
                }
            }
            else{
                if(color[i] == color[source]){
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args){
        int vertexCount = 4;
        List<ArrayList<Integer>> graph = new ArrayList<>(vertexCount);
        for(int i=0; i<vertexCount; i++){
            graph.add(new ArrayList<>());
        }

        addEdge(graph,0, 1);
        addEdge(graph,1, 2);
        addEdge(graph,2, 3);
        addEdge(graph,3, 0);

        System.out.println(isBipartite(graph));

        System.out.println(isBipartiteDFS(graph));



        List<ArrayList<Integer>> graph2 = new ArrayList<>(vertexCount);
        for(int i=0; i<vertexCount; i++){
            graph2.add(new ArrayList<>());
        }

        addEdge(graph2,0, 1);
        addEdge(graph2,0, 2);
        addEdge(graph2,1, 2);
        addEdge(graph2,2, 3);
        addEdge(graph2,3, 0);

        System.out.println(isBipartite(graph2));
        System.out.println(isBipartiteDFS(graph2));
    }
}
