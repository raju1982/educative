package linklist;

//import linklist.tmp.Node;

import java.util.HashSet;
import java.util.Set;

public class removeDuplicates {
/*
    public static void removeDuplicate2(Node input) {

        Node currentNode = input.getNextNode();
        Node prevNode = input;

        //To store values of nodes which we already visited
        HashSet<Integer> visitedNodes = new HashSet<>();

        if (currentNode.getNextNode() != null) {

            while (currentNode != null) {
                Integer value = new Integer(currentNode.getData());

                if (visitedNodes.contains(value)) {
                    prevNode.setNextNode(currentNode.getNextNode());
                    currentNode = currentNode.getNextNode();
                    continue;
                }

                visitedNodes.add(currentNode.getData()); //Visiting currentNode for first time
                prevNode = currentNode;
                currentNode = currentNode.getNextNode();
            }
        }
    }

    public static void removeDuplicate(Node input){
        Set<Integer> data = new HashSet<Integer>();

        Node previous = input;
        Node current = input;

        while(current != null){
            if(data.contains(current.getData())){
                previous.setNextNode(current.getNextNode());
                current = previous.getNextNode();
            }
            else{
                data.add(current.getData());
                previous=current;
                current = current.getNextNode();
            }
        }
    }
*/
    public static void removeDuplicateNode(Node input) {
        Set<Integer> data = new HashSet<>();
        Node previous = null;
        while (input != null) {
            int tmp = input.getData();
            if (data.contains(tmp)) {
                previous.setNextNode(input.getNextNode());
            } else {
                data.add(tmp);
            }
            previous = input;
            input = input.getNextNode();
        }
    }


    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(10);
        Node c = new Node(8);
        Node d = new Node(12);
        Node e = new Node(12);
        Node f = new Node(2);
        Node g = new Node(2);
        a.setNextNode(b);
        b.setNextNode(c);
        c.setNextNode(d);
        d.setNextNode(e);
        e.setNextNode(f);
        f.setNextNode(g);

        //removeDuplicate2(a);

        removeDuplicateNode(a);

        System.out.println("hi");
    }
}
