package theory.binarytree;

import java.util.Stack;

public class IterativePostorderTraversal {
    public static void main(String[] args){
        Node root=new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(30));
        root.getLeftNode().setLeftNode(new Node(40));
        root.getLeftNode().setRightNode(new Node(50));
        root.getRightNode().setLeftNode(new Node(60));
        root.getRightNode().setRightNode(new Node(70));
        recursivePostorder(root);
        System.out.println();
        iterativePostOrder(root);
    }

    public static void recursivePostorder(Node node){
        if(node!=null){
            recursivePostorder(node.getLeftNode());
            recursivePostorder(node.getRightNode());
            System.out.print(node.getData() + "\t");
        }
    }

    public static void iterativePostOrder(Node node){
        if(node==null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node current = node;
        while(!stack.isEmpty() || current!=null){
            if(current!=null){
                stack.push(current);
                current = current.getLeftNode();
            }
            else{
                Node temp = stack.peek().getRightNode();
                if(temp==null){
                    temp = stack.pop();
                    System.out.print(temp.getData() + "\t");
                    while (!stack.isEmpty() && temp == stack.peek().getRightNode()) {
                        temp = stack.pop();
                        System.out.print(temp.getData() + "\t");
                    }
                }
                else{
                    current = temp;
                }
            }
        }
    }

}
