package linklist;
import java.util.Stack;

public class Palindrome {
    public static boolean palindrome(NodeX input){

        if(input == null){
            throw new IllegalArgumentException();
        }

        if(input.getNextNode()==null){
            return true;
        }

        Stack<String> data = new Stack<>();

        NodeX tmp = input;

        while(tmp!=null){
            data.push(tmp.getData());
            tmp=tmp.getNextNode();
        }

        tmp = input;
        while(tmp!=null){
            if(data.pop() != tmp.getData()){
                return false;
            }
            tmp=tmp.getNextNode();
        }
        return true;
    }

    public static void main(String[] args){
        NodeX a = new NodeX("M");
        NodeX b = new NodeX("A");
        a.setNextNode(b);
        NodeX c = new NodeX("D");
        b.setNextNode(c);
        NodeX d = new NodeX("A");
        c.setNextNode(d);
        NodeX e = new NodeX("M");
        d.setNextNode(e);
        System.out.println(palindrome(a));
    }

}



class NodeX {
    String data;
    NodeX node;

    public NodeX(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public NodeX getNextNode() {
        return node;
    }

    public void setNextNode(NodeX node) {
        this.node = node;
    }
}