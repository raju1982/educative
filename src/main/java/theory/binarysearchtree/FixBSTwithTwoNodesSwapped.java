package theory.binarysearchtree;

import theory.binarytree.Node;

public class FixBSTwithTwoNodesSwapped {
    public static void main(String[] args){
        Node root=new Node(18);
        root.setLeftNode(new Node(60));
        root.setRightNode(new Node(70));
        root.getLeftNode().setLeftNode(new Node(4));
        root.getRightNode().setLeftNode(new Node(8));
        root.getRightNode().setRightNode(new Node(80));

        inOrderTraversal(root);
        System.out.println();
        findNodes(root);

        System.out.println(first.getData());
        System.out.println(second.getData());
    }


    public static void inOrderTraversal(Node node){
        if(node!=null){
            inOrderTraversal(node.getLeftNode());
            System.out.print(node.getData() + "\t");
            inOrderTraversal(node.getRightNode());
        }
    }



    private static Node prev, first, second;
    //time complexity O(n)
    //Auxiliary Space = height + 1 = O(h)
    public static void findNodes(Node node){
        if(node == null){
            return;
        }
        findNodes(node.getLeftNode());
        if(prev!=null && prev.getData() > node.getData()){
            if(first==null){
                first = prev;
            }
            second = node;
        }
        prev = node;
        findNodes(node.getRightNode());
    }
}
