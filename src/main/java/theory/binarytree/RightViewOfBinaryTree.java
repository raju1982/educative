package theory.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class RightViewOfBinaryTree {

    static class Node{
        int val;
        Node rightNode;
        Node leftNode;

        Node(int val){
            this.val = val;
        }
    }

    public static void rightView(Node root){

        Queue<Node> stack = new LinkedList<>();
        stack.add(root);

        while(!stack.isEmpty()){
            int size = stack.size();
            for(int i=0; i<size; i++){
                Node tmp = stack.poll();
                if(i==size-1){
                    System.out.print(tmp.val + " , ");
                }
                if(tmp.leftNode!=null){
                    stack.add(tmp.leftNode);
                }
                if(tmp.rightNode!=null){
                    stack.add(tmp.rightNode);
                }
            }
        }

    }


    public static void main(String[] args){
        Node root = new Node(10);
        root.rightNode = new Node(8);
        root.leftNode = new Node(7);
        root.rightNode.rightNode = new Node(6);
        root.rightNode.leftNode = new Node(5);
        root.leftNode.rightNode = new Node(4);
        root.leftNode.leftNode = new Node(3);
        rightView(root);
    }

}
