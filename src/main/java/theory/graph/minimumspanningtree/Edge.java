package theory.graph.minimumspanningtree;

import theory.graph.minimumspanningtree.Vertex;

public class Edge {
    int weight;
    boolean visited;
    Vertex src;
    Vertex dest;

    public Edge(int weight, boolean visited, Vertex src, Vertex dest) {
        this.weight = weight;
        this.visited = visited;
        this.src = src;
        this.dest = dest;
    }
}
