package linklist;

public class NthNodeSwapWithHead {


    //better solution
    /*
        public static int length(Node input) {
        int count = 0;
        while (input != null) {
            input = input.getNextNode();
            count++;
        }
        return count;
    }

    public static void swapNode(Node input, int position){
        int length = length(input);
        int pos = length - position;
        Node head = input;
        Node test = input;
        Node prev = null;
        while(input!=null){
            pos--;
            if(pos == 0){
                break;
            }
            prev = input;
            input = input.getNextNode();
        }

        Node tmp = head.getNextNode();
        prev.setNextNode(head);
        head.setNextNode(input.getNextNode());
        input.setNextNode(tmp);

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

        swapNode(a, 3);

        System.out.println("");
    }
     */

    public static void swapNthNodeWithHead(LinkListPlay list, int nth){
        int count=1;

        Node tmp = list.getHead();
        Node tmp2 = list.getHead().getNextNode();
        Node prev = null;

        while(tmp!=null){
            if(count == nth){
                break;
            }
            prev = tmp;
            tmp = tmp.getNextNode();
            count++;
        }

        Node swapNode = tmp;
        prev.setNextNode(list.getHead());
        list.getHead().setNextNode(swapNode.getNextNode());
        list.setHead(swapNode);
        swapNode.setNextNode(tmp2);

    }

    public static void main(String[] args) {
        LinkListPlay list = new LinkListPlay();
        for (int i = 1; i <= 10; i++) {
            if (i == 2) {
                list.insertAtEnd(new linklist.Node(1));
                continue;
            }
            list.insertAtEnd(new linklist.Node(i));
        }

        list.insertAtEnd(new linklist.Node(8));
        list.insertAtEnd(new linklist.Node(1));
        System.out.println(list.toString());

        System.out.println(list.toString());
        //reverse(list);
        System.out.println(list.toString());
        //NthNode(list, 3);
        //System.out.println(list.toString());

        swapNthNodeWithHead(list, 3);
        System.out.println(list.toString());  

    }
}







