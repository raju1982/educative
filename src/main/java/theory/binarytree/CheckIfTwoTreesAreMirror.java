package theory.binarytree;

public class CheckIfTwoTreesAreMirror {

    public static void main(String[] args){
        Node root=new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(30));
        root.getLeftNode().setLeftNode(new Node(40));
        root.getLeftNode().setRightNode(new Node(50));
        root.getRightNode().setLeftNode(new Node(60));
        root.getRightNode().setRightNode(new Node(70));

        DepthRecursiveTraversal.inOrderTraversal(root);

        Node root1=new Node(10);
        root1.setLeftNode(new Node(30));
        root1.setRightNode(new Node(20));
        root1.getLeftNode().setLeftNode(new Node(70));
        root1.getLeftNode().setRightNode(new Node(60));
        root1.getRightNode().setLeftNode(new Node(50));
        root1.getRightNode().setRightNode(new Node(40));

        System.out.print("\n");
        DepthRecursiveTraversal.inOrderTraversal(root1);
        System.out.print("\n");
        System.out.println(validate(root, root1));
    }

    public static boolean validate(Node root, Node root1){
        if(root==null && root1==null){
            return true;
        }

        if(root==null || root1==null){
            return false;
        }

        /* Both non-empty, compare them recursively
           Note that in recursive calls, we pass left
           of one tree and right of other tree */
        return root.getData() == root1.getData()
                && validate(root.getLeftNode(), root1.getRightNode())
                && validate(root.getRightNode(), root1.getLeftNode());
    }



}
