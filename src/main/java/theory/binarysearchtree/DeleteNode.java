package theory.binarysearchtree;

import theory.binarytree.Node;

public class DeleteNode {
    public static void main(String[] args) {
        Node node = InsertNode.iterativeInsert(null, 10);
        InsertNode.iterativeInsert(node, 5);
        InsertNode.iterativeInsert(node, 15);
        InsertNode.iterativeInsert(node, 12);
        InsertNode.iterativeInsert(node, 18);

        inOrderTraversal(node);

        deleteNode(node, 15);
        System.out.println();
        inOrderTraversal(node);
    }

    public static void inOrderTraversal(Node node){
        if(node!=null){
            inOrderTraversal(node.getLeftNode());
            System.out.print(node.getData() + "\t");
            inOrderTraversal(node.getRightNode());
        }
    }

    private static Node successor(Node node){
        Node current = node.getRightNode();
        while(current!=null && current.getLeftNode()!=null){
            current = current.getLeftNode();
        }
        return current;
    }

    //time complexity -> O(h), where h is the height of binary search tree.
    //auxiliary space -> recursive implementation needs O(h)
    public static Node deleteNode(Node node, int nodeValue){
        if(node == null){
            return null;
        }
        if(node.getData() > nodeValue){
            node.setLeftNode(deleteNode(node.getLeftNode(), nodeValue));
        }
        else if (node.getData() < nodeValue){
            node.setRightNode(deleteNode(node.getRightNode(), nodeValue));
        }
        else{
            if(node.getLeftNode()==null){
                return node.getRightNode();
            }
            else if (node.getRightNode() == null){
                return node.getLeftNode();
            }
            else{
                Node successorNode = successor(node);
                node.setData(successorNode.getData());
                node.setRightNode(deleteNode(node.getRightNode(), successorNode.getData()));
            }
        }
        return node;
    }

}
