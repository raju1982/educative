package theory.binarytree;

public class HeightOfBinaryTree {

    public static void main(String[] args){
        Node root=new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(30));
        root.getRightNode().setLeftNode(new Node(40));
        root.getRightNode().setRightNode(new Node(50));

        System.out.println(findHeight(root));
    }

    //time complexity O(n)
    //Auxiliary Space = height + 1 = O(h)
    public static int findHeight(Node root){
        if(root == null){
            return 0;
        }
        return Math.max(findHeight(root.getLeftNode()), findHeight(root.getRightNode())) + 1;
    }
}