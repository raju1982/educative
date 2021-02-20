package theory.binarytree;

import java.util.Queue;
import java.util.LinkedList;

//number of nodes in the binary tree
public class SizeOfBinaryTree {

    public static void main(String[] args){
        Node root=new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(30));
        root.getLeftNode().setLeftNode(new Node(40));
        root.getLeftNode().setRightNode(new Node(50));
        root.getRightNode().setLeftNode(new Node(60));
        root.getRightNode().setRightNode(new Node(70));

        System.out.println(sizeFirstSolution(root));
        System.out.println(sizeSecondSolution(root));
    }

    //time complexity O(n)
    //Auxiliary Space = max no. of function calls in function call stack is proportional to "height + 1" = O(h)
    private static int sizeFirstSolution(Node root){
        if(root == null){
            return 0;
        }
        return sizeFirstSolution(root.getLeftNode()) + sizeFirstSolution(root.getRightNode()) + 1;
    }


    //time complexity O(n)
    //Auxiliary space is equal to width of binary tree O(n)
    private static int sizeSecondSolution(Node root){
        if(root == null){
            return 0;
        }
        Queue<Node> data = new LinkedList<>();
        data.add(root);
        int count = 0;
        while(!data.isEmpty()){
            Node node = data.poll();
            count++;
            if(node.getLeftNode()!=null){
                data.add(node.getLeftNode());
            }
            if(node.getRightNode()!=null){
                data.add(node.getRightNode());
            }
        }
        return count;
    }


}
