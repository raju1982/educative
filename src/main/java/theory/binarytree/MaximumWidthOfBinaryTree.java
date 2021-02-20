package theory.binarytree;

import java.util.Queue;
import java.util.LinkedList;

public class MaximumWidthOfBinaryTree {

    public static void main(String[] args){
        Node root=new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(30));
        root.getLeftNode().setLeftNode(new Node(40));
        root.getLeftNode().setRightNode(new Node(50));
        root.getRightNode().setLeftNode(new Node(60));
        System.out.println(maxWidth(root));
    }

    //time complexity O(n) -> for every node we do O(1) work (enque and deque operation)
    //Auxiliary space is equal to width of binary tree O(n)
    public static int maxWidth(Node root){
        if(root == null){
            return 0;
        }
        Queue<Node> data = new LinkedList<>();
        data.add(root);
        int maxWidth = 0;
        while(!data.isEmpty()){
            int size = data.size();
            if(size > maxWidth){
                maxWidth = size;
            }
            for(int i=0; i<size;i++){
                Node node = data.poll();
                if(node.getLeftNode()!=null){
                    data.add(node.getLeftNode());
                }
                if(node.getRightNode()!=null){
                    data.add(node.getRightNode());
                }
            }
        }
        return maxWidth;
    }
}
