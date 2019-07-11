package binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BSTCommonFunctions {

    public static class Node {
        int data;
        Node leftNode;
        Node rightNode;

        public Node(int data){this.data = data;}

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
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

    //search binary search tree
    public static Node search(Node root, int input){
        if(root == null){
            return null;
        }

        if(input==root.getData()){
            return root;
        }

        if(input<root.getData()){
            return search(root.getLeftNode(), input);
        }
        else{
            return search(root.getRightNode(), input);
        }
    }

    //breath first search (level order traversal)
    public static void breathFirstSearch(Node root){
        if(root == null){
            return;
        }
        Queue<Node> data = new LinkedList<>();
        data.add(root);
        while(!data.isEmpty()){
            Node tmp = data.poll();
            System.out.print(tmp.getData() + "->");
            if(tmp.getLeftNode()!=null){
                data.add(tmp.getLeftNode());
            }
            if(tmp.getRightNode()!=null) {
                data.add(tmp.getRightNode());
            }
        }
    }

    //depth first pre-order
    public static void preOrderTravers(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.getData() + "->");
        preOrderTravers(root.getLeftNode());
        preOrderTravers(root.getRightNode());
    }


    //depth first in-order

    //depth first post-order

    //minimum value in BST
    public static int minValue(Node root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        if(root.getLeftNode() == null){
            return root.getData();
        }
        return minValue(root.getLeftNode());
    }

    public static int minValueItr(Node root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        while(root.getLeftNode()!=null){
            root=root.getLeftNode();
        }
        return root.data;
    }


/*https://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/ */
    //maximum depth of binary tree
    public static int maxDepth(Node root){
        if(root == null){
            return 0;
        }

        if(root.getLeftNode() == null && root.getRightNode()==null){
            return 0;
        }

        int leftNodeDepth = 1 + maxDepth(root.getLeftNode());
        int rightNodeDepth = 1 + maxDepth(root.getRightNode());

        return Math.max(leftNodeDepth, rightNodeDepth);
    }

    /*https://www.youtube.com/watch?v=vdwcCIkLUQI*/
    //mirror a binary tree
    public static void mirror(Node root) {
        if(root == null){
            return;
        }

        mirror(root.getLeftNode());
        mirror(root.getRightNode());

        Node tmp = root.getRightNode();
        root.setRightNode(root.getLeftNode());
        root.setLeftNode(tmp);
    }



    //count tree
    public static int countTree(int input){
        if(input <= 1){
            return 1;
        }

        int sum = 0;

        for(int i=0; i<=input; i++){
            int leftNode = countTree(i-1);
            int rightNode = countTree(input-i);
            sum = sum + (leftNode*rightNode);
        }
        return sum;
    }


    //PRINT NODES WITHIN A RANGE
    public static void printNodesWithInRange(Node root, int min, int max){
        if(root == null){
            return;
        }

        int tmp = root.getData();

        if(min<=tmp) {
            printNodesWithInRange(root.getLeftNode(), min, max);
        }

        if(min<=tmp && max>=tmp){
            System.out.print(tmp + " , ");
        }

        if(max>tmp) {
            printNodesWithInRange(root.getRightNode(), min, max);
        }
    }


    //isBinarySearchTree
    public static boolean isBinaryTree(Node root){
        if(root == null){
            return true;
        }
        if(root.getLeftNode() == null && root.getRightNode() == null){
            return true;
        }
        int tmp = root.getData();
        Node leftNode = root.getLeftNode();
        if(leftNode!= null && leftNode.getData() > tmp){
            return false;
        }

        Node rightNode = root.getRightNode();
        if(rightNode!=null && rightNode.getData() <= tmp){
            return false;
        }
        return isBinaryTree(leftNode) && isBinaryTree(rightNode);
    }

    /*
    public static boolean isBinaryTree(Node node, int min, int max){
        if(node == null){
            return true;
        }

        if(node.getData() <= min || node.getData() > max){
            return false;
        }

        return isBinaryTree(node.getLeftNode(), min, node.getData()) && isBinaryTree(node.getRightNode(), node.getData(), max);

    }
     */

    public static void main(String[] args) {
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

        breathFirstSearch(head);
        System.out.println();
        System.out.println(minValue(head));
        System.out.println(minValueItr(head));
        System.out.println();
        System.out.println(maxDepth(head));

        System.out.println("hi");

        printNodesWithInRange(head, 3, 7);
        System.out.println(isBinaryTree(head));
        mirror(head);
        System.out.println(isBinaryTree(head));
    }
}

