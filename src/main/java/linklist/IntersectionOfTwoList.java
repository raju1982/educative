package linklist;

public class IntersectionOfTwoList {
    public static Node intersection(Node inputA, Node inputB){

        Node first = inputA;
        Node second = inputB;
        int countA = 0;
        int countB = 0;

        while(first.getNextNode()!=null){
            first = first.getNextNode();
            countA++;
        }

        while(second.getNextNode()!=null){
            second = second.getNextNode();
            countB++;
        }

        if(first!=second){
            return null;
        }

        Node longest = countA>countB ? inputA : inputB;
        Node smallest = countA<countB ? inputA : inputB;

        countA = Math.abs(countA-countB);
        countB = 0;

        while(countB<countA){
            longest = longest.getNextNode();
            countB++;
        }

        while(longest!=null){
            if(smallest == longest){
                return smallest;
            }
            smallest = smallest.getNextNode();
            longest = longest.getNextNode();
        }

        return null;

    }

    public static void main(String[] args){
        Node A = new Node(29);
        Node B = new Node(23);
        Node C = new Node(82);
        Node D = new Node(11);
        Node E = new Node(12);
        Node F = new Node(27);
        A.setNextNode(B);
        B.setNextNode(C);
        C.setNextNode(D);
        D.setNextNode(E);
        E.setNextNode(F);


        Node AA = new Node(13);
        Node BB = new Node(4);
        AA.setNextNode(BB);
        BB.setNextNode(E);

        Node result = intersection(A, AA);
        System.out.println("hello");
    }

}
