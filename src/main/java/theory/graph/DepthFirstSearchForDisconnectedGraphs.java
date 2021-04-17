package theory.graph;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearchForDisconnectedGraphs {

    static void addEdge(List<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void DFSRec(List<ArrayList<Integer>> adj, int s, boolean[] visited)
    {
        visited[s]=true;
        System.out.print(s +" ");

        for(int u:adj.get(s)){
            if(!visited[u]) {
                DFSRec(adj, u, visited);
            }
        }
    }

    static void DFS(List<ArrayList<Integer>> adj, int V){
        boolean[] visited=new boolean[V];

        for(int i=0;i<V;i++){
            if(!visited[i]) {
                DFSRec(adj, i, visited);
            }
        }
    }

    public static void main(String[] args)
    {
        int V = 5;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,1,2);
        addEdge(adj,3,4);

        System.out.println("Following is Depth First Traversal for disconnected graphs: ");
        DFS(adj,V);
    }
}
