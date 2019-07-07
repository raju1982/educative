package binary.tree;

/*
https://www.youtube.com/watch?v=TIoCCStdiFo
 */
public class LowestCommonAncestorBinarySearchTree {
    public Node lowestCommonAncestor(Node root, int p, int q) {
        if (root.data > Math.max(p, q)) {
            return lowestCommonAncestor(root.getLeftNode(), p, q);
        } else if (root.data < Math.min(p, q)) {
            return lowestCommonAncestor(root.getRightNode(), p, q);
        } else {
            return root;
        }
    }

    public static void main(){

    }
}
