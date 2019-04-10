package linklist;

// Java program to detect and remove loop in linked list

class DetectAndRemoveLoop {

    public static void detectLoop(Node input){

        Node first = input;
        Node second = input;

        while(second!=null){
            first = first.getNextNode();
            second = second.getNextNode();
            if(second!=null){
                second = second.getNextNode();
            }
            if(first == second){
                break;
            }
        }

        if(second == null){
            return;
        }

        second = input;

        while(first!=second){
            first = first.getNextNode();
            second = second.getNextNode();
            if(first.getNextNode() == second.getNextNode()){
                first.setNextNode(null);
                return;
            }
        }

    }

    public static void main(String[] args){
        Node A = new Node(7);
        Node B = new Node(14);
        Node C = new Node(21);
        Node D = new Node(25);
        Node E = new Node(30);
        Node F = new Node(35);
        A.setNextNode(B);
        B.setNextNode(C);
        C.setNextNode(D);
        D.setNextNode(E);
        E.setNextNode(F);
        F.setNextNode(C);

        detectLoop(A);
        System.out.println("hello");
    }

}

// This code has been contributed by Mayank Jaiswal
