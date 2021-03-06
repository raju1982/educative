package theory.binarysearchtree;

import theory.binarytree.Node;

import java.util.HashSet;
import java.util.Set;

public class PairSumWithGivenBST {

    public static void main(String[] args){
        Node root=new Node(4);
        root.setLeftNode(new Node(2));
        root.setRightNode(new Node(5));
        root.getLeftNode().setLeftNode(new Node(1));
        root.getLeftNode().setRightNode(new Node(3));
        System.out.println(inOrderTraversal(root, 8, new HashSet<>()));
    }

    //returns true as soon as it finds the pair
    //time complexity O(n)
    //Auxiliary Space = height + 1 = O(h) & O(n) for hash , overall O(n) for space
    public static boolean inOrderTraversal(Node node, int sum, Set<Integer> data){
        if(node == null){
            return true;
        }
        if(inOrderTraversal(node.getLeftNode(), sum, data)){
            return true;
        }
        int tmp = node.getData();
        if(data.contains(tmp)){
           return true;
        }
        data.add(sum - tmp);
        return inOrderTraversal(node.getRightNode(), sum, data);
    }
}
