package linklist;

public class NthNodeSwapWithHead {

    public static void NthNode(LinkListPlay list, int nth) {
        linklist.Node previous = list.getHead();
        int count = 1;

        while (previous != null) {
            previous = previous.getNextNode();
            count++;
        }

        int position = count - nth -1;
        previous = list.getHead();
        count = 0;
        while (previous != null) {
            previous = previous.getNextNode();
            count++;
            if (count == position) {
                break;
            }
        }

        Node tmp = list.getHead().getNextNode();
        Node next = previous.getNextNode();
        Node nextnext = next.getNextNode();

        previous.setNextNode(list.getHead());
        list.getHead().setNextNode(nextnext);
        next.setNextNode(tmp);
        list.setHead(next);

    }

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







