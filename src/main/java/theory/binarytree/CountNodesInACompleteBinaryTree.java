package theory.binarytree;

public class CountNodesInACompleteBinaryTree {
    public static void main(String[] args){
        Node root = new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(30));
        root.getLeftNode().setLeftNode(new Node(40));
        root.getLeftNode().setRightNode(new Node(50));
        root.getRightNode().setLeftNode(new Node(60));
        root.getRightNode().setRightNode(new Node(70));

        System.out.println(countNodes(root));
        System.out.println(efficientSolution(root));
    }

    //time complexity is O(n)
    public static int countNodes(Node node){
        if(node == null){
            return 0;
        }
        return 1 + countNodes(node.getLeftNode()) +  countNodes(node.getRightNode());
    }

    //O(Log n * Log n)
    public static int efficientSolution(Node node){
        if(node == null){
            return 0;
        }

        Node current = node;
        int leftSize = 0;
        while(current!=null){
            leftSize++;
            current = current.getLeftNode();
        }

        current = node;
        int rightSize = 0;
        while(current!=null){
            rightSize++;
            current = current.getRightNode();
        }

        if(leftSize == rightSize){
            return (int) Math.pow(2, leftSize)-1;
        }

        return 1 + countNodes(node.getLeftNode()) +  countNodes(node.getRightNode());
    }
}
