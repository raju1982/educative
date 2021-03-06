package theory.binarysearchtree;

import theory.binarytree.Node;

public class FloorAndCeilInBinarySearchTree {

    public static void main(String[] args) {
        Node node = InsertNode.iterativeInsert(null, 10);
        InsertNode.iterativeInsert(node, 5);
        InsertNode.iterativeInsert(node, 15);
        InsertNode.iterativeInsert(node, 12);
        InsertNode.iterativeInsert(node, 18);

        System.out.println(floorInBinarySearchTree(node, 13).getData());
        System.out.println(CeilInBinarySearchTree(node, 13).getData());

    }

    public static boolean iterativeSearch(Node node, int val){
        while(node!=null){
            if(node.getData() == val){
                return true;
            }
            else if(node.getData()>val){
                node = node.getLeftNode();
            }
            else{
                node = node.getRightNode();
            }
        }
        return false;
    }

    //solution is based on iterative search
    //time complexity -> O(h), where h is the height of binary search tree.
    //Iterative implementation is 0(1) it does not require auxiliary space.
    public static Node floorInBinarySearchTree(Node root, int val){
        if(root == null){
            return null;
        }
        Node solution = null;
        while(root!=null){
            if(root.getData() == val){
                return root;
            }
            else if(root.getData() > val){
                root = root.getLeftNode();
            }
            else{
                solution = root;
                root = root.getRightNode();
            }
        }
        return solution;
    }

    //solution is based on iterative search
    public static Node CeilInBinarySearchTree(Node root, int val){
        if(root == null){
            return null;
        }
        Node solution = null;
        while(root!=null){
            if(root.getData() == val){
                return root;
            }
            else if(root.getData() < val){
                root = root.getRightNode();
            }
            else{
                solution = root;
                root = root.getLeftNode();
            }
        }
        return solution;
    }
}
