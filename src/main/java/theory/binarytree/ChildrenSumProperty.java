package theory.binarytree;

/*
Children Sum Property is a property in which the sum of values of the left child and right child should be equal
to the value of their node if both children are present.
Else if only one child is present then the value of the child should be equal to its node value.
 */
public class ChildrenSumProperty {

    public static void main(String[] args) {
        Node root = new Node(20);
        root.setLeftNode(new Node(8));
        root.setRightNode(new Node(12));
        root.getRightNode().setLeftNode(new Node(3));
        root.getRightNode().setRightNode(new Node(9));
        //first solution
        System.out.println(solution(root));
    }

    //time complexity O(n)
    //Auxiliary Space = height + 1 = O(h)
    public static boolean solution(Node root) {
        if (root == null) {
            return true;
        }
        if (root.getLeftNode() == null && root.getRightNode() == null) {
            return true;
        }
        int LeftNodeValue = root.getLeftNode() == null ? 0 : root.getLeftNode().getData();
        int RightNodeValue = root.getRightNode() == null ? 0 : root.getRightNode().getData();
        if (root.getData() != LeftNodeValue + RightNodeValue) {
            return false;
        }
        return solution(root.getLeftNode()) && solution(root.getRightNode());
    }

}
