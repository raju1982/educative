package binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SortedArrayToBalancedBST {
    static Node root;

    /* A function that constructs Balanced Binary Search Tree
     from a sorted array */
    static Node sortedArrayToBST(int arr[], int start, int end) {

        /* Base Case */
        if (start > end) {
            return null;
        }

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);

        /* Recursively construct the left subtree and make it
         left child of root */
        node.setLeftNode(sortedArrayToBST(arr, start, mid - 1));

        /* Recursively construct the right subtree and make it
         right child of root */
        node.setRightNode(sortedArrayToBST(arr, mid + 1, end));

        return node;
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

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        root = sortedArrayToBST(arr, 0, arr.length - 1);
        breathFirstTraversal(root);
    }
}
