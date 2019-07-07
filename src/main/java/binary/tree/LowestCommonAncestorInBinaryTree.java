package binary.tree;

public class LowestCommonAncestorInBinaryTree {
    public Node lca(Node root, Node n1, Node n2){
        if(root == null){
            return null;
        }
        if(root == n1 || root == n2){
            return root;
        }

        Node left = lca(root.getLeftNode(), n1, n2);
        Node right = lca(root.getRightNode(), n1, n2);

        if(left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }
}
