package com.ds.algo.graph;

// using ArrayList in Java
/*
it is assumed that all vertices are reachable from the starting vertex.
But in the case of disconnected graph or any vertex that is unreachable from all vertex,
 */

import java.util.ArrayList;
import java.util.List;

class DepthFirstSearchInUndirectedGraph {

    // A utility function to add an edge in an
    // undirected graph
    static void addEdge(List<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    //  depth first search
    private static void depthFirstSearch(List<ArrayList<Integer>> adj, int startingPoint, boolean[] visitedNode) {
            visitedNode[startingPoint] = true;
            System.out.print(startingPoint + " -> ");
            for(int adjacentNode : adj.get(startingPoint)){
                if(!visitedNode[adjacentNode]){
                    depthFirstSearch(adj, adjacentNode, visitedNode);
                }
            }
    }

    static void bfs(List<ArrayList<Integer>> adj, int startingPoint) {
         boolean[] visitedNode = new boolean[adj.size()];
         depthFirstSearch(adj, startingPoint, visitedNode);
    }

    // Driver Code
    public static void main(String[] args) {
        // Creating a graph with 5 vertices
        int V = 7;
        List<ArrayList<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        // Adding edges one by one
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 4, 5);
        addEdge(adj, 4, 6);
        addEdge(adj, 5, 6);

        bfs(adj, 0);
    }
}

