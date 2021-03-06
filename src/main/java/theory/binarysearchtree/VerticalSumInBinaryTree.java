package theory.binarysearchtree;

import theory.binarytree.Node;

import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class VerticalSumInBinaryTree {
    public static void main(String[] args){
        Node root=new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(50));
        root.getLeftNode().setLeftNode(new Node(30));
        root.getLeftNode().setRightNode(new Node(40));
        verticalSumInBinaryTree(root);
    }

    //O(n*loghd) + O(hd) = O(n*loghd)
    public static void verticalSumInBinaryTree(Node node){
        Map<Integer, Integer> data = new TreeMap<>();
        verticalSumInBinaryTree(node, 0, data);
        //O(hd) to traverse the treemap.
        for(Map.Entry val: data.entrySet()){
            System.out.print(val.getValue() + "\t");
        }
    }

    //time complexity O(n*loghd)
    //Auxiliary Space = hd + 1 = O(h) & O(n) for hash , overall O(n) for space
    public static void verticalSumInBinaryTree(Node node, int hd, Map<Integer, Integer> data){
        if(node==null){
            return;
        }
        verticalSumInBinaryTree(node.getLeftNode(),hd-1, data);
        int tmpVal = data.get(hd) == null ? 0 : data.get(hd);
        data.put(hd, tmpVal+node.getData());
        verticalSumInBinaryTree(node.getRightNode(),hd+1, data);
    }
}
