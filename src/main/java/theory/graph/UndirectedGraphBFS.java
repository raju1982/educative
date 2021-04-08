package theory.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UndirectedGraphBFS {

    static void addEdge(List<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void BFS(List<ArrayList<Integer>> adj,int V,int s)
    {
        boolean[] visited=new boolean[V];
        for(int i = 0; i < V; i++)
            visited[i] = false;

        Queue<Integer> q = new LinkedList<>();

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
        int V = 4;
        List<ArrayList<Integer> > adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Adding edges one by one
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);

        BFS(adj, V, 0);
    }


}
