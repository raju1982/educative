package theory.graph;

public class BellmanFord {

    class Edge {
        int src, dest, weight;
    }

    private int vertexCount, edgeCount;
    private Edge edge[];

    BellmanFord(int vertexCount, int edgeCount){
        this.vertexCount = vertexCount;
        this.edgeCount = edgeCount;
        edge = new Edge[edgeCount];
        for (int i = 0; i < edgeCount; ++i)
            edge[i] = new Edge();
    }

    void BellmanFord(int src){
        int[] dist = new int[this.vertexCount];
        for (int i = 0; i < this.vertexCount; ++i) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;

        for (int i = 1; i < this.vertexCount; i++) {
            for (int j = 0; j < this.edgeCount; j++) {
                int u = this.edge[j].src;
                int v = this.edge[j].dest;
                int weight = this.edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        for (int j = 0; j < this.edgeCount; j++) {
            int u = this.edge[j].src;
            int v = this.edge[j].dest;
            int weight = this.edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }
        printArr(dist, this.vertexCount);
    }

    void printArr(int dist[], int V)
    {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t" + dist[i]);
    }

    public static void main(String[] args){
        int vertexCount = 4;
        int edgeCount = 5;

        BellmanFord graph = new BellmanFord(vertexCount, edgeCount);

        // add edge 0-1 (or A-B)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 1;

        // add edge 0-2 (or A-C)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;

        // add edge 1-2 (or B-C)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = -3;

        // add edge 1-3 (or B-D)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;

        // add edge 2-3 (or C-D)
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 3;

        graph.BellmanFord(0);
    }


}
