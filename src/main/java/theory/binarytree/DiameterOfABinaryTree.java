package theory.binarytree;

public class DiameterOfABinaryTree {

    static class Node{
        int val;
        Node rightNode;
        Node leftNode;

        Node(int val){
            this.val = val;
        }
    }

    static class Pair{
        int diameter;
        int height;

        Pair(int diameter, int height){
            this.diameter = diameter;
            this.height = height;
        }
    }

    //fast solution
    public static Pair findDiameter_fast(Node root){
        if(root == null){
            return new Pair(0, -1);
        }

        Pair leftChildPair = findDiameter_fast(root.leftNode);
        Pair rightChildPair = findDiameter_fast(root.rightNode);

        int diameter = Math.max(Math.max(leftChildPair.diameter, rightChildPair.diameter), 2 + leftChildPair.height + rightChildPair.height);
        int height = 1 + Math.max( leftChildPair.height, rightChildPair.height);

        return new Pair(diameter, height);
    }

    public static void main(String[] args){
        Node root=new Node(10);
        root.leftNode = new Node(20);
        root.rightNode = new Node(30);
        root.rightNode.leftNode = new Node(40);
        root.rightNode.rightNode = new Node(60);
        root.rightNode.leftNode.leftNode = new Node(50);
        root.rightNode.rightNode.rightNode = new Node(70);

        System.out.println("height: " + findDiameter_fast(root).diameter);
    }

}







/*

System.out.println("height: " + findDiameter_slow(root));

//Slow Solution
    public static int findDiameter_slow(Node root){
        if(root == null){
            return 0;
        }

        int leftChildDiameter = findDiameter_slow(root.leftNode);
        int rightChildDiameter = findDiameter_slow(root.rightNode);

        return Math.max(Math.max(leftChildDiameter, rightChildDiameter), 2 + height(root.leftNode) + height(root.rightNode));
    }

    public static int height(Node root){
        if(root == null){
            return -1;
        }
        return 1 + Math.max(height(root.leftNode), height(root.rightNode));
    }
 */