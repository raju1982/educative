package theory.binarysearchtree;

import theory.binarytree.Node;

import java.util.*;

public class VerticalTraversalOfBinaryTree {

    public static void main(String[] args){
        Node root=new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(30));
        root.getLeftNode().setLeftNode(new Node(40));
        root.getLeftNode().setRightNode(new Node(50));
        Map<Integer, List<Integer>> treeMap = new TreeMap<>();
        enhancedLevelOrderTraversal(root, treeMap);

        for(Map.Entry<Integer, List<Integer>> tmp: treeMap.entrySet()){
            for(int nodeVal : tmp.getValue()) {
                System.out.print(nodeVal + "\t");
            }
            System.out.println();
        }
    }

    //time complexity O(n) -> for every node we do O(1) work (enque and deque operation)
    //Auxiliary space is equal to width of binary tree O(n)
    public static void enhancedLevelOrderTraversal(Node node, Map<Integer, List<Integer>> treeMap){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(node, 0));

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            List<Integer> tmpList;
            if(treeMap.get(pair.horizontalDistance)!=null){
                tmpList = treeMap.get(pair.horizontalDistance);
            }
            else{
                tmpList = new ArrayList<>();
            }
            tmpList.add(pair.node.getData());
            treeMap.put(pair.horizontalDistance, tmpList);
            if(pair.node.getLeftNode()!=null){
                queue.add(new Pair(pair.node.getLeftNode(), pair.horizontalDistance-1));
            }
            if(pair.node.getRightNode()!=null){
                queue.add(new Pair(pair.node.getRightNode(),pair.horizontalDistance+1));
            }
        }
    }
}
