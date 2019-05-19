package linklist;

/*
Given a singly linked list, rotate the linked list counter-clockwise by k nodes. Where k is a given positive integer.
For example, if the given linked list is 10->20->30->40->50->60 and k is 4, the list should be modified to 50->60->10->20->30->40.
Assume that k is smaller than the count of nodes in linked list.
 */
public class rotateKElementInLinkListCounterClockwise {

    public static Node reverseNode(Node input, int rotateValue){
        Node head = input;

        while(head!=null){
            if(rotateValue == 1){
                break;
            }
            rotateValue --;
            head = head.getNextNode();
        }

        Node tmp = head.getNextNode();
        Node sol = tmp;
        head.setNextNode(null);

        while(tmp.getNextNode()!=null){
            tmp = tmp.getNextNode();
        }

        tmp.setNextNode(input);

        return sol;
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

        Node head = reverseNode(a, 4);

        System.out.println("");
    }


}



