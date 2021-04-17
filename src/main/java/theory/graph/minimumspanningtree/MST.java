package theory.graph.minimumspanningtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MST {
    public static void testGraph1() {
        Graph g = new Graph(new ArrayList<>(), new ArrayList<>());
        int v = 5;

        // each edge contains the following: weight, src, dest
        ArrayList<Integer> e1 = new ArrayList<>(Arrays.asList(1, 1, 2));
        ArrayList<Integer> e2 = new ArrayList<>(Arrays.asList(1, 1, 3));
        ArrayList<Integer> e3 = new ArrayList<>(Arrays.asList(2, 2, 3));
        ArrayList<Integer> e4 = new ArrayList<>(Arrays.asList(3, 2, 4));
        ArrayList<Integer> e5 = new ArrayList<>(Arrays.asList(3, 3, 5));
        ArrayList<Integer> e6 = new ArrayList<>(Arrays.asList(2, 4, 5));

        List<ArrayList<Integer>> e = new ArrayList<>();
        e.add(e1);
        e.add(e2);
        e.add(e3);
        e.add(e4);
        e.add(e5);
        e.add(e6);

        g.generateGraph(v, e);
        System.out.println("Testing graph 1...");
        // g.printGraph();
        int w = g.findMinSpanningTree();
        g.printMst(w);
    }

    public static void main(String[] args) {
        testGraph1();
    }
}
