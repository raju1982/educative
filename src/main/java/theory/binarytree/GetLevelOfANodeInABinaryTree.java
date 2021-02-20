package theory.binarytree;

public class GetLevelOfANodeInABinaryTree {

    public static void main(String[] str){
        Node root=new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(30));
        root.getRightNode().setLeftNode(new Node(40));
        root.getRightNode().setRightNode(new Node(60));
        root.getRightNode().getLeftNode().setLeftNode(new Node(50));
        root.getRightNode().getRightNode().setRightNode(new Node(70));

        System.out.println(solution(root, 40, 0));
    }

    public static int solution(Node root, int nodeValue, int level){
        if(root==null){
            return -1;
        }

        if(root.getData() == nodeValue){
            return level;
        }

        int leftSubtreeLevel = solution(root.getLeftNode(), nodeValue, level+1);
        if(leftSubtreeLevel!=-1){
            return leftSubtreeLevel;
        }
        return solution(root.getRightNode(), nodeValue, level+1);
    }
}
