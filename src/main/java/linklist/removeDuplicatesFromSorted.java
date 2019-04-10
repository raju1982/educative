package linklist;

//import linklist.tmp.Node;

import java.util.HashSet;
// Java program to remove duplicates from a sorted linked list
//duplicate elemnt are next to each other (sorted or unsorted)
class removeDuplicatesFromSorted
{
    public static void removeDuplicate(Node input){
        if(input==null){
            return;
        }

        Node current =input;

        while(current.getNextNode() != null){
            if(current.getData() == current.getNextNode().getData()){
                current.setNextNode(current.getNextNode().getNextNode());
            }
            else{
                current = current.getNextNode();
            }
        }
    }

    public static void main(String[] args){
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

        removeDuplicate(a);
        System.out.println("hi");
    }
}
/* This code is contributed by Rajat Mishra */
