package theory.binarysearchtree;

import theory.binarytree.Node;

import java.util.*;

public class TopViewOfBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(30));
        root.getLeftNode().setLeftNode(new Node(40));
        root.getLeftNode().setRightNode(new Node(50));
        Map<Integer, Integer> treeMap = new TreeMap<>();
        enhancedLevelOrderTraversal(root, treeMap);

        for(Map.Entry<Integer, Integer> tmp: treeMap.entrySet()){
            System.out.print(tmp.getValue() + "\t");
        }
    }

    public static void enhancedLevelOrderTraversal(Node node, Map<Integer, Integer> treeMap){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(node, 0));

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            if(!treeMap.containsKey(pair.horizontalDistance)){
                treeMap.put(pair.horizontalDistance, pair.node.getData());
            }
            if(pair.node.getLeftNode()!=null){
                queue.add(new Pair(pair.node.getLeftNode(), pair.horizontalDistance-1));
            }
            if(pair.node.getRightNode()!=null){
                queue.add(new Pair(pair.node.getRightNode(),pair.horizontalDistance+1));
            }
        }


    }

}
