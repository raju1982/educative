package theory.graph;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class ShortestPathInDirectedAcyclicGraph {

    private int vertexCount;
    //array of linkedList
    private LinkedList<AdjListNode>[] adj;

    public ShortestPathInDirectedAcyclicGraph(int vertexCount) {
        this.vertexCount = vertexCount;
        adj = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; ++i)
            adj[i] = new LinkedList<>();
    }

    private void addEdge(int u, int v, int weight) {
        AdjListNode node = new AdjListNode(v, weight);
        adj[u].add(node);
    }

    private void topologicalSortUtil(int v, Boolean visited[], Stack stack) {
        visited[v] = true;

        for(AdjListNode node: adj[v]){
            if (!visited[node.getValue()])
                topologicalSortUtil(node.getValue(), visited, stack);
        }

        stack.add(v);
    }

    void shortestPath(int startVertex) {
        //get topological order in stack
        Stack stack = new Stack();
        Boolean visited[] = new Boolean[vertexCount];

        for (int i = 0; i < vertexCount; i++)
            visited[i] = false;

        for (int i = 0; i < vertexCount; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);

        //populate initial results
        int dist[] = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[startVertex] = 0;

        while (!stack.empty()) {
            int u = (int) stack.pop();
            if (dist[u] != Integer.MAX_VALUE) {
                for(AdjListNode node: adj[u]){
                    if (dist[node.getValue()] > dist[u] + node.getWeight()) {
                        dist[node.getValue()] = dist[u] + node.getWeight();
                    }
                }
            }
        }

        for (int i = 0; i < vertexCount; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.print("INF ");
            else
                System.out.print(dist[i] + " ");
        }
    }


    public static void main(String args[]) {
        ShortestPathInDirectedAcyclicGraph g = new ShortestPathInDirectedAcyclicGraph(6);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 4, 1);
        g.addEdge(1, 2, 3);
        g.addEdge(4, 2, 2);
        g.addEdge(4, 5, 4);
        g.addEdge(2, 3, 6);
        g.addEdge(5, 3, 1);

        int s = 0;
        System.out.println("Following are shortest distances " +
                "from source " + s);
        g.shortestPath(s);
    }
}
