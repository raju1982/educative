package binary.tree;

// Java program to print boundary traversal of binary tree


class BoundaryTraversalOfBinaryTree {
    Node root;

    // A simple function to print leaf nodes of a binary tree
    //like in-order
    void printLeaves(Node node)
    {
        if (node != null) {
            printLeaves(node.leftNode);

            // Print it if it is a leaf node
            if (node.leftNode == null && node.rightNode == null)
                System.out.print(node.data + " ");
            printLeaves(node.rightNode);
        }
    }

    // A function to print all left boundary nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
    //like pre-order
    void printBoundaryLeft(Node node)
    {
        if (node != null) {
            if (node.leftNode != null) {
                // to ensure top down order, print the node
                // before calling itself for left subtree
                System.out.print(node.data + " ");
                printBoundaryLeft(node.leftNode);
            }
            else if (node.rightNode != null) {
                System.out.print(node.data + " ");
                printBoundaryLeft(node.rightNode);
            }
            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }

    // A function to print all right boundary nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    //like post-order
    void printBoundaryRight(Node node)
    {
        if (node != null) {
           if (node.leftNode != null) {
                printBoundaryRight(node.leftNode);
                System.out.print(node.data + " ");
            } else if (node.rightNode != null) {
                // to ensure bottom up order, first call for right
                // subtree, then print this node
                printBoundaryRight(node.rightNode);
                System.out.print(node.data + " ");
            }

            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }

    // A function to do boundary traversal of a given binary tree
    void printBoundary(Node node)
    {
        if (node != null) {
            System.out.print(node.data + " ");

            // Print the left boundary in top-down manner.
            printBoundaryLeft(node.leftNode);

            // Print all leaf nodes
            printLeaves(node.leftNode);
            printLeaves(node.rightNode);

            // Print the right boundary in bottom-up manner
            printBoundaryRight(node.rightNode);
        }
    }

    // Driver program to test above functions
    public static void main(String args[])
    {
        BoundaryTraversalOfBinaryTree tree = new BoundaryTraversalOfBinaryTree();
        tree.root = new Node(20);
        tree.root.leftNode = new Node(8);
        tree.root.leftNode.leftNode = new Node(4);
        tree.root.leftNode.rightNode = new Node(12);
        tree.root.leftNode.rightNode.leftNode = new Node(10);
        tree.root.leftNode.rightNode.rightNode = new Node(14);
        tree.root.rightNode = new Node(22);
        tree.root.rightNode.rightNode = new Node(25);
        tree.printBoundary(tree.root);
    }
}
