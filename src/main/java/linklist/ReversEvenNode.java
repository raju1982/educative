package linklist;
//https://www.geeksforgeeks.org/given-linked-list-reverse-alternate-nodes-append-end/
public class ReversEvenNode {

    public static LinkListPlay oddEven(LinkListPlay input) {

        // If linked list has less than 3 nodes, no change is required
        if (input == null || input.getHead() == null || input.getHead().getNextNode() == null) {
            return input;
        }

        Node node = input.getHead();
        Node prev = null;
        LinkListPlay evenData = new LinkListPlay();
        int count = 1;

        while (node != null) {
            if (count % 2 == 0) {
                evenData.insertAtHead(new Node(node.getData()));
                prev.setNextNode(node.getNextNode());
            }
            prev = node;
            node = node.getNextNode();
            count++;

        }

        return mergeNode(input, evenData);
        //System.out.println("");
    }


    public static LinkListPlay mergeNode(LinkListPlay input, LinkListPlay evenData){
        Node inputDataNode = input.getHead();
        Node evenDataNode = evenData.getHead();
        LinkListPlay result = new LinkListPlay();
        int count = 1;

        while(inputDataNode!=null && evenDataNode!=null){
            //Node tmp = inputDataNode.getNextNode();
            if (count % 2 == 0) {
                result.insertAtEnd(new Node(evenDataNode.getData()));
                evenDataNode = evenDataNode.getNextNode();
            }
            else{
                result.insertAtEnd(new Node(inputDataNode.getData()));
                inputDataNode = inputDataNode.getNextNode();
            }
            count++;
        }

        while(inputDataNode!=null){
            result.insertAtEnd(new Node(inputDataNode.getData()));
            inputDataNode = inputDataNode.getNextNode();
        }

        while(evenDataNode!=null){
            result.insertAtEnd(new Node(evenDataNode.getData()));
            evenDataNode = evenDataNode.getNextNode();
        }

        return result;
    }

    public static void main(String[] args) {
        LinkListPlay list = new LinkListPlay();
        for (int i = 1; i <= 10; i++) {
            list.insertAtEnd(new linklist.Node(i));
        }
        System.out.println(list.toString());
        LinkListPlay ls = oddEven(list);
        System.out.println(ls.toString());
    }
}
