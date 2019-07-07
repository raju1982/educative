package binary.tree;

// A Java program for in-place conversion of Binary Tree to DLL

class BinaryTreeToDoubleLinkedList
{
    Node root;

    // head --> Pointer to head node of created doubly linked list
    Node head;

    // Initialize previously visited node as NULL. This is
    // static so that the same value is accessible in all recursive
    // calls
    static Node prev = null;

    // A simple recursive function to convert a given Binary tree
    // to Doubly Linked List
    // root --> Root of Binary Tree
    void BinaryTree2DoubleLinkedList(Node root)
    {
        // Base case
        if (root == null)
            return;

        // Recursively convert left subtree
        BinaryTree2DoubleLinkedList(root.leftNode);

        // Now convert this node
        if (prev == null)
            head = root;
        else
        {
            root.leftNode = prev;
            prev.rightNode = root;
        }
        prev = root;

        // Finally convert right subtree
        BinaryTree2DoubleLinkedList(root.rightNode);
    }

    // Function to print nodes in a given doubly linked list
    void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.rightNode;
        }
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
        // Let us create the tree as shown in above diagram
        BinaryTreeToDoubleLinkedList tree = new BinaryTreeToDoubleLinkedList();
        tree.root = new Node(10);
        tree.root.leftNode = new Node(12);
        tree.root.rightNode = new Node(15);
        tree.root.leftNode.leftNode = new Node(25);
        tree.root.leftNode.rightNode = new Node(30);
        tree.root.rightNode.leftNode = new Node(36);

        // convert to DLL
        tree.BinaryTree2DoubleLinkedList(tree.root);

        // Print the converted List
        tree.printList(tree.head);

    }
}
// This code has been contributed by Mayank Jaiswal(mayank_24)

