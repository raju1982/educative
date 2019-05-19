package linklist;

public class NthNodeFromEnd {

    public static int length(Node input) {
        int count = 0;
        while (input != null) {
            input = input.getNextNode();
            count++;
        }
        return count;
    }

    public static Node searchNode(Node input, int position){
        int length = length(input);
        int pos = length - position;
        while(input!=null){
            pos--;
            if(pos == 0){
                break;
            }
            input = input.getNextNode();
        }
        return input;
    }

    public static void main(String[] args) {
        Node a = new Node(100);
        Node b = new Node(200);
        Node c = new Node(300);
        Node d = new Node(400);
        Node e = new Node(500);
        Node f = new Node(600);

        a.setNextNode(b);
        b.setNextNode(c);
        c.setNextNode(d);
        d.setNextNode(e);
        e.setNextNode(f);

        Node result = searchNode(a, 3);

        System.out.println(result.getData());
    }
}
