package linklist;

public class AddTwoInteger {


    /*

    package linklist.play;

public class Test{

    public static Node sum(Node a, Node aa){
        //both are null -> throw new IllegalArgumentException();

        if(a==null){
            return aa;
        }
        if(aa==null){
            return a;
        }

        Node result = null;
        Node solution = null;
        int left = 0;
        while(a!= null && aa!=null){
            Node tmp = new Node((a.getData() + aa.getData()+left)%10);
            left = (a.getData() + aa.getData() + left)/10;
            if(result == null){
                result = tmp;
                solution =  result;
            }
            else{
                result.setNextNode(tmp);
                result = result.getNextNode();
            }
            a = a.getNextNode();
            aa = aa.getNextNode();
        }

        while(a!=null){
            Node tmp = new Node((a.getData()+left)%10);
            left = (a.getData() + left)/10;
            result.setNextNode(tmp);
            result = result.getNextNode();
            a = a.getNextNode();
        }

        while(aa!=null){
            Node tmp = new Node((aa.getData()+left)%10);
            left = (aa.getData()+left)/10;
            result.setNextNode(tmp);
            result = result.getNextNode();
            aa = aa.getNextNode();
        }

        if(left!=0){
            Node tmp = new Node(left%10);
            result.setNextNode(tmp);
        }

        return solution;
    }


    public static void main(String[] args){

    Node a = new Node(7);
    Node b = new Node(5);
    Node c = new Node(9);
    Node d = new Node(9);
    Node e = new Node(9);

        a.setNextNode(b);
        b.setNextNode(c);
        c.setNextNode(d);
        d.setNextNode(e);

    Node aa = new Node(8);
    Node bb = new Node(4);
        aa.setNextNode(bb);

    Node result = sum(a, aa);

        while(result != null){
        System.out.println(result.getData());
        result = result.getNextNode();
    }
}
}

class Node{
    private int data;
    private Node nextNode;

    public Node(int data){
        this.data =  data;
    }

    public void setNextNode(Node nextNode){
        this.nextNode = nextNode;
    }

    public int getData(){
        return this.data;
    }

    public Node getNextNode(){
        return this.nextNode;
    }
}











     */





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