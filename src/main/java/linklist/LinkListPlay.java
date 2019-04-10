package linklist;

//import linklist.tmp.Node;

public class LinkListPlay {

    private Node head;

    public LinkListPlay(){
        head = null;
    }

    public LinkListPlay(Node head){
        this.head = head;
    }

    public void setHead(Node head){
        this.head = head;
    }

    public Node getHead(){
       return head;
    }

    public void insertAtHead(Node node){
        node.setNextNode(head);
        setHead(node);
    }

    public void insertAtEnd(Node node){
        if(head == null){
            head = node;
            return;
        }
        Node nodeA = head;
        while(nodeA.getNextNode() != null){
            nodeA = nodeA.getNextNode();
        }
        nodeA.setNextNode(node);
    }

    @Override
    public String toString(){
        Node nodeA = head;
        StringBuffer stBuffer = new StringBuffer();
        while(nodeA.getNextNode() != null){
            stBuffer.append(nodeA.getData() + " ");
            nodeA = nodeA.getNextNode();
        }
        return stBuffer.append(nodeA.getData()).toString();
    }

    public static void main(String[] args){
        LinkListPlay list = new LinkListPlay();

       /* for (int i = 1; i <= 10; i++) {
            list.insertAtHead(new Node(i));
        }

        System.out.println(list.toString());
        */

        for (int i = 1; i <= 10; i++) {
            list.insertAtEnd(new Node(i));
        }

        System.out.println(list.toString());


    }
}



