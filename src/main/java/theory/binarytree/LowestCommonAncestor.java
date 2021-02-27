package theory.binarytree;

public class LowestCommonAncestor {
    public static void main(String[] args){
        Node root=new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(30));
        root.getRightNode().setLeftNode(new Node(40));
        root.getRightNode().setRightNode(new Node(50));

        int firstNumber=20,secondNumber=50;
        Node ans = lowestCommonAncestor(root,firstNumber,secondNumber);
        System.out.println("LCA: " + ans.getData());
    }

    /*The solution does only one traversal of binary tree, but assumes that both keys exist in the binary tree.*/
    //time complexity O(n)
    //Auxiliary Space = height + 1 = O(h)
    //just requires one traversal of tree
    public static Node lowestCommonAncestor(Node root, int firstNumber, int secondNumber){
        if(root == null){
            return null;
        }

        //if current node is equal to firstNumber or secondNumber, if yes return the root.
        if(root.getData()==firstNumber||root.getData()==secondNumber){
            return root;
        }

        Node leftSubtreeLCA = lowestCommonAncestor(root.getLeftNode(), firstNumber, secondNumber);
        Node rightSubtreeLCA = lowestCommonAncestor(root.getRightNode(), firstNumber, secondNumber);

        if(leftSubtreeLCA!=null && rightSubtreeLCA!=null){  //if leftSubtreeLCA is not null and rightSubtreeLCA is also not null that means current node is the LCA.
            return root;
        }

        //one subtree contains both numbers , other subtree does not contain any number.
        return leftSubtreeLCA != null ? leftSubtreeLCA : rightSubtreeLCA;
    }
}
