package theory.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int label;
    List<Node> neighbors;

    public Node(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}
