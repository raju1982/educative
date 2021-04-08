package theory.graph;

import java.util.ArrayList;
import java.util.List;

//Adjacency List presentation
//Undirected Graphs
public class AdjacencyListPresentationOfUndirectedGraphs {
    static void addEdge(List<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void printGraph(List<ArrayList<Integer>> adj)
    {
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j)+" ");
            }
            System.out.println();
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

        printGraph(adj);
    }
}
