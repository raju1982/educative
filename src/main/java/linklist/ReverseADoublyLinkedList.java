package linklist;

public class ReverseADoublyLinkedList {

    static Node2 Reverse(Node2 head) {
        Node2 temp = head;
        Node2 newHead = head;
        while (temp != null) {
            Node2 prev = temp.getPreviousNode();
            temp.setPreviousNode(temp.getNextNode());
            temp.setNextNode(prev);
            newHead = temp;
            temp = temp.getPreviousNode();
        }
        return newHead;
    }

    public static void main(String[] args) {
        Node2 a = new Node2(1);
        Node2 b = new Node2(2);
        Node2 c = new Node2(3);
        Node2 d = new Node2(4);

        a.setNextNode(b);
        b.setNextNode(c);
        c.setNextNode(d);
        d.setNextNode(null);

        a.setPreviousNode(null);
        b.setPreviousNode(a);
        c.setPreviousNode(b);
        d.setPreviousNode(c);

        System.out.println("hi");
         Reverse(a);
        System.out.println("hi");
    }

}


class Node2{
    int data;
    Node2 nextNode;
    Node2 previousNode;

    public Node2(int data){
        this.data = data;
    }

    public void setData(int data){
        this.data = data;
    }

    public int getData(){
        return data;
    }

    public void setNextNode(Node2 node){
        this.nextNode = node;
    }

    public Node2 getNextNode(){
        return nextNode;
    }

    public void setPreviousNode(Node2 node){
        this.previousNode = node;
    }

    public Node2 getPreviousNode(){
        return previousNode;
    }

}