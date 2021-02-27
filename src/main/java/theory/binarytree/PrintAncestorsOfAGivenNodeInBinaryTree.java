package theory.binarytree;

public class PrintAncestorsOfAGivenNodeInBinaryTree {

    public static void main(String[] str) {
        Node root = new Node(1);
        root.setLeftNode(new Node(2));
        root.setRightNode(new Node(3));
        root.getLeftNode().setLeftNode(new Node(4));
        root.getLeftNode().setRightNode(new Node(5));
        root.getLeftNode().getLeftNode().setLeftNode(new Node(7));

        printAncestors(root, 7);
    }

    /*
    if the node is present in tree return true and print Ancestors.
    otherwise, it return false;
     */
    public static boolean printAncestors(Node root, int nodeData){
        if(root == null){
            return false;
        }

        if(root.getData() == nodeData){
            return true;
        }

        if(printAncestors(root.getLeftNode(), nodeData) || printAncestors(root.getRightNode(), nodeData)){
            System.out.print(root.getData() + "\t");
            return true;
        }
        return false;
    }
}