package theory.graph;

import java.util.Arrays;

public class BellmanFordForUnconnectedGraph {

    class Edge{
        int src;
        int dest;
        int weight;
    }

    private int vertexCount, edgeCount;
    private Edge[] edge;

    public BellmanFordForUnconnectedGraph(int vertexCount, int edgeCount){
        this.vertexCount = vertexCount;
        this.edgeCount = edgeCount;
        this.edge = new Edge[edgeCount];
        for(int i=0; i<edgeCount; i++){
            edge[i] = new Edge();
        }
    }

    public boolean containsNegativeCycle(){
        boolean[] visited = new boolean[vertexCount];
        int[] distance = new int[vertexCount];
        for(int i=0; i<vertexCount; i++){
            if(!visited[i]){
                if(containsNegativeCycle(i, distance)){
                    return true;
                }
            }
            for(int j=0; j<vertexCount; j++){
                if(distance[j]!= Integer.MAX_VALUE){
                    visited[i] = true;
                }
            }
        }
        return false;
    }

    public boolean containsNegativeCycle(int source, int[] distance){
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        for(int i=1; i<vertexCount; i++){
            for(int j=0; j<edgeCount; j++){
                int u = this.edge[j].src;
                int v = this.edge[j].dest;
                int weight =  this.edge[j].weight;

                if(distance[u]!=Integer.MAX_VALUE && distance[u] + weight < distance[v]){
                    distance[v] = distance[u] + weight;
                }
            }
        }

        for(int j=0; j<edgeCount; j++){
            int u = this.edge[j].src;
            int v = this.edge[j].dest;
            int weight =  this.edge[j].weight;

            if(distance[u]!=Integer.MAX_VALUE && distance[u] + weight < distance[v]){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){
        BellmanFordForUnconnectedGraph graph = new BellmanFordForUnconnectedGraph(5, 8);

        // Add edge 0-1 (or A-B in above figure)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;

        // Add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;

        // Add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;

        // Add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;

        // Add edge 1-4 (or A-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;

        // Add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;

        // Add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;

        // Add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;

        System.out.println(graph.containsNegativeCycle());
    }

}
