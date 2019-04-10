package binary.tree.play;

import java.util.Queue;
import java.util.LinkedList;

public class Play {

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

        breathFirst(head);
        System.out.println();
        depthFirst(head);
        System.out.println();

        System.out.println(isBST(head, Integer.MAX_VALUE, Integer.MIN_VALUE));

        System.out.println(lookup(head, 3));
        System.out.println(lookup(head, 13));
    }

    //breath first
    public static void breathFirst(Node a){
        Queue<Node> data = new LinkedList<Node>();
        data.offer(a);

        while(!data.isEmpty()){
            Node tmp = data.poll();
            System.out.print(tmp.getData() + "->");
            if(tmp.getLeftNode()!=null){
                data.offer(tmp.getLeftNode());
            }
            if(tmp.getRightNode()!=null){
                data.offer(tmp.getRightNode());
            }
        }
    }

    //pre-order
    public static void depthFirst(Node a){
        System.out.print(a.getData() + "->");
        if(a.getLeftNode()!=null){
            depthFirst(a.getLeftNode());
        }
        if(a.getRightNode()!=null){
            depthFirst(a.getRightNode());
        }
    }

    static Node insert(Node head, Node data){
        if(head==null){
            return data;
        }

        if(data.getData() <= head.getData()){
            head.setLeftNode(insert(head.getLeftNode(), data));
        }
        else{
            head.setRightNode(insert(head.getRightNode(), data));
        }

        return head;
    }

    //lookup
    static Node lookup(Node head, int data){
        if(head == null){
            return null;
        }

        if(head.getData() == data){
            return head;
        }

        if(data <= head.getData()){
            return lookup(head.getLeftNode(), data);
        }
        else{
            return lookup(head.getRightNode(), data);
        }
    }

    public static boolean isBST(Node head, int max, int min){
        if(head==null){
            return true;
        }

        if(head.getData()<=min || head.getData()>max){
            return false;
        }

        return isBST(head.getLeftNode(), head.getData(), min) && isBST(head.getRightNode(), max, head.getData());
    }


}
