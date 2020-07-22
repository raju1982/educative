package com.ds.algo.graph;

// using ArrayList in Java
/*
it is assumed that all vertices are reachable from the starting vertex.
But in the case of disconnected graph or any vertex that is unreachable from all vertex,
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BFSUndirectedGraph {

    // A utility function to add an edge in an
    // undirected graph
    static void addEdge(List<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // breath first search
    static void bfs(List<ArrayList<Integer>> adj, int startingPoint) {
        boolean[] visitedNode = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(startingPoint);
        visitedNode[startingPoint] = true;
        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node + " -> ");
            for(int adjacentNode : adj.get(node)){
                if(!visitedNode[adjacentNode]){
                    queue.add(adjacentNode);
                    visitedNode[adjacentNode] = true;
                }
            }
        }
    }

    // Driver Code
    public static void main(String[] args) {
        // Creating a graph with 5 vertices
        int V = 6;
        List<ArrayList<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        // Adding edges one by one
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 0, 5);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 3, 5);
        addEdge(adj, 4, 5);

        bfs(adj, 0);
    }
}

