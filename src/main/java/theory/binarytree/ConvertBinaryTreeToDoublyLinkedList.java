package theory.binarytree;

//traverse using pre order
//left pointer as back pointer
//right pointer as front pointer
public class ConvertBinaryTreeToDoublyLinkedList {
    private static Node prev = null;

    //doing pre-order traversal
    //time complexity O(n)
    //Auxiliary Space = height + 1 = O(h)
    public static Node BinaryTreeToDoubleLinkList(Node root){
        if(root==null){
            return root;
        }
        //traverse the left subtree
        Node head=BinaryTreeToDoubleLinkList(root.getLeftNode());
        //process the current node
        if(prev==null){
            head=root;
        }else{
            prev.setRightNode(root);
            root.setLeftNode(prev);
        }
        prev = root;
        //traverse the right subtree
        BinaryTreeToDoubleLinkList(root.getRightNode());
        return head;
    }

    public static void printlist(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.getData()+" ");
            curr=curr.getRightNode();
        }
    }

    public static void main(String[] args){
        Node root=new Node(10);
        root.setLeftNode(new Node(5));
        root.setRightNode(new Node(20));
        root.getRightNode().setLeftNode(new Node(30));
        root.getRightNode().setRightNode(new Node(35));

        Node head=BinaryTreeToDoubleLinkList(root);
        printlist(head);
    }
}
