package linklist.play;

public class Node {
    int data;
    Node node;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNextNode() {
        return node;
    }

    public void setNextNode(Node node) {
        this.node = node;
    }
}
