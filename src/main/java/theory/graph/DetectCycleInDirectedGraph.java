package theory.graph;

import java.util.List;
import java .util.ArrayList;

//O(V+E), which we already know is the complexity of traversing the adjacency list that represents our graph.
public class DetectCycleInDirectedGraph {

    public static void addEdge(List<List<Integer>> graph, int startIndex, int endIndex){
        graph.get(startIndex).add(endIndex);
    }

    public static boolean dfs(List<List<Integer>> graph, int noOfNodes){
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

    public static boolean dfs(List<List<Integer>> graph, int startIndex, boolean[] visited, boolean[] recursionStack){
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


    public static boolean detectCycle(List<List<Integer>> graph){
        boolean[] visited = new boolean[graph.size()];
        return detectCycle(graph, visited, 0, new ArrayList<>());
    }

    public static boolean detectCycle(List<List<Integer>> graph, boolean[] visited, int node, List<Integer> parentStack){
        visited[node] = true;

        for(int i: graph.get(node)){
            if(!visited[i]){
                parentStack.add(node);
                boolean val = detectCycle(graph, visited, i, parentStack);
                parentStack.remove(parentStack.size()-1);
                if(val){
                    return true;
                }
            }
            else{
                if(parentStack.contains(i)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCyclic(List<List<Integer>> graph){
        return isCyclic(graph, new boolean[graph.size()], 0, new ArrayList<> ());
    }


    public static boolean isCyclic(List<List<Integer>> graph, boolean[] visited, int index, List<Integer> stack){
        visited[index] = true;
        for(int i : graph.get(index)){
            if(!visited[i]){
                stack.add(index);
                if(isCyclic(graph, visited, i, stack)){
                    return true;
                }
                stack.remove(stack.size()-1);
            }
            else if(stack.contains(i)){
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args){
        int noOfNodes = 4;
        List<List<Integer>> graph =  new ArrayList<>(noOfNodes);
        for(int i=0; i<noOfNodes; i++){
            graph.add(new ArrayList<>());
        }

        //1st graph
        addEdge(graph, 0, 1);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 1);

        System.out.println(dfs(graph, noOfNodes));
        System.out.println(detectCycle(graph));
        System.out.println(isCyclic(graph));
    }
}
