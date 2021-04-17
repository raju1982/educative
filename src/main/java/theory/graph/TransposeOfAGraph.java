package theory.graph;

import java.util.ArrayList;
import java.util.List;

public class TransposeOfAGraph {
    public static List<ArrayList<Integer>> solution(List<ArrayList<Integer>> graph){
        int vertexCount = graph.size();
        List<ArrayList<Integer>> transposedGraph = new ArrayList<>(vertexCount);
        for(int i=0; i<vertexCount; i++){
            transposedGraph.add(new ArrayList<>());
        }

        for(int i=0; i<graph.size(); i++){
            for(int j=0; j<graph.get(i).size(); j++){
                transposedGraph.get(graph.get(i).get(j)).add(i);
            }
        }

        return transposedGraph;
    }

    public static void main(String[] args){
        int vertexCount = 5;
        List<ArrayList<Integer>> graph = new ArrayList<>(vertexCount);
        for(int i=0; i<vertexCount; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(4);
        graph.get(1).add(3);

        List<ArrayList<Integer>> transposedGraph = solution(graph);

        System.out.println();
    }
}
