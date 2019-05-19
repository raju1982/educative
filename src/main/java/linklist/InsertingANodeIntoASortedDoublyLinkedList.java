package linklist;

public class InsertingANodeIntoASortedDoublyLinkedList {
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode sol = head;
        while(head != null){
            if(head.data > data){
                break;
            }
            head = head.next;
        }

        DoublyLinkedListNode input = new DoublyLinkedListNode();
        input.data = data;

        DoublyLinkedListNode prevNode = head.prev;
        prevNode.next = input;
        input.prev = prevNode;
        input.next = head;
        head.prev = input;

        return sol;
    }


    public static void main(String[] args){
        DoublyLinkedListNode a = new DoublyLinkedListNode();
        a.data = 1;
        DoublyLinkedListNode b = new DoublyLinkedListNode();
        b.data = 3;
        DoublyLinkedListNode c = new DoublyLinkedListNode();
        c.data = 4;
        DoublyLinkedListNode d = new DoublyLinkedListNode();
        d.data = 10;

        a.next = b;
        b.next = c;
        c.next = d;

        b.prev = a;
        c.prev = b;
        d.prev = c;

        DoublyLinkedListNode sol = sortedInsert(a, 5);
        System.out.println("");
    }
}

class DoublyLinkedListNode {
    int data;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;
}