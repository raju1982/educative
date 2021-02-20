package theory.binarytree;

//In a Balanced Binary Tree for every node, the difference between heights of left subtree and right subtree should not be more than one.
//A Binary tree is said to be height balanced if for each node in the tree, the difference in the height of its left and right subtree is at most one.
public class CheckForBalancedBinaryTree {

    public static void main(String[] args){
        Node root=new Node(10);
        root.setLeftNode(new Node(5));
        root.setRightNode(new Node(30));
        root.getRightNode().setLeftNode(new Node(15));
        root.getRightNode().setRightNode(new Node(20));
        System.out.println(checkForBalancedBinaryTree(root));
    }

    public static boolean checkForBalancedBinaryTree(Node root){
        return getHeight(root)==-1?false:true;
    }

    //time complexity O(n)
    //Auxiliary Space = height + 1 = O(h)
    public static int getHeight(Node root){
        if(root==null){
            return 0;
        }
        int leftNodeHeight = getHeight(root.getLeftNode());
        if(leftNodeHeight == -1){
            return -1;
        }
        int rightNodeHeight = getHeight(root.getRightNode());
        if(rightNodeHeight == -1){
            return -1;
        }
        if(Math.abs(leftNodeHeight-rightNodeHeight)>1){
            return -1;
        }
        return Math.max(leftNodeHeight, rightNodeHeight) + 1;
    }
}
