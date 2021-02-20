package theory.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversalInSpiralForm {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.setLeftNode(new Node(2));
        root.setRightNode(new Node(3));
        root.getLeftNode().setLeftNode(new Node(4));
        root.getLeftNode().setRightNode(new Node(5));
        root.getRightNode().setLeftNode(new Node(6));
        root.getRightNode().setRightNode(new Node(7));

        //first solution
        TreeTraversalInSpiralForm_Solution1(root);
        System.out.println();
        TreeTraversalInSpiralForm_EfficientSolution(root);
    }


    // use two stack.
    //time complexity , every node is push and pop in the stack . every item is processed twice-> O(n)
    public static void TreeTraversalInSpiralForm_EfficientSolution(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> tmpStack1 = new Stack<>();
        Stack<Node> tmpStack2 = new Stack<>();
        tmpStack1.push(root);
        while(!tmpStack1.isEmpty() || !tmpStack2.isEmpty()){
            while(!tmpStack1.isEmpty()){
                Node tmpNode = tmpStack1.pop();
                System.out.print(tmpNode.getData() + "\t");
                if(tmpNode.getLeftNode()!=null){
                    tmpStack2.push(tmpNode.getLeftNode());
                }
                if(tmpNode.getRightNode()!=null){
                    tmpStack2.push(tmpNode.getRightNode());
                }
            }
            while(!tmpStack2.isEmpty()){
                Node tmpNode = tmpStack2.pop();
                System.out.print(tmpNode.getData() + "\t");
                if(tmpNode.getRightNode()!=null){
                    tmpStack1.push(tmpNode.getRightNode());
                }
                if(tmpNode.getLeftNode()!=null){
                    tmpStack1.push(tmpNode.getLeftNode());
                }
            }
        }
    }


    //time complexity , every node is enqueued, dequeued, pushed to stack and poped -> O(n)
    //reverse printed nodes are first pushed to queue , then to stack
    public static void TreeTraversalInSpiralForm_Solution1(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> data = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        boolean reverse = false;
        data.add(root);
        while (!data.isEmpty()) {
            int size = data.size();
            for (int i = 0; i < size; i++) {
                Node node = data.poll();
                if (reverse) {
                    stack.push(node.getData());
                } else {
                    System.out.print(node.getData() + "\t");
                }
                if (node.getLeftNode() != null) {
                    data.add(node.getLeftNode());
                }
                if (node.getRightNode() != null) {
                    data.add(node.getRightNode());
                }
            }
            if(reverse){
                while(!stack.isEmpty()){
                    System.out.print(stack.pop() + "\t");
                }
            }
            reverse = !reverse;
        }
    }



}
