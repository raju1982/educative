package binary.tree;

import java.util.Queue;
import java.util.LinkedList;

public class BreadthFirstAndDepthFirstTraversal {

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

        breathFirstTraversal(a);
        System.out.println();
        preOrderTravers(a);
        System.out.println();
        inOrderTravers(a);
        System.out.println();
        postOrderTravers(a);
    }

    static void breathFirstTraversal(Node node) {
        Queue<Node> data = new LinkedList<>();
        data.add(node);
        while (!data.isEmpty()) {
            Node np = data.poll();
            System.out.print(np.getData() + " -> ");
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

    static void preOrderTravers(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.getData() + " -> ");
        preOrderTravers(node.getLeftNode());
        preOrderTravers(node.getRightNode());
    }

    static void inOrderTravers(Node node){
        if(node == null){
            return;
        }
        inOrderTravers(node.getLeftNode());
        System.out.print(node.getData() + " -> ");
        inOrderTravers(node.getRightNode());
    }

    static void postOrderTravers(Node node){
        if(node == null){
            return;
        }
        postOrderTravers(node.getLeftNode());
        postOrderTravers(node.getRightNode());
        System.out.print(node.getData() + " -> ");
    }
}


