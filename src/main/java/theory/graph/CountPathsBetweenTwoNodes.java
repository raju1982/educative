package theory.graph;

import java.util.*;

public class CountPathsBetweenTwoNodes {

    public static void dfs(List<ArrayList<Integer>> graph){
        boolean[] visited = new boolean[graph.size()];
        dfs(graph, visited, 0);
    }

    private static void dfs(List<ArrayList<Integer>> graph, boolean[] visited, int startPoint){
        visited[startPoint] =  true;
        System.out.print(startPoint + " ");
        for(int i: graph.get(startPoint)){
            if(!visited[i]){
                dfs(graph, visited, i);
            }
        }
    }

    private static int countPathsRecursive(List<ArrayList<Integer>> graph, int start, int destination, int count) {

        //checking if destination is reached meaning 1 path available
        if (start == destination) {
            count++;
        }
        else{
            for(int i: graph.get(start)){
                count = countPathsRecursive(graph, i, destination, count);
            }
        }

        return count;
    }

    public static int countPaths(List<ArrayList<Integer>> graph, int start, int destination){
        int count = 0;
        return countPathsRecursive(graph, start, destination, count);
    }




    //easier implementation
    private static int pathCount = 0;
    private static void countPathsDiffImpl(List<ArrayList<Integer>> graph, int start, int end){
        boolean[] visited = new boolean[graph.size()];
        dfsRec(graph, start, end, visited);
    }

    private static void dfsRec(List<ArrayList<Integer>> graph, int start, int end, boolean[] visited){
        if(start == end){
            pathCount++;
            return;
        }
        visited[start] = true;
        for(int i: graph.get(start)){
            dfsRec(graph, i, end, visited);
        }
    }

    public static int countPath(List<ArrayList<Integer>> adj, int start , int end){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int count = 0;
        boolean[] visited = new boolean[adj.size()];
        visited[start] = true;

        while(!queue.isEmpty()){
            int tmp = queue.poll();

            for(int i: adj.get(tmp)){
                if(i==end){
                    count++;
                }
                if(!visited[i]){
                    queue.add(i);
                }
            }
        }

        return count;
    }




    public static void main(String[] args){
        int size = 7;
        List<ArrayList<Integer>> graph = new ArrayList<>(size);
        for(int i=0; i<size; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(1).add(5);
        graph.get(2).add(4);
        graph.get(2).add(3);
        graph.get(5).add(6);
        graph.get(5).add(3);
        graph.get(3).add(6);
        //dfs(graph);

        System.out.println(countPaths(graph, 0, 6));

        countPathsDiffImpl(graph, 0, 6);
        System.out.println(pathCount);

        System.out.println(countPath(graph, 0, 6));
    }
}


/*
class Count {

    public static int countPaths(Graph g, int start, int destination){
        int count = 0;
        return countPathsRecursive(g, start, destination, count);
    }
    public static int countPathsRecursive(Graph g, int start, int destination, int count) {

        LinkedList < Integer > Llist[];
        Llist = g.getAdj();

        //checking if destination is reached meaning 1 path available
        if (start == destination) {
            count++;
        }
        else {
            //Find paths from adjacent vertices
            for (int i = 0; i < Llist[start].size(); i++) {
                int ajdacentVertex = Llist[start].get(i);
                count = countPathsRecursive(g, ajdacentVertex, destination, count);
            }
        }
        return count;
    }
}
class Main {
    public static void main(String args[]) {

        int answer;
        Graph g1 = new Graph(6);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(3, 4);
        g1.addEdge(2, 3);
        g1.addEdge(4, 5);

        answer = Count.countPaths(g1, 0, 5);
        System.out.println(answer);

        Graph g2 = new Graph(7);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(1, 5);
        g2.addEdge(2, 3);
        g2.addEdge(2, 4);
        g2.addEdge(5, 3);
        g2.addEdge(5, 6);
        g2.addEdge(3, 6);

        answer = Count.countPaths(g2, 0, 3);
        System.out.println(answer);
    }
}
 */