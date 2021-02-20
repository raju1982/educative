package theory.binarytree;

public class Node {
    private int data;
    private Node leftNode;
    private Node rightNode;

    public Node(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

}
