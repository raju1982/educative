package graph;
import java.util.List;

interface Graph {

    enum GraphType{
        DIRECTED,
        UNDIRECTED,
    }

    void addEdge(int v1, int v2);

    List<Integer> getAdjacentVertices(int v);
}


