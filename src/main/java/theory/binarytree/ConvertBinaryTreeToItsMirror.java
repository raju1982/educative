package theory.binarytree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class ConvertBinaryTreeToItsMirror {

    public static void main(String[] args){
        Node root=new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(30));
        root.getLeftNode().setLeftNode(new Node(40));
        root.getLeftNode().setRightNode(new Node(50));
        root.getRightNode().setLeftNode(new Node(60));
        root.getRightNode().setRightNode(new Node(70));

        DepthRecursiveTraversal.inOrderTraversal(root);
        convertBinaryTreeToItsMirror(root);
        System.out.println();
        DepthRecursiveTraversal.inOrderTraversal(root);
    }

    private static void convertBinaryTreeToItsMirror(Node node){
        if(Objects.isNull(node)){
            return;
        }
        Queue<Node> data = new LinkedList<>();
        data.add(node);

        while(!data.isEmpty()){
            Node tmpNode = data.poll();
            Node tmp = tmpNode.getLeftNode();
            tmpNode.setLeftNode(tmpNode.getRightNode());
            tmpNode.setRightNode(tmp);
            if(tmpNode.getLeftNode()!=null) {
                data.add(tmpNode.getLeftNode());
            }
            if(tmpNode.getRightNode()!=null) {
                data.add(tmpNode.getRightNode());
            }
        }
    }
}

