package linklist.tmp;

import java.util.Stack;
import java.util.HashSet;

public class Test {

    public static Node reverse(Node input) {

        Node tmp = input;
        Stack<Integer> data = new Stack<>();
        int count = 1 ;
        Node oddNode = null;
        Node finalOddNode = null;
        Node prev = null;
        while (tmp != null) {
            if ((count % 2) == 0) {
                data.push(tmp.getData());
            }
            else{
                oddNode = new Node(tmp.getData());
                if(count==1){
                    finalOddNode = oddNode;
                }
                if(prev!=null){
                    prev.setNextNode(oddNode);
                }
                prev = oddNode;
            }
            tmp = tmp.getNextNode();
            count++;
        }

        Node current = new Node(data.pop());
        Node evenNode = current;
        prev = current;
        while (!data.isEmpty()) {
            current = new Node(data.pop());
            if (prev != null) {
                prev.setNextNode(current);
            }
            prev = current;
        }

        System.out.println("hi");
        return merge(evenNode, finalOddNode);

    }

    public static Node merge(Node evenNode, Node oddNode){
        Node tmp = null;
        Node result = null;
        Node prev = null;
        int count=1;
        while(evenNode!=null || oddNode!=null){
            if(count%2==0){
                tmp = new Node(evenNode.getData());
                evenNode = evenNode.getNextNode();
            }
            else{
                tmp = new Node(oddNode.getData());
                if(count==1){
                    result = tmp;
                }
                oddNode = oddNode.getNextNode();
            }
            if(prev!=null){
                prev.setNextNode(tmp);
            }
            prev=tmp;
            count++;
        }

        return result;
    }

    public static void main(String[] args) {
        Node A = new Node(21);
        Node B = new Node(29);
        Node C = new Node(25);
        Node D = new Node(28);
        Node E = new Node(32);
        Node F = new Node(37);
        A.setNextNode(B);
        B.setNextNode(C);
        C.setNextNode(D);
        D.setNextNode(E);
        E.setNextNode(F);

        reverse(A);
        System.out.println("hello");
    }
}


class Node{
    int data;
    Node nextNode;

    public Node(int data){
        this.data = data;
    }

    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data=data;
    }

    public void setNextNode(Node nextNode){
        this.nextNode = nextNode;
    }

    public Node getNextNode(){
        return this.nextNode;
    }

}