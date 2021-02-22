package theory.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfBinaryTree {

    public static void main(String[] args){
        Node root=new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(30));
        root.getRightNode().setLeftNode(new Node(40));
        root.getRightNode().setRightNode(new Node(50));

        System.out.println(findHeight(root));
        System.out.println(findHeight2(root));
    }

    //time complexity O(n)
    //Auxiliary Space = height + 1 = O(h)
    public static int findHeight(Node root){
        if(root == null){
            return 0;
        }
        return Math.max(findHeight(root.getLeftNode()), findHeight(root.getRightNode())) + 1;
    }

    public static int findHeight2(Node node){
        if(node == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int height = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                Node tmpNode = queue.poll();
                if(tmpNode.getLeftNode()!=null){
                    queue.add(tmpNode.getLeftNode());
                }
                if(tmpNode.getRightNode()!=null){
                    queue.add(tmpNode.getRightNode());
                }
            }
            height++;
        }
        return height;
    }
}