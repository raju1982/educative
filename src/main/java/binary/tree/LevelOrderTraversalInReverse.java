package binary.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Date 04/20/2015
 * @author tusroy
 *
 * Video link - https://youtu.be/D2bIbWGgvzI
 *
 * Given a binary tree print its level order traversal in reverse
 * e.g           1
 *          2         3
 *        4    5    6   7
 *
 * Output should be 4 5 6 7 2 3 1
 *
 * Solution
 * Maintain a stack and queue. Do regular level order traversal but
 * put right first in the queue. Instead of printing put the result
 * in stack. Finally print contents of the stack.
 *
 * Time and space complexity is O(n)
 *
 * References : http://www.geeksforgeeks.org/reverse-level-order-traversal/
 */
public class LevelOrderTraversalInReverse {

    public void reverseLevelOrderTraversal(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        Stack<Node> s = new Stack<>();

        q.offer(root);
        while(!q.isEmpty()){
            root = q.poll();
            if(root.getRightNode() != null){
                q.offer(root.getRightNode());
            }
            if(root.getLeftNode() != null){
                q.offer(root.getLeftNode());
            }
            s.push(root);
        }
        while(!s.isEmpty()){
            System.out.print(s.pop().data + " ");
        }
    }

    //insert binary search tree
    public static Node insert(Node root, Node node){
        if(root == null){
            return node;
        }
        if(node.getData() <= root.getData()){
            root.setLeftNode(insert(root.getLeftNode(),node));
        }
        else{
            root.setRightNode(insert(root.getRightNode(),node));
        }
        return root;
    }

    public static void main(String args[]){
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);

        Node head = insert(null, five);
        insert(head, three);
        insert(head, eight);
        insert(head, one);
        insert(head, four);
        insert(head, six);
        insert(head, nine);
        insert(head, seven);
        insert(head, two);

        LevelOrderTraversalInReverse rlo = new LevelOrderTraversalInReverse();
        rlo.reverseLevelOrderTraversal(head);
    }
}
