package linklist;

public class MergeSortedList {
    public static Node mergeSortString(Node inputA, Node inputB){
        if(inputA==null){
            return inputB;
        }
        if(inputB==null){
            return inputA;
        }
        Node result = null;
        if(inputA.getData()<inputB.getData()){
            result = inputA;
            result.setNextNode(mergeSortString(inputA.getNextNode(), inputB));
        }
        else{
            result = inputB;
            result.setNextNode(mergeSortString(inputA, inputB.getNextNode()));
        }
        return result;
    }

    public static void main(String[] args){
        Node A = new Node(11);
        Node B = new Node(23);
        Node C = new Node(29);
        Node D = new Node(32);
        A.setNextNode(B);
        B.setNextNode(C);
        C.setNextNode(D);

        Node AA = new Node(10);
        Node BB = new Node(25);
        Node CC = new Node(27);
        Node DD = new Node(33);
        AA.setNextNode(BB);
        BB.setNextNode(CC);
        CC.setNextNode(DD);

        Node result = mergeSortString(A, AA);
        System.out.println("hello");
    }

}

