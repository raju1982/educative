package theory.binarytree;

public class DiameterOfABinaryTree {

    public static void main(String[] args){
        Node root=new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(30));
        root.getRightNode().setLeftNode(new Node(40));
        root.getRightNode().setRightNode(new Node(60));
        root.getRightNode().getLeftNode().setLeftNode(new Node(50));
        root.getRightNode().getRightNode().setRightNode(new Node(70));

        System.out.println("height: " + solution(root));
        System.out.println("diameter: " + diameter);
    }

    private static int diameter=0 ;
    //time complexity O(n)
    //Auxiliary Space = height + 1 = O(h)
    public static int solution(Node root){
        if(root ==  null){
            return 0;
        }
        int leftHeight = solution(root.getLeftNode());
        int rightHeight = solution(root.getRightNode());
        diameter = Math.max(diameter, leftHeight + rightHeight + 1);
        return Math.max(leftHeight, rightHeight) + 1;
    }

}