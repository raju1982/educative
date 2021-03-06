package theory.binarysearchtree;

import theory.binarytree.Node;

import java.util.Stack;

public class CheckForBST {

    public static void main(String[] args){
        Node root=new Node(4);
        root.setLeftNode(new Node(2));
        root.setRightNode(new Node(5));
        root.getLeftNode().setLeftNode(new Node(1));
        root.getLeftNode().setRightNode(new Node(3));

        System.out.println(iterativeInOrder(root));
    }

    //time complexity O(n)
    //Auxiliary Space = height + 1 = O(h)
    static int prev=Integer.MIN_VALUE;
    public static boolean isBST(Node root){
        if (root == null)
            return true;

        if(isBST(root.getLeftNode())==false){
            return false;
        }

        if(root.getData()<=prev)return false;
        prev=root.getData();

        return isBST(root.getRightNode());
    }



    //time complexity O(n)
    //Auxiliary Space = height + 1 = O(h)
    // [at most we will have left->left->left of node, which will be height of tree]
    public static boolean iterativeInOrder(Node root) {
        if (root == null) {
            return true;
        }
        Stack<Node> data = new Stack<>();
        Node currentNode = root;
        Node previousNode = null;
        while(true){
            if(currentNode != null){
                data.push(currentNode);
                currentNode = currentNode.getLeftNode();
            }
            else{
                if(data.isEmpty()){
                    break;
                }
                currentNode = data.pop();
                if(previousNode!=null && previousNode.getData()>currentNode.getData()){
                    return false;
                }
                previousNode = currentNode;
                //System.out.print(currentNode.getData() + "\t");
                currentNode = currentNode.getRightNode();
            }
        }
        return true;
    }
}
