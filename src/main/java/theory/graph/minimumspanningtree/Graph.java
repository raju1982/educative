package theory.graph.minimumspanningtree;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    List<Vertex> vertices;
    List<Edge> edges;

    public Graph(List<Vertex> vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    // This method returns the vertex with a given id if it
    // already exists in the graph, returns NULL otherwise
    Vertex vertexExists(int id) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).id == id) {
                return vertices.get(i);
            }
        }
        return null;
    }

    // This method generates the graph with v verticesCount and e edgesCount
    void generateGraph(int verticesCount, List<ArrayList<Integer>> edgesCount) {
        // create verticesCount
        for (int i = 0; i < verticesCount; i++) {
            Vertex v = new Vertex(i + 1, false);
            this.vertices.add(v);
        }
        // create edgesCount
        for (int i = 0; i < edgesCount.size(); i++) {
            Vertex src = vertexExists(edgesCount.get(i).get(1));
            Vertex dest = vertexExists(edgesCount.get(i).get(2));
            Edge e = new Edge(edgesCount.get(i).get(0), false, src, dest);
            this.edges.add(e);
        }
    }

    // This method finds the MST of a graph using Prim's Algorithm.
    // returns the weight of the MST
    int findMinSpanningTree() {
        int vertex_count = 0;
        int weight = 0;

        // Add first vertex to the MST
        Vertex current = vertices.get(0);
        current.visited = true;
        vertex_count++;

        // Construct the remaining MST using the
        // smallest weight edge
        while (vertex_count < vertices.size()) {
            Edge smallest = null;
            for (int i = 0; i < edges.size(); i++) {
                if (edges.get(i).visited == false) {
                    if (edges.get(i).src.visited == true && edges.get(i).dest.visited == false) {
                        if (smallest == null || edges.get(i).weight < smallest.weight) {
                            smallest = edges.get(i);
                        }
                    }
                }
            }

            smallest.visited=true;
            smallest.dest.visited=true;
            weight += smallest.weight;
            vertex_count++;
        }
        return weight;
    }

    String printGraph() {
        String result = "";

        for (int i = 0; i < edges.size(); i++) {
            result += edges.get(i).src.id + "->"
                    + edges.get(i).dest.id + "["
                    + edges.get(i).weight + ", "
                    + edges.get(i).visited + "]  ";
        }
        return result;
    }

    void printMst(int w) {
        System.out.println("MST");
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).visited == true) {
                System.out.println(edges.get(i).src.id + "->" + edges.get(i).dest.id);
            }
        }
        System.out.println("weight: " + w);
        System.out.println();
    }
}
