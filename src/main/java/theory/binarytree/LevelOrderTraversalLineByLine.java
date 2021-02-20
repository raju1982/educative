package theory.binarytree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class LevelOrderTraversalLineByLine {

    public static void main(String[] args){
        Node root=new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(30));
        root.getLeftNode().setLeftNode(new Node(40));
        root.getLeftNode().setRightNode(new Node(50));
        root.getRightNode().setLeftNode(new Node(60));
        root.getRightNode().setRightNode(new Node(70));
        //first solution
        levelOrderTraversalLineByLine_Solution1(root);

        System.out.println("\nsecond solution");
        //second solution
        levelOrderTraversalLineByLine_Solution2(root);
    }


    //time complexity O(n) -> for every node we do O(1) work (enque and deque operation)
    //Auxiliary space is equal to width of binary tree O(n)
    private static void levelOrderTraversalLineByLine_Solution1(Node root){
        if(Objects.isNull(root)){
            return;
        }
        Queue<Node> data = new LinkedList<>();
        data.add(root);
        data.add(null);
        while(data.size()>1){
            Node node = data.poll();
            if(node==null){
                System.out.println();
                data.add(null);
                continue;
            }
            System.out.print(node.getData() + "\t");
            if(node.getLeftNode()!=null) {
                data.add(node.getLeftNode());
            }
            if(node.getRightNode()!=null) {
                data.add(node.getRightNode());
            }
        }
    }


    //time complexity O(n) -> for every node we do O(1) work (enque and deque operation)
    //Auxiliary space is equal to width of binary tree O(n)
    private static void levelOrderTraversalLineByLine_Solution2(Node root){
        if(Objects.isNull(root)){
            return;
        }
        Queue<Node> data = new LinkedList<>();
        data.add(root);

        while(!data.isEmpty()){
            int size = data.size();
            // print one level at a time
            for(int i=0; i<size; i++){
                Node node = data.poll();
                System.out.print(node.getData() + "\t");
                if(node.getLeftNode()!=null){
                    data.add(node.getLeftNode());
                }
                if(node.getRightNode()!=null){
                    data.add(node.getRightNode());
                }
            }
            System.out.println();
        }
    }

}
