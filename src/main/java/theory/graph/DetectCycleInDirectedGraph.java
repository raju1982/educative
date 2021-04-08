package theory.graph;

import java.util.List;
import java .util.ArrayList;

public class DetectCycleInDirectedGraph {

    public static void addEdge(List<ArrayList<Integer>> graph, int startIndex, int endIndex){
        graph.get(startIndex).add(endIndex);
    }


    public static boolean dfs(List<ArrayList<Integer>> graph, int noOfNodes){
        boolean[] visited = new boolean[noOfNodes];
        boolean[] recursionStack = new boolean[noOfNodes];

        for(int i=0; i<noOfNodes; i++) {
            if(!visited[i]) {
                if(dfs(graph, i, visited, recursionStack)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean dfs(List<ArrayList<Integer>> graph, int startIndex, boolean[] visited, boolean[] recursionStack){
        visited[startIndex] = true;
        recursionStack[startIndex] = true;

        for(int i: graph.get(startIndex)){
            if(!visited[i]){
                if(dfs(graph, i, visited, recursionStack)){
                    return true;
                }
            }
            else if(recursionStack[i]){
                return true;
            }
        }
        recursionStack[startIndex] = false;
        return false;
    }

    public static void main(String[] args){
        int noOfNodes = 4;
        List<ArrayList<Integer>> graph =  new ArrayList<>(noOfNodes);
        for(int i=0; i<noOfNodes; i++){
            graph.add(new ArrayList<>());
        }

        //1st graph
        addEdge(graph, 0, 1);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 1);

        //2nd graph
        /*addEdge(graph, 0, 1);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 1);
        addEdge(graph, 2, 3);*/

        System.out.println(dfs(graph, noOfNodes));
    }
}
