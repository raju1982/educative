package theory.binarytree;

import java.util.ArrayList;
import java.util.List;

//Given a binary tree and a sum, find if there is a path from root to leaf which sums to this sum.
public class RootToLeafSumBinaryTree {

    public static void main(String[] args){
        Node root=new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(30));
        root.getLeftNode().setLeftNode(new Node(40));
        root.getLeftNode().setRightNode(new Node(50));
        root.getRightNode().setLeftNode(new Node(60));
        root.getRightNode().setRightNode(new Node(70));

        List<Node> result = new ArrayList<>();
        boolean r = printPath(root, 100, result);
        if(r){
            result.forEach(node -> System.out.print(node.getData() + " "));
        }else{
            System.out.println("No path for sum " + 100);
        }
    }

    //Time complexity is O(n) since all nodes are visited.
    public static boolean printPath(Node root, int sum, List<Node> path){
        if(root == null){
            return false;
        }

        if(root.getLeftNode() == null && root.getLeftNode() == null){
            if(root.getData() == sum){
                path.add(root);
                return true;
            }else{
                return false;
            }
        }
        if(printPath(root.getLeftNode(), sum-root.getData(), path) || printPath(root.getRightNode(), sum - root.getData(), path)){
            path.add(root);
            return true;
        }
        return false;
    }
}
