package binary.tree;

public class BinaryTreeAddNode {

    /*
    //insert binary search tree
    public static Node insert(Node root, Node node){
        if(root == null){
            return node;
        }
        if(node.getData() <= root.getData()){
            root.setLeftNode(insert(root.getLeftNode(),node));
        }
        else{
            root.setRightNode(insert(root.getRightNode(),node));
        }
        return root;
    }

     */

    public Node addNode(int data, Node head){
        Node tempHead = head;
        Node n = Node.newNode(data);
        if(head == null){
            head = n;
            return head;
        }
        Node prev = null;
        while(head != null){
            prev = head;
            if(head.data < data){
                head = head.right;
            }else{
                head = head.left;
            }
        }
        if(prev.data < data){
            prev.right = n;
        }else{
            prev.left = n;
        }
        return tempHead;
    }

    class IntegerRef{
        int height;
    }

    public static void main(String args[]){
        BinaryTreeAddNode bt = new BinaryTreeAddNode();
        Node head = null;
        head = bt.addNode(10, head);
        head = bt.addNode(15, head);
        head = bt.addNode(5, head);
        head = bt.addNode(7, head);
        head = bt.addNode(19, head);
        head = bt.addNode(20, head);
        head = bt.addNode(-1, head);
        head = bt.addNode(21, head);

    }
}
