package theory.binarysearchtree;

import theory.binarytree.Node;

public class InsertNode {

    public static void main(String[] args){
        Node node = recursiveInsert(null, 10);
        recursiveInsert(node, 5);
        recursiveInsert(node, 15);
        recursiveInsert(node, 12);
        recursiveInsert(node, 18);

        preOrderTraversal(node);

        System.out.println();

        Node node1 = iterativeInsert(null, 10);
        iterativeInsert(node1, 5);
        iterativeInsert(node1, 15);
        iterativeInsert(node1, 12);
        iterativeInsert(node1, 18);
        preOrderTraversal(node1);
    }

    //time complexity -> O(h), where h is the height of binary search tree.
    //auxiliary space -> recursive implementation needs O(h)
    public static Node recursiveInsert(Node node, int newNodeValue){
        if(node == null){
            node = new Node(newNodeValue);
        }
        else if(node.getData() > newNodeValue){
            node.setLeftNode(recursiveInsert(node.getLeftNode(), newNodeValue));
        }
        else if(node.getData() < newNodeValue){
            node.setRightNode(recursiveInsert(node.getRightNode(), newNodeValue));
        }

        return node;
    }


    //time complexity -> O(h), where h is the height of binary search tree.
    //Iterative implementation is 0(1) it does not require auxiliary space.
    public static Node iterativeInsert(Node node, int newNodeValue){
        Node temp = new Node(newNodeValue);
        Node current=node, parent=null;
        while(current!=null){
            parent = current;
            if(current.getData()>newNodeValue){
                current = current.getLeftNode();
            }
            else if(current.getData()<newNodeValue){
                current = current.getRightNode();
            }
            else{
                return node;
            }
        }

        if(parent==null) {
            return temp;
        }
        else if(parent.getData()>newNodeValue){
            parent.setLeftNode(temp);
        }
        else if(parent.getData()<newNodeValue){
            parent.setRightNode(temp);
        }

        return node;
    }




    public static void preOrderTraversal(Node node){
        if(node!=null){
            System.out.print(node.getData() + "\t");
            preOrderTraversal(node.getLeftNode());
            preOrderTraversal(node.getRightNode());
        }
    }

}
