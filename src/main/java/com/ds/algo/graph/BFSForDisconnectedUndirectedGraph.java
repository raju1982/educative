package com.ds.algo.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BFSForDisconnectedUndirectedGraph {

    // A utility function to add an edge in an
    // undirected graph
    static void addEdge(List<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // breath first search
    private static void bfs(List<ArrayList<Integer>> adj, int startingPoint, boolean[] visitedNode) {
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

    public static void BFSDisconnected(List<ArrayList<Integer>> adj, int vertexCount){
        boolean[] visitedNode = new boolean[vertexCount];
        for(int i=0; i<vertexCount;i++){
            if(!visitedNode[i]){
                bfs(adj, i, visitedNode);
            }
        }
    }

    // Driver Code
    public static void main(String[] args) {
        // Creating a graph with 5 vertices
        int vertexCount = 5;
        List<ArrayList<Integer>> adj = new ArrayList<>(vertexCount);

        for (int i = 0; i < vertexCount; i++)
            adj.add(new ArrayList<Integer>());

        // Adding edges one by one
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        BFSDisconnected(adj, vertexCount);
    }
}