package linklist;
import java.util.Stack;


public class reverseKElement {


    //better solution
    public static Node reverse(Node input, int count){

        Node tmp = input;
        Stack<Integer> data = new Stack<>();

        while(count>0){
            data.push(tmp.getData());
            tmp = tmp.getNextNode();
            count--;
        }

        Node current = new Node(data.pop());
        Node result = current;
        Node prev = current;
        while(!data.isEmpty()){
            current = new Node(data.pop());
            if(prev != null){
                prev.setNextNode(current);
            }
            prev = current;
        }
        current.setNextNode(tmp);
        return result;
    }


    public static void reverseKElement(linklist10 input, int num){
        if(input == null || num<=0){
            throw new IllegalArgumentException();
        }

        if(num == 1){
            return;
        }

        Node lastNode = input.head;
        int count=1;

        while(lastNode!=null){
            lastNode=lastNode.getNextNode();
            if(count==num){
                break;
            }
            count++;
        }

        if(count<num){
            throw new IllegalArgumentException();
        }

        Node previous = lastNode; //(4)
        Node tmp = input.head; //(1)
        Node nextNode;

        while(tmp!=lastNode){
            nextNode = tmp.getNextNode(); //(2) | (3) | (4)
            tmp.setNextNode(previous); //(1->4) | (2->1) | (3->2)
            input.head=tmp; //(1->4->5) (2->1->4->5) | (3->2->1->4->5)
            previous=tmp; //(1) (2) (3)
            tmp=nextNode; //(2) (3) (4)
        }
    }

    public static void main(String[] args){
        linklist10 data = new linklist10();
        data.insertAtEnd(1);
        data.insertAtEnd(2);
        data.insertAtEnd(3);
        data.insertAtEnd(4);
        data.insertAtEnd(5);
        data.insertAtEnd(6);

        reverseKElement(data, 3);

        System.out.println("hello");
    }
}





class linklist10{
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

