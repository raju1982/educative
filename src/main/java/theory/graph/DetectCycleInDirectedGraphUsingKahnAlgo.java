package theory.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInDirectedGraphUsingKahnAlgo {

    public static void addEdge(List<ArrayList<Integer>> graph, int start, int end, int[] inDegree){
        graph.get(start).add(end);
        inDegree[end] = inDegree[end] + 1;
    }

    public static boolean isCycle_topologicalSort(List<ArrayList<Integer>> graph, int[] inDegree){

        Queue<Integer> queue =  new LinkedList<>();
        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        int count = 0 ;
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            System.out.print(tmp + "\t");

            for(int i : graph.get(tmp)){
                inDegree[i] = inDegree[i] - 1;
                if(inDegree[i]==0){
                    queue.add(i);
                }
            }
            count++;
        }
        //if count != verticesCount There exists a cycle in the graph
        return (count != inDegree.length);
    }

    public static void main(String[] args){
        int verticesCount = 5;
        List<ArrayList<Integer>> graph = new ArrayList<>(verticesCount);
        for(int i=0; i<verticesCount; i++){
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[verticesCount];
        addEdge(graph, 0, 2, inDegree);
        addEdge(graph, 3, 0, inDegree);
        addEdge(graph, 2, 3, inDegree);
        addEdge(graph, 1, 3, inDegree);
        addEdge(graph, 1, 4, inDegree);
        System.out.println(isCycle_topologicalSort(graph, inDegree));
    }


}

