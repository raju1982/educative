package linklist;

public class Node{
    int data;
    Node node;

    public Node(int data){
        this.data = data;
    }

    public void setData(int data){
        this.data = data;
    }

    public int getData(){
        return data;
    }

    public void setNextNode(Node node){
        this.node = node;
    }

    public Node getNextNode(){
        return node;
    }

}