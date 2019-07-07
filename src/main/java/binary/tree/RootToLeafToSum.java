package binary.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Date 04/11/2015
 * @author tusroy
 *
 * Youtube link - https://youtu.be/Jg4E4KZstFE
 *
 * Given a binary tree and a sum, find if there is a path from root to leaf
 * which sums to this sum.
 *
 * Solution
 * Keep going left and right and keep subtracting node value from sum.
 * If leaf node is reached check if whatever sum is remaining same as leaf node data.
 *
 * Time complexity is O(n) since all nodes are visited.
 *
 * Test cases:
 * Negative number, 0 and positive number
 * Tree with 0, 1 or more nodes
 *
 * Reference http://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
 */
public class RootToLeafToSum {

    public static boolean printPath(Node root, int sum, List<Node> path){
        if(root == null){
            return false;
        }

        if(root.getLeftNode() == null && root.getRightNode() == null){
            if(root.data == sum){
                path.add(root);
                return true;
            }else{
                return false;
            }
        }
        if(printPath(root.getLeftNode(), sum-root.data, path) || printPath(root.getRightNode(), sum - root.data, path)){
            path.add(root);
            return true;
        }
        return false;
    }

    public static void main(String args[]){


        binary.tree.Node one = new binary.tree.Node(10);
        binary.tree.Node two = new binary.tree.Node(15);
        binary.tree.Node three = new binary.tree.Node(5);
        binary.tree.Node four = new binary.tree.Node(7);
        binary.tree.Node five = new binary.tree.Node(19);
        binary.tree.Node six = new binary.tree.Node(20);
        binary.tree.Node seven = new binary.tree.Node(4);
        binary.tree.Node eight = new binary.tree.Node(3);

        binary.tree.Node head = insert(null, five);

        insert(head, one);
        insert(head, seven);
        insert(head, three);
        insert(head, eight);
        insert(head, two);
        insert(head, six);
        insert(head, four);

        List<Node> result = new ArrayList<>();
        boolean r = printPath(head, 36, result);
        if(r){
            result.forEach(node -> System.out.print(node.data + " "));
        }else{
            System.out.println("No path for sum " + 44);
        }

    }

    public static binary.tree.Node insert(binary.tree.Node head, binary.tree.Node node) {
        if (head == null) {
            return node;
        }

        if (node.getData() <= head.getData()) {
            head.setLeftNode(insert(head.getLeftNode(), node));
        } else {
            head.setRightNode(insert(head.getRightNode(), node));
        }
        return head;
    }
}
