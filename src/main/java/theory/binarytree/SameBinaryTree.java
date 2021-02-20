package theory.binarytree;

public class SameBinaryTree {

    public static void main(String[] args) {

        Node root = new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(30));
        root.getLeftNode().setLeftNode(new Node(40));
        root.getLeftNode().setRightNode(new Node(50));
        root.getRightNode().setLeftNode(new Node(60));
        root.getRightNode().setRightNode(new Node(70));

        Node root1 = new Node(10);
        root1.setLeftNode(new Node(20));
        root1.setRightNode(new Node(30));
        root1.getLeftNode().setLeftNode(new Node(40));
        root1.getLeftNode().setRightNode(new Node(50));
        root1.getRightNode().setLeftNode(new Node(60));
        root1.getRightNode().setRightNode(new Node(70));

        System.out.println(compareTwoTree(root, root1));
    }

    public static boolean compareTwoTree(Node root, Node root1) {
        if (root == null && root1 == null) {
            return true;
        }
        if (root == null || root1 == null) {
            return false;
        }
        return (root.getData() == root1.getData()) &&
                compareTwoTree(root.getLeftNode(), root1.getLeftNode()) &&
                compareTwoTree(root.getRightNode(), root1.getRightNode());
    }

}