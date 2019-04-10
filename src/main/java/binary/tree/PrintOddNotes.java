package binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintOddNotes {

    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(7);
        Node c = new Node(9);
        Node d = new Node(12);
        Node e = new Node(14);
        Node f = new Node(16);
        Node g = new Node(19);
        Node h = new Node(21);

        a.setLeftNode(b);
        a.setRightNode(c);

        b.setRightNode(d);
        b.setLeftNode(e);

        c.setRightNode(f);
        c.setLeftNode(g);
        f.setLeftNode(h);

        System.out.println();
        printOddNodes(a);
    }

    static void printOddNodes(Node node) {
        Queue<Node> data = new LinkedList<>();
        data.add(node);
        while (!data.isEmpty()) {
            Node np = data.poll();
            if(np.getData()%2 != 0) {
                System.out.print(np.getData() + " -> ");
            }
            Node left = np.getLeftNode();
            if (left != null) {
                data.add(left);
            }
            Node right = np.getRightNode();
            if (right != null) {
                data.add(right);
            }
        }
    }
}


