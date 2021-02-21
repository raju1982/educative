package theory.binarytree;

public class CheckForSymmetricTreeMirrorImageOfItself {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(20));
        root.getLeftNode().setLeftNode(new Node(40));
        root.getLeftNode().setRightNode(new Node(50));
        root.getRightNode().setLeftNode(new Node(50));
        root.getRightNode().setRightNode(new Node(40));

        System.out.println(CheckIfTwoTreesAreMirror.validate(root, root));
    }
}
