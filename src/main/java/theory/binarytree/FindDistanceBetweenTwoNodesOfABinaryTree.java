package theory.binarytree;

public class FindDistanceBetweenTwoNodesOfABinaryTree {

    public static void main(String[] str){
        Node root=new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(30));
        root.getRightNode().setLeftNode(new Node(40));
        root.getRightNode().setRightNode(new Node(60));
        root.getRightNode().getLeftNode().setLeftNode(new Node(50));
        root.getRightNode().getRightNode().setRightNode(new Node(70));

        System.out.println(FindDistanceBetweenTwoNodesOfABinaryTree(root, 50, 70));
    }

    public static int FindDistanceBetweenTwoNodesOfABinaryTree(Node root, int firstNumber, int SecondNumber){
        Node lca = LowestCommonAncestor.lowestCommonAncestor(root, firstNumber, SecondNumber);
        int firstNumberDistanceFromLCA = GetLevelOfANodeInABinaryTree.solution(lca, firstNumber, 0);
        int secondNumberDistanceFromLCA = GetLevelOfANodeInABinaryTree.solution(lca, SecondNumber, 0);
        return firstNumberDistanceFromLCA + secondNumberDistanceFromLCA;
    }
}
