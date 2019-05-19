package linklist;

public class InsertaNodeAtaSpecificPositionInaLinkedList {

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {

        int count = 0;
        SinglyLinkedListNode result = head;
        SinglyLinkedListNode prev = null;
        while(head.next != null){
            if(count == position){
                break;
            }
            prev = head;
            head = head.next;
            count = count + 1;
        }
        SinglyLinkedListNode newNode = new SinglyLinkedListNode();
        newNode.data = data;
        prev.next = newNode;
        newNode.next = head;

        return result;
    }


    public static void main(String[] args){
        SinglyLinkedListNode a = new SinglyLinkedListNode();
        a.data = 16;
        SinglyLinkedListNode b = new SinglyLinkedListNode();
        b.data = 13;
        SinglyLinkedListNode c = new SinglyLinkedListNode();
        c.data = 7;

        a.next = b;
        b.next = c;

        SinglyLinkedListNode sol = insertNodeAtPosition(a, 1, 2);
        System.out.println(sol.next.next.data);
    }

}

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;
}
