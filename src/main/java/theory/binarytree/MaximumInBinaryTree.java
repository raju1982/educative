package theory.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumInBinaryTree {
    public static void main(String[] args){
        Node root=new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(30));
        root.getLeftNode().setLeftNode(new Node(40));
        root.getLeftNode().setRightNode(new Node(70));
        root.getRightNode().setLeftNode(new Node(60));
        root.getRightNode().setRightNode(new Node(50));
        //first solution
        System.out.println(levelOrderSolution(root));
        //second solution
        System.out.println(depthRecursiveSolution(root));
    }

    //time complexity O(n) -> for every node we do constant work (enque and deque) and we are visiting each node once -> )(n)
    //Auxiliary space -> O(W) -> width of binary tree
    private static int levelOrderSolution(Node root){
        int max = Integer.MIN_VALUE;
        if(root == null){
            return max;
        }

        Queue<Node> data = new LinkedList<>();
        data.add(root);

        while(!data.isEmpty()){
            Node node = data.poll();
            if(node.getData()> max){
                max = node.getData();
            }
            if(node.getLeftNode()!=null) {
                data.add(node.getLeftNode());
            }
            if(node.getRightNode()!=null) {
                data.add(node.getRightNode());
            }
        }
        return max;
    }

    //time complexity O(n) -> for every node we do constant work and we are visiting each node once -> )(n)
    //Auxiliary space -> O(h) -> max. no. of functional call in function call stack will be "height + 1"
    private static int depthRecursiveSolution(Node root){
        int max = Integer.MIN_VALUE;
        if(root == null){
            return max;
        }
        return Math.max(root.getData(),Math.max(depthRecursiveSolution(root.getLeftNode()),depthRecursiveSolution(root.getRightNode())));
    }
}
