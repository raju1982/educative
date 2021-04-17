package theory.graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class ISDirectedGraphATree {

    public static boolean isTree(List<ArrayList<Integer>> graph){
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int visitedVertexCount = 1;
        visited[0] = true;

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            for(int i : graph.get(tmp)) {
                if (!visited[i]) {
                    queue.add(i);
                    visitedVertexCount++;
                    visited[i] = true;
                } else {
                    return false;
                }
            }
        }

        return graph.size() == visitedVertexCount;
    }

    public static void main(String[] args){
        int noOfVertex = 5;
        List<ArrayList<Integer>> graph = new ArrayList<>(noOfVertex);
        for(int i=0; i<noOfVertex; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(0).add(3);
        graph.get(0).add(4);
        graph.get(3).add(4);

        System.out.println(isTree(graph));
    }
}

/*
We have used BFS traversal in this solution but, note that it can also be performed using DFS traversal.
We have used the root node, i.e, 0 vertice, as the source node for the traversal. We maintain a count of the visited nodes in the variable numberOfVisited.
During traversal, if an already visited vertex is encountered, we return false as it means that the graph fails the tree conditions.
In fact, this condition also encompasses the check cyclic condition and check one parent condition from the solution given above. Hence, it removes redundancy.
Finally, when the BFS loop ends, we check the numberOfVisited variable to see if all vertices were visited.
This condition takes care of the graph is connected check that we performed previously.
If the condition fails, false is returned. Otherwise, the function isTree returns true.
*/
