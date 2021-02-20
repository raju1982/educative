package theory.binarytree;

public class DepthRecursiveTraversal {

    public static void main(String[] args){
        Node root=new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(30));
        root.getRightNode().setLeftNode(new Node(40));
        root.getRightNode().setRightNode(new Node(50));

        System.out.println("inOrderTraversal");
        inOrderTraversal(root);
        System.out.println("\n" + "preOrderTraversal");
        preOrderTraversal(root);
        System.out.println("\n" + "postOrderTraversal");
        postOrderTraversal(root);
    }

    //time complexity O(n)
    //Auxiliary Space = height + 1 = O(h)
    //(Left Root Right)
    public static void inOrderTraversal(Node root){
        if(root!=null){
            inOrderTraversal(root.getLeftNode());
            System.out.print(root.getData() + " ");
            inOrderTraversal(root.getRightNode());
        }
    }

    //time complexity O(n)
    //Auxiliary Space = height + 1 = O(h)
    //(Root Left Right)
    public static void preOrderTraversal(Node root){
        if(root!=null){
            System.out.print(root.getData() + " ");
            preOrderTraversal(root.getLeftNode());
            preOrderTraversal(root.getRightNode());
        }
    }

    //time complexity O(n)
    //Auxiliary Space = height + 1 = O(h)
    //(Left Right Root)
    public static void postOrderTraversal(Node root){
        if(root!=null){
            postOrderTraversal(root.getLeftNode());
            postOrderTraversal(root.getRightNode());
            System.out.print(root.getData() + " ");
        }
    }
}


