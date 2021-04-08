package theory.graph;

import java.util.ArrayList;
import java.util.List;

public class FindConnectedComponentInUndirectedGraph {

    static void addEdge(List<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void DFSRec(List<ArrayList<Integer>> adj, int s, boolean[] visited)
    {
        visited[s]=true;
        //System.out.print(s +" ");

        for(int u:adj.get(s)){
            if(visited[u]==false)
                DFSRec(adj,u,visited);
        }
    }

    static int DFS(List<ArrayList<Integer>> adj, int V){
        boolean[] visited=new boolean[V];
        int count = 0;
        for(int i = 0; i<V; i++)
            visited[i] = false;

        for(int i=0;i<V;i++){
            if(visited[i]==false) {
                count++;
                DFSRec(adj, i, visited);
            }
        }

        return count;
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
        System.out.println(DFS(adj,V));
    }


}
