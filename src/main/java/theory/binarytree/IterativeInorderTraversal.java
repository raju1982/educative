package theory.binarytree;

import java.util.Stack;

public class IterativeInorderTraversal {
    public static void main(String[] args){
        Node root=new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(30));
        root.getLeftNode().setLeftNode(new Node(40));
        root.getLeftNode().setRightNode(new Node(50));
        root.getRightNode().setLeftNode(new Node(60));
        root.getRightNode().setRightNode(new Node(70));
        recursiveInorder(root);
        System.out.println();
        iterativeInOrder(root);
        System.out.println();
        iterativeInOrder_1(root);
    }

    public static void recursiveInorder(Node root) {
        if (root != null) {
            recursiveInorder(root.getLeftNode());
            System.out.print(root.getData() + "\t");
            recursiveInorder(root.getRightNode());
        }
    }

    //time complexity O(n)
    //Auxiliary Space = height + 1 = O(h)
    // [at most we will have left->left->left of node, which will be height of tree]
    public static void iterativeInOrder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> data = new Stack<>();
        Node currentNode = root;
        while(true){
            if(currentNode != null){
                data.push(currentNode);
                currentNode = currentNode.getLeftNode();
            }
            else{
                if(data.isEmpty()){
                    break;
                }
                currentNode = data.pop();
                System.out.print(currentNode.getData() + "\t");
                currentNode = currentNode.getRightNode();
            }
        }
    }


    //another solution
    public static void iterativeInOrder_1(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> data = new Stack<>();
        Node currentNode = root;
        while(!data.isEmpty() || currentNode!=null){
            while(currentNode!=null){
                data.push(currentNode);
                currentNode = currentNode.getLeftNode();
            }
            currentNode = data.pop();
            System.out.print(currentNode.getData() + "\t");
            currentNode = currentNode.getRightNode();
        }

    }
}

