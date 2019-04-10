package linklist;

public class AddTwoInteger {

    public static Linklist300 add(Linklist300 inputA, Linklist300 inputB){

        if(inputA==null && inputB==null){
            throw new IllegalArgumentException();
        }

        if(inputA==null){
            return inputB;
        }

        if(inputB==null){
            return inputA;
        }
        int carryOver=0;
        int insertVal=0;
        Linklist300 result = new Linklist300();
        Node tmpA=inputA.head;
        Node tmpB=inputB.head;

        while(tmpA!=null || tmpB!=null){
            int valA = tmpA == null ?0 : tmpA.getData();
            int valB = tmpB == null ?0 : tmpB.getData();
            insertVal =  (valA+valB+carryOver)%10;
            carryOver = (valA+valB+carryOver)/10;
            result.insertAtEnd(insertVal);
            if(tmpA!=null) {
                tmpA = tmpA.getNextNode();
            }
            if(tmpB!=null) {
                tmpB = tmpB.getNextNode();
            }
        }

        if(carryOver>0){
            result.insertAtEnd(carryOver);
        }

        return result;
    }

    public static void main(String[] args){
        Linklist300 first = new Linklist300();
        first.insertAtEnd(1);
        first.insertAtEnd(0);
        first.insertAtEnd(9);
        first.insertAtEnd(9);

        Linklist300 second = new Linklist300();
        second.insertAtEnd(7);
        second.insertAtEnd(3);
        second.insertAtEnd(2);

        Linklist300 result = add(first, second);
        System.out.println(result);
    }

}



class Linklist300{
    Node head;

    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node tmp = head;
        while(tmp.getNextNode()!=null){
            tmp = tmp.getNextNode();
        }
        tmp.setNextNode(newNode);
    }
}