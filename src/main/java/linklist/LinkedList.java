package linklist;

class LinkedList{}



/*class reverseEven{
    // Helper function to merge two lists.
    public static LinkedListNode merge_alternating(
            LinkedListNode list1,
            LinkedListNode list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        LinkedListNode head = list1;

        while (list1.next != null &&
                list2 != null) {
            LinkedListNode temp = list2;
            list2 = list2.next;

            temp.next = list1.next;
            list1.next = temp;
            list1 = temp.next;
        }

        if (list1.next == null) {
            list1.next = list2;
        }

        return head;
    }

    public static LinkedListNode reverse_even_nodes(
            LinkedListNode head) {

        // Let's extract even nodes from the existing
        // list and create a new list consisting of
        // even nodes. We will push the even nodes at
        // head since we want them to be in reverse order.

        LinkedListNode curr = head;
        LinkedListNode list_even = null;

        while (curr != null &&
                curr.next != null) {
            LinkedListNode even = curr.next;
            curr.next = even.next;

            // Push at the head of new list.
            even.next = list_even;
            list_even = even;

            curr = curr.next;
        }

        // Now, merge the two lists
        // Original: 1,2,3,4,5
        // Modified original: 1,3,5
        // List_even: 4,2
        // Merged: 1,4,3,2,5

        return merge_alternating(head, list_even);
    }
    /// Test Program.
    public static void main(String[] args) {

        int[] list1 = {1, 2, 3, 4, 5};
        int[] list1_expected = {1, 4, 3, 2, 5};
        LinkedListNode list_head1 = LinkedList.create_linked_list(list1);
        LinkedListNode list_head1_expected = LinkedList.create_linked_list(list1_expected);
        System.out.print("Original: ");
        LinkedList.display(list_head1);
        list_head1 = reverse_even_nodes(list_head1);
        System.out.print("After Reverse:");
        LinkedList.display(list_head1);
        System.out.printf("Equal check: >>>%b<<<\n\n", LinkedList.is_equal(list_head1, list_head1_expected));

        //test2
        int[] list2 = {1, 2, 3, 4};
        int[] list2_expected = {1, 4, 3, 2};
        LinkedListNode list_head2 = LinkedList.create_linked_list(list2);
        LinkedListNode list_head2_expected = LinkedList.create_linked_list(list2_expected);
        System.out.print("Original: ");
        LinkedList.display(list_head2);
        list_head2 = reverse_even_nodes(list_head2);
        System.out.print("After Reverse:");
        LinkedList.display(list_head2);
        System.out.printf("Equal check: >>>%b<<<\n", LinkedList.is_equal(list_head2, list_head2_expected));
    }
}*/