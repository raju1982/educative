package linklist;

public class NthNodeFromEnd {

    public static linklist.Node NthNode(LinkListPlay list, int nth){
        Node current = list.getHead();
        int count = 0;

        while(current!=null){
            current = current.getNextNode();
            count++;
        }

        int position = count - nth;
        current = list.getHead();
        count = 0;
        while(current!=null){
            current = current.getNextNode();
            count++;
            if(count == position){
                break;
            }
        }
        return current;
    }

    public static void main(String[] args) {
        LinkListPlay list = new LinkListPlay();
        for (int i = 1; i <= 10; i++) {
            if (i == 2) {
                list.insertAtEnd(new Node(1));
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
        Node res = NthNode(list, 3);
        System.out.println("hi");

    }
}
