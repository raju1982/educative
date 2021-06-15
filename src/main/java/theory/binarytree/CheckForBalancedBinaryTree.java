package theory.binarytree;

import java.util.LinkedList;
import java.util.Queue;

//In a Balanced Binary Tree for every node, the difference between heights of left subtree and right subtree should not be more than one.
//A Binary tree is said to be height balanced if for each node in the tree, the difference in the height of its left and right subtree is at most one.
public class CheckForBalancedBinaryTree {

    static class Node{
        int val;
        Node rightNode;
        Node leftNode;

        Node(int val){
            this.val = val;
        }
    }

    static class Pair{
        int height;
        boolean isBalanced;

        Pair(int height, boolean isBalanced){
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public static Pair CheckForBalancedBinaryTree_fast(Node root){
        if(root == null){
            return new Pair(-1, true);
        }

        Pair leftPair = CheckForBalancedBinaryTree_fast(root.leftNode);
        Pair rightPair = CheckForBalancedBinaryTree_fast(root.rightNode);
        int height = Math.max(leftPair.height , rightPair.height) + 1;
        if(!leftPair.isBalanced || !rightPair.isBalanced){
            return new Pair(height, false);
        }

        int diff = Math.abs(leftPair.height - rightPair.height);

        if(diff>1){
            return new Pair(height, false);
        }
        else{
            return new Pair(height, true);
        }
    }


    public static boolean CheckForBalancedBinaryTree_Slow(Node root){
        if(root == null){
            return true;
        }

        if(!CheckForBalancedBinaryTree_Slow(root.leftNode) || !CheckForBalancedBinaryTree_Slow(root.rightNode)){
            return false;
        }

        return Math.abs(getHeight(root.leftNode) - getHeight(root.rightNode)) <=1 ;
    }

    public static int getHeight(Node root){
        if(root == null){
            return -1;
        }

        return Math.max(getHeight(root.leftNode) , getHeight(root.rightNode)) + 1;
    }

    public static void main(String[] args){
        Node root = new Node(10);
        root.rightNode = new Node(8);
        root.leftNode = new Node(7);
        root.rightNode.rightNode = new Node(6);
        root.rightNode.leftNode = new Node(5);
        root.leftNode.rightNode = new Node(4);
        root.leftNode.leftNode = new Node(3);

        System.out.println(CheckForBalancedBinaryTree_Slow(root));

        System.out.println(CheckForBalancedBinaryTree_fast(root).isBalanced);
    }


}
