package graph;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class AdjacencyMatrixGraph implements Graph{
    private int[][] data ;
    private int noOfVertecies;
    private GraphType edge = GraphType.UNDIRECTED;

    public AdjacencyMatrixGraph(int noOfVertecies, GraphType edge){
        this.noOfVertecies = noOfVertecies;
        this.edge = edge;
        data = new int[noOfVertecies][noOfVertecies];

        for(int i=0; i<noOfVertecies; i++){
            for(int j=0; j<noOfVertecies; j++){
                data[i][j] = 0;
            }
        }
    }

    public void addEdge(int v1, int v2) {
        if(v1<0 || v2<0 || v1>noOfVertecies || v2>noOfVertecies){
            throw new IllegalArgumentException("invalid input");
        }
        data[v1][v2] = 1;
        if(edge == GraphType.UNDIRECTED){
            data[v2][v1] = 1;
        }
    }

    public List<Integer> getAdjacentVertices(int v) {
        if(v<0 || v>noOfVertecies){
            throw new IllegalArgumentException("invalid input");
        }
        List<Integer> verticies = new ArrayList<Integer>();

        for(int i=0; i<noOfVertecies; i++){
            if(data[v][i] == 1){
                verticies.add(i);
            }
        }

        Collections.sort(verticies);

        return verticies;
    }
}
