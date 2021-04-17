package theory.graph.minimumspanningtree;

import java.util.Arrays;

public class PrimAlgo {

    static final int VertexCount = 4;

    public static int primMST(int graph[][]) {
        int[] key = new int[VertexCount];
        int res = 0;
        Arrays.fill(key, Integer.MAX_VALUE);
        boolean[] mSet = new boolean[VertexCount];
        key[0] = 0;

        for (int count = 0; count < VertexCount; count++) {
            int u = -1;

            for (int i = 0; i < VertexCount; i++) {
                if (!mSet[i] && (u == -1 || key[i] < key[u])) {
                    u = i;
                }
            }

            mSet[u] = true;
            res += key[u];

            for (int v = 0; v < VertexCount; v++) {
                if (graph[u][v] != 0 && mSet[v] == false) {
                    key[v] = Math.min(key[v], graph[u][v]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //row count = column count = vertex count
        // this graph represent the weights of different edges
        int graph[][] = new int[][]{
                {0, 5, 8, 0},
                {5, 0, 10, 15},
                {8, 10, 0, 20},
                {0, 15, 20, 0},};

        System.out.print(primMST(graph));
    }

}
