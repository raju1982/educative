package binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SortedArrayToBalancedBST {
    static binary.tree.Node root;

    /* A function that constructs Balanced Binary Search Tree
     from a sorted array */
    /*
    1) Get the Middle of the array and make it root.
2) Recursively do same for left half and right half.
      a) Get the middle of left half and make it left child of the root
          created in step 1.
      b) Get the middle of right half and make it right child of the
          root created in step 1.
     */


    static binary.tree.Node sortedArrayToBST(int arr[], int start, int end) {

        /* Base Case */
        if (start > end) {
            return null;
        }

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        binary.tree.Node node = new binary.tree.Node(arr[mid]);

        /* Recursively construct the left subtree and make it
         left child of root */
        node.setLeftNode(sortedArrayToBST(arr, start, mid - 1));

        /* Recursively construct the right subtree and make it
         right child of root */
        node.setRightNode(sortedArrayToBST(arr, mid + 1, end));

        return node;
    }

    static void breathFirstTraversal(binary.tree.Node node) {
        Queue<binary.tree.Node> data = new LinkedList<>();
        data.add(node);
        while (!data.isEmpty()) {
            binary.tree.Node np = data.poll();
            System.out.print(np.getData() + " -> ");
            binary.tree.Node left = np.getLeftNode();
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
