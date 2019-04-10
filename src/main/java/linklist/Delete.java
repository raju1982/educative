package linklist;

//import linklist.tmp.Node;

public class Delete {

    //remove all nodes
    public static void delete2(Node input, int val){
        Node prev=null;
        Node current = input;

        while(current !=null){

            if(current.getData() == val){
                prev.setNextNode(current.getNextNode());
            }
            else{
                prev=current;
            }
            current = current.getNextNode();
        }


    }

    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(10);
        Node c = new Node(8);
        Node d = new Node(12);
        Node e = new Node(10);
        Node f = new Node(2);
        a.setNextNode(b);
        b.setNextNode(c);
        c.setNextNode(d);
        d.setNextNode(e);
        e.setNextNode(f);

        //delete(10, a);
        delete2(a, 10);
        System.out.println("");
    }
}
