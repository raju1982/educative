package binary.tree;

/*
// Java program to print nodes at k distance from root

/* A binary tree node has data, pointer to left child
and a pointer to right child */
public class PrintNodeAtKDistanceFromRoot {

    static class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    Node root;

    void printKDistant(Node node, int k)
    {
        if (node == null)
            return;
        if (k == 0)
        {
            System.out.print(node.data + " ");
            return;
        }
        else
        {
            printKDistant(node.left, k - 1);
            printKDistant(node.right, k - 1);
        }
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        PrintNodeAtKDistanceFromRoot tree = new PrintNodeAtKDistanceFromRoot();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(8);

        tree.printKDistant(tree.root, 2);
    }

}