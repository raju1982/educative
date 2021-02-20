package theory.binarytree;

import java.util.List;
import java.util.ArrayList;

public class BranchSum {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(30));
        root.getRightNode().setLeftNode(new Node(40));
        root.getRightNode().setRightNode(new Node(50));

        List<Integer> result = findBranchSum(root);
        System.out.println(result);
    }

    public static List<Integer> findBranchSum(Node root){
        List<Integer> data = new ArrayList<>();
        findBranchSum(root, 0, data);
        return data;
    }

    private static void findBranchSum(Node node, int sum, List<Integer> data){
        if(node == null){
            return;
        }
        sum = sum + node.getData();
        if(node.getLeftNode()==null && node.getRightNode()==null){
            data.add(sum);
            return;
        }
        if(node.getLeftNode()!=null) {
            findBranchSum(node.getLeftNode(), sum, data);
        }

        if(node.getRightNode()!=null) {
            findBranchSum(node.getRightNode(), sum, data);
        }
    }
}
