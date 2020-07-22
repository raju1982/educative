package com.ds.algo.graph;

// using ArrayList in Java
/*
it is assumed that all vertices are reachable from the starting vertex.
But in the case of disconnected graph or any vertex that is unreachable from all vertex,
 */

import java.util.ArrayList;
import java.util.List;

class DetectCycleInDirectedGraph {

    // A utility function to add an edge in an
    // undirected graph
    static void addEdge(List<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

    //  depth first search
    private static boolean depthFirstSearch(List<ArrayList<Integer>> adj, int startingPoint, boolean[] visitedNode, boolean[] recStack) {
        visitedNode[startingPoint] = true;
        recStack[startingPoint] = true;
        System.out.println(startingPoint + " -> ");
        for(int adjacentNode : adj.get(startingPoint)){
            if(!visitedNode[adjacentNode]){
                if(depthFirstSearch(adj, adjacentNode, visitedNode, recStack)){
                    return true;
                }
            }
            else if(recStack[adjacentNode] == true){
                return true;
            }
        }
        recStack[startingPoint] = false;
        return false;
    }

    static boolean isCyclic(List<ArrayList<Integer>> adj, int noOfVertex) {
        boolean[] visitedNode = new boolean[noOfVertex];
        boolean[] recStack = new boolean[noOfVertex];
        for(int i=0; i<noOfVertex; i++) {
            if(!visitedNode[i]) {
                if(depthFirstSearch(adj, i, visitedNode, recStack)){
                    return true;
                }
            }
        }

        return false;
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
        addEdge(adj, 2, 1);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 3);

        System.out.println(isCyclic(adj, V));
    }
}