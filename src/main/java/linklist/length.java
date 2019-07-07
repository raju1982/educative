package linklist;

public class length {

    public static int length(Node input) {
        int count = 0;
        while (input != null) {
            input = input.getNextNode();
            count++;
        }
        return count;
    }

    public static int solution(Node node){
        if(node == null){
            return 0;
        }

        return solution(node.getNextNode()) + 1;
    }


    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(10);
        Node c = new Node(8);
        Node d = new Node(12);
        Node e = new Node(3);
        Node f = new Node(2);
        a.setNextNode(b);
        b.setNextNode(c);
        c.setNextNode(d);
        d.setNextNode(e);
        e.setNextNode(f);

        System.out.println(length(a));
        System.out.println(solution(a));
    }
}
