package theory.binarytree;

import java.util.Objects;

public class PrintNodesAtKDistance {

    public static void main(String[] args){
        Node root=new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(30));
        root.getLeftNode().setLeftNode(new Node(40));
        root.getLeftNode().setRightNode(new Node(50));
        root.getRightNode().setRightNode(new Node(70));
        root.getRightNode().getRightNode().setRightNode(new Node(80));
        findNodesAtKDistance(root, 2);
    }

    //time complexity O(n)
    //Auxiliary Space = height = O(h)
    public static void findNodesAtKDistance(Node root, int distance){
        if(Objects.isNull(root)){
            return;
        }

        if(distance == 0){
            System.out.print(root.getData() + " ");
        }
        else {
            findNodesAtKDistance(root.getLeftNode(), distance - 1);
            findNodesAtKDistance(root.getRightNode(), distance - 1);
        }
    }
}

