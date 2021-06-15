package theory.graph;

import java.util.Comparator;
import java.util.*;

public class DijkstraShortestPathAlgorithm {
    static class Node{
        public int val;
        public int cost;

        public Node(int node, int cost)
        {
            this.val = node;
            this.cost = cost;
        }
    }

    static Comparator<Node> costComparator = (s1, s2) -> s1.cost - s2.cost;

    // Function for Dijkstra's Algorithm
    public static int[] dijkstra(List<List<Node> > adj, int src){
        boolean[] visited = new boolean[adj.size()];
        int[] dist = new int[adj.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // Distance to the source is 0
        dist[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue(costComparator);
        // Add source node to the priority queue
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {

            // remove the minimum distance node
            // from the priority queue
            int u = pq.remove().val;
            visited[u] = true;

            for (int i = 0; i < adj.get(u).size(); i++) {
                Node v = adj.get(u).get(i);
                // If current node hasn't already been processed
                if (!visited[v.val]) {
                    int edgeDistance = v.cost;
                    int newDistance = dist[u] + edgeDistance;

                    // If new distance is cheaper in cost
                    if (newDistance < dist[v.val])
                        dist[v.val] = newDistance;

                    // Add the current node to the queue
                    pq.add(new Node(v.val, dist[v.val]));
                }
            }

        }

        return dist;
    }

    // Driver code
    public static void main(String arg[])
    {
        int V = 5;
        int source = 0;

        // Adjacency list representation of the
        // connected edges
        List<List<Node>> adj = new ArrayList<>();

        // Initialize list for every node
        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<>();
            adj.add(item);
        }

        // Inputs for the DPQ graph
        adj.get(0).add(new Node(1, 9));
        adj.get(0).add(new Node(2, 3));
        adj.get(0).add(new Node(3, 5));
        adj.get(0).add(new Node(4, 3));

        adj.get(2).add(new Node(1, 2));
        adj.get(2).add(new Node(3, 1));

        // Calculate the single source shortest path
        int[] dist = dijkstra(adj, source);

        // Print the shortest path to all the nodes
        // from the source node
        System.out.println("The shorted path from node :" + Arrays.toString(dist));
    }

}
//The shorted path from node :[0, 5, 3, 4, 3]