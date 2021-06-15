package theory.binarytree;

import java.util.*;

public class PrintPathFromRootToAGivenNode {

    public static class Node{
        int val;
        Node rightNode;
        Node leftNode;

        Node(int val){
            this.val = val;
        }
    }


    public static boolean isPathExists(Node root, Integer childNodeValue, List<Integer> path){
        if(root==null){
            return false;
        }

        if(root.val == childNodeValue){
            return true;
        }

        path.add(root.val);

        if(isPathExists(root.leftNode, childNodeValue, path) || isPathExists(root.rightNode, childNodeValue, path)){
            return true;
        }

        path.remove(path.size()-1);

        return false;
    }


    public static void main(String[] args){
        Node root = new Node(10);
        root.rightNode = new Node(8);
        root.leftNode = new Node(7);
        root.rightNode.rightNode = new Node(6);
        root.rightNode.leftNode = new Node(5);
        root.leftNode.rightNode = new Node(4);
        root.leftNode.leftNode = new Node(3);

        List<Integer> path = new ArrayList<>();
        System.out.println(isPathExists(root, 3, path));
        System.out.println(path);
    }



}
