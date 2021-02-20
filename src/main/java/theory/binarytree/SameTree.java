package theory.binarytree;

public class SameTree {

    public static void main(String[] args){
        Node root1=new Node(10);
        root1.setLeftNode(new Node(20));
        root1.setRightNode(new Node(30));
        root1.getLeftNode().setLeftNode(new Node(40));
        root1.getLeftNode().setRightNode(new Node(50));
        root1.getRightNode().setLeftNode(new Node(60));
        root1.getRightNode().setRightNode(new Node(70));

        Node root2=new Node(10);
        root2.setLeftNode(new Node(20));
        root2.setRightNode(new Node(30));
        root2.getLeftNode().setLeftNode(new Node(40));
        root2.getLeftNode().setRightNode(new Node(50));
        root2.getRightNode().setLeftNode(new Node(60));
        root2.getRightNode().setRightNode(new Node(70));

        System.out.println(checkIftreeAreSimilar(root1, root2));
    }


    public static boolean checkIftreeAreSimilar(Node root1, Node root2){
        if(root1==null && root2 ==null){
            return true;
        }

        if(root1==null || root2 ==null){
            return false;
        }

        return (root1.getData() == root2.getData()) &&
                checkIftreeAreSimilar(root1.getLeftNode(), root2.getLeftNode()) &&
                checkIftreeAreSimilar(root1.getRightNode(), root2.getRightNode());

    }

}
