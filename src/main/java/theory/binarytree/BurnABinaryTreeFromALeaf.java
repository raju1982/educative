package theory.binarytree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BurnABinaryTreeFromALeaf {

    public static void main(String[] str) {
        Node root = new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(30));
        root.getLeftNode().setLeftNode(new Node(40));
        root.getLeftNode().setRightNode(new Node(50));
        root.getLeftNode().getLeftNode().setLeftNode(new Node(60));
        root.getLeftNode().getLeftNode().getLeftNode().setLeftNode(new Node(70));

        Node leafNode = new Node(50);
        System.out.println(firstSolution_levelOrderTraversal(root, leafNode));


        Distance dist=new Distance(-1);
        int leaf=50;

        burnTime(root,leaf,dist);
        System.out.print(res);
    }

    //return height of given binary tree with node as root
    //set the distance of current node to the given leaf if the leaf is descendant of root. if the leaf is not a descendant then it assign -1 as value.
    private static int res=0;
    public static int burnTime(Node node, int leafNodeValue, Distance dist){

        if(node==null){
            return 0;
        }
        //return height of binary tree as 1.
        //distance of current node to the given leafNodeValue is 0.
        if(node.getData()==leafNodeValue){
            dist.val=0;
            return 1;
        }
        Distance ldist=new Distance(-1);
        int leftHeight=burnTime(node.getLeftNode(),leafNodeValue,ldist);
        Distance rdist=new Distance(-1);
        int rightHeight=burnTime(node.getRightNode(),leafNodeValue,rdist);
        //check if the given leafNodeValue node is the descendant of the node node (ancestor)
        if(ldist.val!=-1){
            //distance of leafNodeValue node from 'node.getLeftNode()' and left exists in the left side of node. so we need to add 1 to get distance from node.
            dist.val=ldist.val+1;
            res=Math.max(res,dist.val+rightHeight);
        }
        else if(rdist.val!=-1){
            dist.val=rdist.val+1;
            res=Math.max(res,dist.val+leftHeight);
        }
        //return height of the node
        return Math.max(leftHeight,rightHeight)+1;
    }

    private static int firstSolution_levelOrderTraversal(Node root, Node leafNode) {
        if (Objects.isNull(root)) {
            return 0;
        }

        int result = 0;
        Queue<Node> data = new LinkedList<>();
        data.add(root);

        while (!data.isEmpty()) {
            Node node = data.poll();
            if (node.getData() != leafNode.getData()) {
                result = Math.max(result, FindDistanceBetweenTwoNodesOfABinaryTree.FindDistanceBetweenTwoNodesOfABinaryTree(root, node.getData(), leafNode.getData()));
            }
            if (node.getLeftNode() != null) {
                data.add(node.getLeftNode());
            }
            if (node.getRightNode() != null) {
                data.add(node.getRightNode());
            }
        }
        return result;
    }
}

