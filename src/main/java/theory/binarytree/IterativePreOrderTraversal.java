package theory.binarytree;

import java.util.Stack;

public class IterativePreOrderTraversal {
    public static void main(String[] args){
        Node root=new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(30));
        root.getLeftNode().setLeftNode(new Node(40));
        root.getLeftNode().setRightNode(new Node(50));
        root.getRightNode().setLeftNode(new Node(60));
        root.getRightNode().setRightNode(new Node(70));

        iterativePreOrder(root);
        System.out.println();
        spaceOptimizedSolution(root);
    }


    //time complexity O(n)
    //Auxiliary Space = O(n)
    //(Root Left Right)
    public static void iterativePreOrder(Node root){
        if(root==null){
            return;
        }
        Stack<Node> data = new Stack<>();
        data.push(root);

        while(!data.isEmpty()){
            Node tmpNode = data.pop();
            System.out.print(tmpNode.getData()+ "\t");
            if(tmpNode.getRightNode()!=null){
                data.push(tmpNode.getRightNode());
            }
            if(tmpNode.getLeftNode()!=null){
                data.push(tmpNode.getLeftNode());
            }
        }
    }

    //A O(h) extra space [only right child] and O(n) time solution is discussed.
    public static void spaceOptimizedSolution(Node node){
        if(node == null){
            return;
        }

        Stack<Node> data = new Stack<>();
        data.add(node);
        Node current =  node;
        while(current!=null || !data.isEmpty()){
            while(current!=null){
                System.out.print(current.getData() + "\t");
                if(current.getRightNode()!=null){
                    data.push(current.getRightNode());
                }
                current = current.getLeftNode();
            }
            if(!data.isEmpty()) {
                current = data.pop();
            }
        }
    }

}
