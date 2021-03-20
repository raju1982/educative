package theory.binarysearchtree;

public class KthSmallestBinarySearchTree {

    public static void main(String args[])
    {
        ModifiedNode root = null;
        int keys[] = { 20, 8, 22, 4, 12, 10, 14 };

        for (int x : keys)
            root = recursiveInsert(root, x);

        int k = 4;
        ModifiedNode res = findKthSmallestNode(root, k);
        if (res == null)
            System.out.println("There are less than k nodes in the BST");
        else
            System.out.println("K-th Smallest Element is " + res.getData());
    }

    //time complexity -> O(h), where h is the height of binary search tree.
    //auxiliary space -> recursive implementation needs O(h)
    public static ModifiedNode recursiveInsert(ModifiedNode node, int newNodeValue){
        if(node == null){
            node = new ModifiedNode(newNodeValue);
        }
        else if(node.getData() > newNodeValue){
            node.setLeftNode(recursiveInsert(node.getLeftNode(), newNodeValue));
            node.setLeftNodeCount(node.getLeftNodeCount()+1);
        }
        else if(node.getData() < newNodeValue){
            node.setRightNode(recursiveInsert(node.getRightNode(), newNodeValue));
        }
        return node;
    }

    //very close to search function
    //time complexity -> O(h), where h is the height of binary search tree.
    public static ModifiedNode findKthSmallestNode(ModifiedNode node, int k){
        if(node==null){
            return null;
        }

        int count = node.getLeftNodeCount()+1;

        if(count==k){
            return node;
        }

        if(count>k){
           return findKthSmallestNode(node.getLeftNode(), k);
        }

        return findKthSmallestNode(node.getRightNode(), k-count);
    }

}
