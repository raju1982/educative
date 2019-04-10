package binary.tree;

public class isBinarySearchTree {

    public static boolean isBinaryTree(Node node, int min, int max){
        if(node == null){
            return true;
        }

        if(node.getData() <= min || node.getData() > max){
            return false;
        }

        return isBinaryTree(node.getLeftNode(), min, node.getData()) && isBinaryTree(node.getRightNode(), node.getData(), max);

    }
}
