package binary.tree;

public class MirrorABinaryTree {
    public static void mirror(Node node){
        if(node == null){
            return;
        }
        mirror(node.getLeftNode());
        mirror(node.getRightNode());
        Node tmp=node.getLeftNode();
        node.setLeftNode(node.getRightNode());
        node.setRightNode(tmp);
    }
}
