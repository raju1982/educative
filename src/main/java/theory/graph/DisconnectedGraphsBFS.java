package theory.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DisconnectedGraphsBFS {
    static void addEdge(List<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void BFSDin(List<ArrayList<Integer>> adj, int V){
        boolean[] visited=new boolean[V];

        for(int i=0;i<V;i++){
            if(visited[i]==false) {
                BFS(adj, i, visited);
                System.out.println();
            }
        }
    }

    static void BFS(List<ArrayList<Integer>> adj,int s, boolean[] visited)
    {
        Queue<Integer> q=new LinkedList<>();

        visited[s] = true;
        q.add(s);

        while(q.isEmpty()==false)
        {
            int u = q.poll();
            System.out.print(u + " ");

            for(int v:adj.get(u)){
                if(visited[v]==false){
                    visited[v]=true;
                    q.add(v);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int V = 7;
        List<ArrayList<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Adding edges one by one
        addEdge(adj,0,1);
        addEdge(adj,1,2);
        addEdge(adj,3,4);
        addEdge(adj,5,3);
        addEdge(adj,5,6);
        addEdge(adj,3,6);

        BFSDin(adj,V);
    }

}
