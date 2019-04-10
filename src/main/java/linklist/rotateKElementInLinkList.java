package linklist;

public class rotateKElementInLinkList {

    public static int count(Linklist200 input){
        Node tmp = input.head;
        int count = 0;
        while(tmp != null){
            count++;
            tmp=tmp.getNextNode();
        }
        return count;
    }

    public static int trueIndex(int input, int count){
        input = input%count;
        if(input<0){
            input = input+count;
        }
        return  input;
    }

    public static void rotateLinkList(Linklist200 input, int length){
        int count = count(input);
        int trueIndex = trueIndex(length, count);

        //elemnt till this index will not change.
        int index = count-trueIndex;

        //find last element
        Node tmp = input.head;
        count = 1;
        while(count!=index){
            tmp = tmp.getNextNode();
            count++;
        }

        Node newHead = tmp.getNextNode();
        tmp.setNextNode(null);

        Node tmp3 = newHead;
        while(tmp3.getNextNode() != null){
            tmp3=tmp3.getNextNode();
        }

        tmp3.setNextNode(input.head);
        input.head = newHead;
    }

    public static void main(String[] args){
        Linklist200 data = new Linklist200();
        data.insertAtEnd(1);
        data.insertAtEnd(2);
        data.insertAtEnd(3);
        data.insertAtEnd(4);
        data.insertAtEnd(5);
        data.insertAtEnd(6);

        rotateLinkList(data, 3);

        System.out.println("hello");
    }


}


class Linklist200{
    Node head;

    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node tmp = head;
        while(tmp.getNextNode()!=null){
            tmp = tmp.getNextNode();
        }
        tmp.setNextNode(newNode);
    }
}
