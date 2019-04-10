class linkedList {

    //Constructor - Initializing Head Node
    linkedList() {
        headNode = new Node();
    }

    //Function inserts a value/new Node as the first Element of list
    public void insertAtHead(int value) {
        Node newNode = new Node();
        newNode.data = value;
        newNode.nextElement = headNode.nextElement; //Linking newNode to head's nextNode
        headNode.nextElement = newNode;

        System.out.println(value + " Inserted !");
        printList();
    }

    //Helper Function that checks if List is empty or not
    public boolean isEmpty() {

        if (headNode.nextElement == null) return true;
        return false;
    }

    // Helper Function to printList
    public boolean printList() {

        if (isEmpty()) {
            System.out.println("List is Empty");
            return false;
        }

        Node temp = headNode.nextElement;
        System.out.print("List : ");

        while (temp.nextElement != null) {
            System.out.print(temp.data + "->");
            temp = temp.nextElement;
        }

        System.out.println(temp.data + "->null");
        return true;

    }

    public static void main(String args[]) {
        linkedList list = new linkedList();
        list.printList();
        for (int i = 1; i <= 10; i++) {
            list.insertAtHead(i);
        }

    }
    private Node headNode;

    static class Node {
        int data;
        Node nextElement;
    }
}
