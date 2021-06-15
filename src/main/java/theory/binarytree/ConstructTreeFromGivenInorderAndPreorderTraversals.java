package theory.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructTreeFromGivenInorderAndPreorderTraversals {

    static class Node{
        char val;
        Node rightNode;
        Node leftNode;

        Node(char val){
            this.val = val;
        }
    }

    public static void inOrder(Node root){
        if(root!=null){
            inOrder(root.leftNode);
            System.out.print(root.val + " , ");
            inOrder(root.rightNode);
        }
    }

    public static Node constructTree(char[] inOrder, char[] preOrder, int inOrderLowIndex, int inOrderHighIndex, int preOrderLowIndex, int preOrderHighIndex){
        if(inOrderLowIndex>inOrderHighIndex || preOrderLowIndex>preOrderHighIndex){
            return null;
        }

        if(preOrderLowIndex==-1){
            System.out.println();
        }

        Node root = new Node(preOrder[preOrderLowIndex]);

        int inOrderIndex = -1;
        for(int i=inOrderLowIndex; i<=inOrderHighIndex; i++){
            if(preOrder[preOrderLowIndex] == inOrder[i]){
                inOrderIndex = i;
                break;
            }
        }

        int leftElementSize = inOrderIndex-inOrderLowIndex;

        if(leftElementSize<0){
            System.out.println();
        }

        root.leftNode = constructTree(inOrder, preOrder, inOrderLowIndex, inOrderIndex-1, preOrderLowIndex+1, preOrderLowIndex+leftElementSize);
        root.rightNode = constructTree(inOrder, preOrder, inOrderIndex+1, inOrderHighIndex, preOrderLowIndex+leftElementSize+1, preOrderHighIndex);

        return root;
    }


    public static void main(String[] args){
        char[] pre = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
        char[] in = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
        Node newTree = constructTree(in, pre, 0, in.length-1, 0, pre.length-1);
        inOrder(newTree);
        System.out.println();
    }

}
