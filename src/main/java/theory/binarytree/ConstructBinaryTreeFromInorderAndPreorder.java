package theory.binarytree;

//binary tree can be constructed from -
// 1. Inorder array And PreOrder array
// 2. Inorder array And PostOrder array
public class ConstructBinaryTreeFromInorderAndPreorder {

    //we can make this solution O(n) by storing indexes of inorder traversal in a hash table. So that search can be done O(1) time.
    //https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/


    //enhanced pre-order traversal code
    //time complexity O(N^2)
    private static int preIndex=0;
    public static Node createBinaryTree(int inOrder[],int preOrder[],int startIndex,int endIndex){
        if(startIndex>endIndex){
            return null;
        }

        /* Pick current node from Preorder traversal using preIndex and increment preIndex */
        Node root=new Node(preOrder[preIndex++]);

        /* If this node has no children then return */
        if (startIndex == endIndex)
            return root;

        /* Else find the index of this node in Inorder traversal */
        int inIndex=startIndex;
        for(int i=startIndex;i<=endIndex;i++){
            if(inOrder[i]==root.getData()){
                inIndex=i;
                break;
            }
        }

        /* Using index in Inorder traversal, construct left and right subtress */
        root.setLeftNode(createBinaryTree(inOrder, preOrder, startIndex, inIndex-1));
        root.setRightNode(createBinaryTree(inOrder, preOrder, inIndex+1, endIndex));
        return root;
    }

    private static void inOrderTraversal(Node root){
        if(root!=null){
            inOrderTraversal(root.getLeftNode());
            System.out.print(root.getData() + " ");
            inOrderTraversal(root.getRightNode());
        }
    }

    public static void main(String args[])
    {
        int inOrder[]={20,10,40,30,50};
        int preOrder[]={10,20,30,40,50};
        Node root=createBinaryTree(inOrder, preOrder, 0, inOrder.length-1);

        inOrderTraversal(root);
    }
}
