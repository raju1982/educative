package theory.binarytree;

import java.util.Queue;
import java.util.LinkedList;

public class PrintLeftViewOfBinaryTree {

    private static int maxLevel=0;

    public static void main(String[] args){
        Node root=new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(30));
        root.getLeftNode().setLeftNode(new Node(40));
        root.getLeftNode().setRightNode(new Node(50));
        root.getRightNode().setLeftNode(new Node(60));
        root.getRightNode().setRightNode(new Node(70));
        //first solution
        levelOrderSolution(root);
        System.out.println();
        //second solution
        printLeft(root, 1);
    }

    //time complexity O(n) -> for every node we do O(1) work (enque and deque operation)
    //Auxiliary space is equal to width of binary tree O(n)
    public static void levelOrderSolution(Node root){
        if(root == null){
            return;
        }
        Queue<Node> data = new LinkedList<>();
        data.add(root);
        int size;
        Node node;
        while(!data.isEmpty()){
            size = data.size();
            for(int i=0; i<size; i++){
               node = data.poll();
               if(i==0){
                   System.out.print(node.getData() + "\t");
               }
               if(node.getLeftNode()!=null){
                   data.add(node.getLeftNode());
               }
               if(node.getRightNode()!=null){
                   data.add(node.getRightNode());
               }
            }
        }
    }

    //time complexity O(n)
    //Auxiliary Space = height + 1 = O(h)
    //(Root Left Right)
    //if you do the pre-order traversal of the binary tree, you will always visit the left node first.
    public static void printLeft(Node root,int level){
        if(root==null)
            return;
        if(maxLevel<level){
            System.out.print(root.getData()+"\t");
            maxLevel=level;
        }
        printLeft(root.getLeftNode(),level+1);
        printLeft(root.getRightNode(),level+1);
    }
}
