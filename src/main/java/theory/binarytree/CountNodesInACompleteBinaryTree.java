package theory.binarytree;

public class CountNodesInACompleteBinaryTree {
    public static void main(String[] args){
        Node root1=new Node(10);
        root1.setLeftNode(new Node(20));
        root1.setRightNode(new Node(30));
        root1.getLeftNode().setLeftNode(new Node(40));
        root1.getLeftNode().setRightNode(new Node(50));
        root1.getRightNode().setLeftNode(new Node(60));
        root1.getRightNode().setRightNode(new Node(70));

    }
}
