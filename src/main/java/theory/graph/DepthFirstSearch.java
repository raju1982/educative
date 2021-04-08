package theory.graph;

import java.util.ArrayList;
import java.util.List;

//undirected and connected graph, we also have a source
public class DepthFirstSearch {

    static void addEdge(List<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }


    static void dfs(List<ArrayList<Integer>> adj, boolean[] visited, int s)
    {
        visited[s]=true;
        System.out.print(s +" ");

        for(int u:adj.get(s)){
            if(!visited[u]) {
                dfs(adj, visited, u);
            }
        }
    }

    public static void dfs(List<ArrayList<Integer>> graph, int size){
        boolean[] visited = new boolean[size];
        for(int i=0; i<size; i++){
            if(!visited[i]){
                dfs(graph, visited, i);
            }
        }
    }


    public static void main(String[] args)
    {
        int V = 7;
        List<ArrayList<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,2,3);
        addEdge(adj,1,3);
        addEdge(adj,1,4);
        addEdge(adj,3,4);

        System.out.println("Following is Depth First Traversal: ");
        dfs(adj,V);
    }
}
