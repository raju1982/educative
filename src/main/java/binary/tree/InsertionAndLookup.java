package binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertionAndLookup {

    public static void main(String[] args){
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);

        Node head = insert(null, five);

        insert(head, one);
        insert(head, seven);
        insert(head, three);
        insert(head, eight);
        insert(head, two);
        insert(head, nine);
        insert(head, six);
        insert(head, four);

        breathFirstTraversal(head);
        System.out.println("");
        inOrderTravers(head);
        System.out.println("");

        System.out.println(lookup(head, 7));
        System.out.println(lookup(head, 12));
    }


    public static Node insert(Node head, Node node){
        if(head==null){
            return node;
        }

        if(node.getData()<=head.getData()){
            head.setLeftNode(insert(head.getLeftNode(), node));
        }
        else{
            head.setRightNode(insert(head.getRightNode(), node));
        }
        return head;
    }


    public static Node lookup(Node node, int data){
        if(node == null){
            return null;
        }

        if(node.getData() == data){
            return node;
        }

        if(data < node.getData()){
            return lookup(node.getLeftNode(), data);
        }
        else{
            return lookup(node.getRightNode(), data);
        }
    }



    static void breathFirstTraversal(Node node) {
        Queue<Node> data = new LinkedList<>();
        data.add(node);
        while (!data.isEmpty()) {
            Node np = data.poll();
            System.out.print(np.getData() + " -> ");
            Node left = np.getLeftNode();
            if (left != null) {
                data.add(left);
            }
            Node right = np.getRightNode();
            if (right != null) {
                data.add(right);
            }
        }
    }

    static void inOrderTravers(Node node){
        if(node == null){
            return;
        }
        inOrderTravers(node.getLeftNode());
        System.out.print(node.getData() + " -> ");
        inOrderTravers(node.getRightNode());
    }



}


