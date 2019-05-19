package linklist;
import java.util.Stack;

public class Palindrome {
    public static boolean isPalindrome(NodeX input){

        if(input == null){
            throw new IllegalArgumentException();
        }

        if(input.getNextNode()==null){
            return true;
        }

        Stack<String> data = new Stack<>();
        NodeX pointer = input;

        while(input!=null){
            data.push(input.getData());
            input = input.getNextNode();
        }


        while(!data.isEmpty()){
            if(!data.pop().equalsIgnoreCase(pointer.getData())){
                return false;
            }
            pointer = pointer.getNextNode();
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
        System.out.println(isPalindrome(a));
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