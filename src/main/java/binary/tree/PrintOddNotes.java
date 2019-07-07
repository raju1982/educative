package binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintOddNotes {

    public static void main(String[] args) {
        binary.tree.Node a = new binary.tree.Node(5);
        binary.tree.Node b = new binary.tree.Node(7);
        binary.tree.Node c = new binary.tree.Node(9);
        binary.tree.Node d = new binary.tree.Node(12);
        binary.tree.Node e = new binary.tree.Node(14);
        binary.tree.Node f = new binary.tree.Node(16);
        binary.tree.Node g = new binary.tree.Node(19);
        binary.tree.Node h = new binary.tree.Node(21);

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

    static void printOddNodes(binary.tree.Node root) {
        Queue<binary.tree.Node> data = new LinkedList<>();
        data.add(root);
        while (!data.isEmpty()) {
            binary.tree.Node node = data.poll();
            if(node.getData()%2 != 0) {
                System.out.print(node.getData() + " -> ");
            }
            binary.tree.Node left = node.getLeftNode();
            if (left != null) {
                data.add(left);
            }
            Node right = node.getRightNode();
            if (right != null) {
                data.add(right);
            }
        }
    }
}





