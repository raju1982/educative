package theory.binarytree;

//https://www.geeksforgeeks.org/find-the-largest-complete-subtree-in-a-given-binary-tree/
public class FindTheLargestCompleteSubtreeInAGivenBinaryTree {

    // Structure for return type of function findPerfectBinaryTree
    static class ReturnType {
        // To store if sub-tree is perfect or not
        boolean isPerfect;

        // To store if sub-tree is complete or not
        boolean isComplete;

        // size of the tree
        int size;

        // Root of biggest complete sub-tree
        Node rootTree;
    }


    // helper function that returns height of the tree given size
    static int getHeight(int size) {
        return (int) Math.ceil(Math.log(size + 1) / Math.log(2));
    }


    // Function to return the biggest complete binary sub-tree
    static ReturnType findCompleteBinaryTree(Node root) {

        // Declaring returnType that
        // needs to be returned
        ReturnType returnValue = new ReturnType();

        // If root is null then it is considered as both
        // perfect and complete binary tree of size 0
        if (root == null) {
            returnValue.isPerfect = true;
            returnValue.isComplete = true;
            returnValue.size = 0;
            returnValue.rootTree = null;
            return returnValue;
        }

        // Recursive call for left and right child
        ReturnType leftSubtree = findCompleteBinaryTree(root.getLeftNode());
        ReturnType rightSubtree = findCompleteBinaryTree(root.getRightNode());

        // CASE - A
        // If left sub-tree is perfect and right is complete and
        // there height is also same then sub-tree root
        // is also complete binary sub-tree with size equal to
        // sum of left and right subtrees plus one for current root
        if (leftSubtree.isPerfect == true && rightSubtree.isComplete == true
                && getHeight(leftSubtree.size) == getHeight(rightSubtree.size)) {
            returnValue.isComplete = true;

            // If right sub-tree is perfect then root is also perfect
            returnValue.isPerfect = (rightSubtree.isPerfect ? true : false);
            returnValue.size = leftSubtree.size + rightSubtree.size + 1;
            returnValue.rootTree = root;
            return returnValue;
        }

        // CASE - B
        // If left sub-tree is complete and right is perfect and the
        // height of left is greater than right by one then sub-tree root
        // is complete binary sub-tree with size equal to
        // sum of left and right subtrees plus one for current root.
        // But sub-tree cannot be perfect binary sub-tree.
        if (leftSubtree.isComplete == true && rightSubtree.isPerfect == true
                && getHeight(leftSubtree.size) == getHeight(rightSubtree.size) + 1) {
            returnValue.isComplete = true;
            returnValue.isPerfect = false;
            returnValue.size = leftSubtree.size + rightSubtree.size + 1;
            returnValue.rootTree = root;
            return returnValue;
        }
        // CASE - C
        // Else this sub-tree cannot be a complete binary tree
        // and simply return the biggest sized complete sub-tree
        // found till now in the left or right sub-trees
        returnValue.isPerfect = false;
        returnValue.isComplete = false;
        returnValue.size = Math.max(leftSubtree.size, rightSubtree.size);
        returnValue.rootTree = (leftSubtree.size > rightSubtree.size ? leftSubtree.rootTree : rightSubtree.rootTree);
        return returnValue;
    }

    public static void inorderPrint(Node root) {
        if (root != null) {
            inorderPrint(root.getLeftNode());
            System.out.print(root.getData() + "\t");
            inorderPrint(root.getRightNode());
        }
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.setLeftNode(new Node(30));
        root.setRightNode(new Node(60));
        root.getLeftNode().setLeftNode(new Node(5));
        root.getLeftNode().setRightNode(new Node(20));
        root.getRightNode().setLeftNode(new Node(45));
        root.getRightNode().setRightNode(new Node(70));
        root.getRightNode().getLeftNode().setLeftNode(new Node(10));

        // Get the biggest sized complete binary sub-tree
        ReturnType ans = findCompleteBinaryTree(root);

        System.out.println("Size : " + ans.size);

        // Print the inorder traversal of the found sub-tree
        System.out.print("Inorder Traversal : ");
        inorderPrint(ans.rootTree);
    }
}
