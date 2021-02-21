package theory.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversalBinaryTree {

    public static void main(String[] args){
        Node root=new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(30));
        root.getLeftNode().setLeftNode(new Node(40));
        root.getLeftNode().setRightNode(new Node(50));
        root.getRightNode().setLeftNode(new Node(60));
        root.getRightNode().setRightNode(new Node(70));
        levelOrderTraversal(root);
        System.out.println();
        reverseLevelOrderTraversalBinaryTree(root);
    }

    public static void levelOrderTraversal(Node node){
        if(node == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node tmpNode = queue.poll();
            System.out.print(tmpNode.getData() + "\t");
            if(tmpNode.getLeftNode()!=null){
                queue.add(tmpNode.getLeftNode());
            }
            if(tmpNode.getRightNode()!=null){
                queue.add(tmpNode.getRightNode());
            }
        }
    }

    public static void reverseLevelOrderTraversalBinaryTree(Node node){
        if(node == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node tmpNode = queue.poll();
            stack.add(tmpNode);
            if(tmpNode.getRightNode()!=null){
                queue.add(tmpNode.getRightNode());
            }
            if(tmpNode.getLeftNode()!=null){
                queue.add(tmpNode.getLeftNode());
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop().getData() + "\t");
        }
    }
}
