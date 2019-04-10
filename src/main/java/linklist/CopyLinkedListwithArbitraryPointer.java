package linklist;

import java.util.Hashtable;

class arbitraryPointer{
    public static LinkedListNode deep_copy_arbitrary_pointer(LinkedListNode head) {

        if (head == null) {
            return null;
        }

        LinkedListNode current = head;
        LinkedListNode new_head = null;
        LinkedListNode new_prev = null;
        Hashtable<LinkedListNode, LinkedListNode> map =
                new Hashtable<LinkedListNode,LinkedListNode>();

        //In the first pass, create a copy of the original linked list.
        // While creating this copy, use the same values for data and arbitrary_pointer in the new list.
        while (current != null) {
            //copy node with data
            LinkedListNode new_node = new LinkedListNode(current.data);

            // copy the old arbitrary pointer in the new node
            new_node.arbitrary_pointer = current.arbitrary_pointer;

            if (new_prev != null) {
                new_prev.next = new_node;
            }
            else {
                new_head = new_node;
            }
            // keep updating the map with entries where the key is the address to the old node and the value is the address of the new node.
            map.put(current,new_node);

            new_prev = new_node;
            current = current.next;
        }

        LinkedListNode new_current = new_head;

        //another pass on the copied linked list and update arbitrary pointers to the new address using the map created in the first pass.
        // updating arbitrary_pointer
        while (new_current != null) {
            if (new_current.arbitrary_pointer != null) {
                LinkedListNode node =
                        map.get(new_current.arbitrary_pointer);

                new_current.arbitrary_pointer = node;
            }

            new_current = new_current.next;
        }

        return new_head;
    }
    /// Test Program.
    public static void main(String[] args) {
        LinkedListNode node3 = new LinkedListNode(
                3, null, null);
        LinkedListNode node2 = new LinkedListNode(
                2, node3, null);
        LinkedListNode node1 = new LinkedListNode(
                1, node2, node3);
        LinkedListNode list_head = new LinkedListNode(
                0, node1, node2);

        //list_head -> node1 -> node2 -> node3

        LinkedListNode list_head_2 =
                deep_copy_arbitrary_pointer(list_head);

        System.out.print("Original: ");
        //LinkedList.display(list_head);

        System.out.print("Copied: ");
        //LinkedList.display(list_head_2);
    }
}


class LinkedListNode{
    int data;
    LinkedListNode next;
    LinkedListNode arbitrary_pointer;
    
    public LinkedListNode(int data){
        this.data = data;
    }

    public LinkedListNode(int data, LinkedListNode node, LinkedListNode arbitraryPointer){
        this.data = data;
        this.next = node;
        this.arbitrary_pointer = arbitraryPointer;
    }

    public void setData(int data){
        this.data = data;
    }

    public int getData(){
        return data;
    }

    public void setNextNode(LinkedListNode node){
        this.next = node;
    }

    public LinkedListNode getNextNode(){
        return next;
    }
}