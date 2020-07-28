package com.ds.algo.graph;

// A Java program to print topological
// sorting of a DAG
import java.util.*;

// This class represents a directed graph
// using adjacency list representation
class TopologicalSortingDFS
{
    // No. of vertices
    private int V;

    // Adjacency List as ArrayList of ArrayList's
    private ArrayList<ArrayList<Integer>> adj;

    //Constructor
    TopologicalSortingDFS(int v)
    {
        V = v;
        adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i=0; i<v; ++i)
            adj.add(new ArrayList<Integer>());
    }

    // Function to add an edge into the graph
    void addEdge(int v,int w) { adj.get(v).add(w); }

    // A recursive function used by topologicalSort
    void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack)
    {
        // Mark the current node as visited.
        visited[v] = true;

        for(int node : adj.get(v)){
            if (!visited[node])
                topologicalSortUtil(node, visited, stack);
        }

        //Note that a vertex is pushed to stack only when all of its adjacent vertices
        // (and their adjacent vertices and so on) are already in stack.

        // Push current vertex to stack which stores result
        stack.push(v);
    }

    // The function to do Topological Sort.
    // It uses recursive topologicalSortUtil()
    void topologicalSort()
    {
        Stack<Integer> stack = new Stack<Integer>();

        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];


        // Call the recursive helper function to store Topological Sort starting from all vertices one by one
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);

        // Print contents of stack
        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }

    // Driver method
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        TopologicalSortingDFS g = new TopologicalSortingDFS(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println(
                "Following is a Topological " +
                        "sort of the given graph");
        g.topologicalSort();
    }
}

//5 4 2 3 1 0