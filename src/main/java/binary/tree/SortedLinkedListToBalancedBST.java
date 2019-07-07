package binary.tree;

//Given a Singly Linked List which has data members sorted in ascending order.
// Construct a Balanced Binary Search Tree which has same data members as the given Linked List.

/*
In this approach we will start creating Tree from Bottom to Up.
Root Node of Tree will be created at last.

Logic is to first calculate the size of List and once size of Linked List is identified,
Repeat the same step as we did in first approach, but instead of identifying the middle node, we will divide the list (length of list/2) into 2 parts recursively into left side and right side. (Postpone creation of node at last, so that leaf nodes that is bottom nodes are created first and then top nodes)
By breaking the list into 2 parts recursively, at one point we will left by only one node and that will be leaf node, create a Tree node by that element and return a node to previous recursive call.
*/

public class SortedLinkedListToBalancedBST {
    static LinkedListNode head;

    private static int getLengthOfLinkedList(LinkedListNode list){
        if(list==null){
            return 0;
        }
        int count = 1;
        while((list = list.getNext()) != null){
            count++;
        }
        return count;
    }

    private static Node sortedLinkedListToBST(int length){
        if(length <= 0){
            return null;
        }

        Node left = sortedLinkedListToBST(length/2);

        Node root = new Node(head.getData());
        root.setLeftNode(left);

        head = head.getNext();

        root.setRightNode(sortedLinkedListToBST(length - length/2 - 1));
        return root;
    }

    public static void main(String[] args) {
        head = new LinkedListNode(1);
        LinkedListNode lln2 = new LinkedListNode(2);
        LinkedListNode lln3 = new LinkedListNode(3);
        LinkedListNode lln4 = new LinkedListNode(4);
        LinkedListNode lln5 = new LinkedListNode(5);
        LinkedListNode lln6 = new LinkedListNode(6);
        LinkedListNode lln7 = new LinkedListNode(7);

        head.setNext(lln2);
        lln2.setNext(lln3);
        lln3.setNext(lln4);
        lln4.setNext(lln5);
        lln5.setNext(lln6);
        lln6.setNext(lln7);

        Node balancedBSTBottomUp = sortedLinkedListToBST(getLengthOfLinkedList(head));
        System.out.println("hi");

    }

}
