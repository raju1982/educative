package linklist.play;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class FunctionImpl {

    public static void reverse(LInkedListImpl list){
        Node next = list.head;;
        Node previous = null;
        while(next!=null){
            Node tmp = next.getNextNode();
            next.setNextNode(previous);
            list.head = next;
            previous = next;
            next = tmp;
        }
    }

    public static void reverse100(LInkedListImpl list){
        Node previous=null;
        Node tmp=list.head;
        while(tmp!=null){
            Node tmp2=tmp.getNextNode();
            tmp.setNextNode(previous);
            list.head=tmp;
            previous = tmp;
            tmp=tmp2;
        }

    }

    // reverse -> create new link list and use insertAtHead;


    public static int count(LInkedListImpl list){
        Node tmp = list.head.getNextNode();
        int len = 0;
        while(tmp != null){
            len++;
            tmp = tmp.getNextNode();
        }
        return len;
    }

    public static int findNodeFromEnd(LInkedListImpl list, int locationFromLast){
        if(list==null){
            throw new IllegalArgumentException();
        }
        System.out.println(list.toString());
        int count=count(list);

        int location = count - locationFromLast;

        count=0;
        Node node = list.head;
        while(count!=location){
            count++;
            node = node.getNextNode();
        }

        return node.getData();

    }

    public static Node findNodeFromEnd2(LInkedListImpl list, int locationFromLast){
        if (list == null || locationFromLast < 1) {
            return null;
        }

        Node pointer = list.head;
        Node bigPointer = list.head;

        int count = locationFromLast;
        while (count >= 1 ) {
            bigPointer = bigPointer.getNextNode();
            count--;
        }

        while(bigPointer.getNextNode()!=null){
            pointer = pointer.getNextNode();
            bigPointer = bigPointer.getNextNode();
        }

        return pointer;
    }


    public static void swapNodeFromEndWithHead(LInkedListImpl list, int locationFromLast){
        if(list ==null && locationFromLast<1){
            //error
        }
        //count nodes
        Node pointer=list.head.getNextNode();
        int count=0;
        while(pointer!=null){
            count++;
            pointer=pointer.getNextNode();
        }

        if(locationFromLast>count){
            throw new IllegalArgumentException();
        }

        locationFromLast++;

        if(locationFromLast>count){
            return;
        }

        count=locationFromLast;
        Node firstPointer=list.head;
        Node secondPointer=list.head;

        while(count>0){
            firstPointer=firstPointer.getNextNode();
            count--;
        }

        while(firstPointer.getNextNode()!=null){
            firstPointer=firstPointer.getNextNode();
            secondPointer=secondPointer.getNextNode();
        }

        Node tmp=secondPointer.getNextNode();
        Node tmp4=secondPointer.getNextNode().getNextNode();
        Node tmp2=list.head.getNextNode();
        Node tmp3 = list.head;

        list.head=tmp;
        list.head.setNextNode(tmp2);
        secondPointer.setNextNode(tmp3);
        tmp3.setNextNode(tmp4);
    }


    /*
    LinkedListNode* find_nth_from_last(
    LinkedListNode* head,
    int n) {

  if (head == nullptr || n < 1) {
    return nullptr;
  }

  // We will use two pointers head and tail
  // where head and tail are 'n' nodes apart.
  LinkedListNode* tail = head;

  while (tail != nullptr && n > 0) {
    tail = tail->next;
    --n;
  }

  // Check out-of-bounds
  if (n != 0) {
    return nullptr;
  }

  // When tail pointer reaches the end of
  // list, head is pointing at nth node.
  while (tail != nullptr) {
    tail = tail->next;
    head = head->next;
  }

  return head;
}

int main(int argc, char* argv[]) {
  LinkedListNode* list_head = nullptr;
  list_head = LinkedList::create_random_list(10);
  printf("Original: ");
  LinkedList::display(list_head);

  LinkedListNode* temp;

  temp = find_nth_from_last(list_head, 5);
  printf("\nResult for n=5 is %d", temp->data);

  temp = find_nth_from_last(list_head, 6);
  printf("\nResult for n=6 is %d", temp->data);

  temp = find_nth_from_last(list_head, 4);
  printf("\nResult for n=4 is %d", temp->data);

  temp = find_nth_from_last(list_head, 10);
  printf("\nResult for n=10 is %d", temp->data);

  temp = find_nth_from_last(list_head, 1);
  printf("\nResult for n=1 is %d", temp->data);

  temp = find_nth_from_last(list_head, 0);
  printf("\nResult for n=0 is nullptr - %s", (temp == nullptr)? "Success" : "Failure");

  temp = find_nth_from_last(list_head, 11);
  printf("\nResult for n=11 is nullptr - %s", (temp == nullptr)? "Success" : "Failure");
}
     */



    public static void swapNodeWithHead(LInkedListImpl list, int position){

        //list == null
        //position <1
        //position greate than length

        Node current=list.head;
        Node previous = null;
        int count = 1;

        while(count<=position){
            previous=current;
            current=current.getNextNode();
            count++;
        }

        Node tmp=current.getNextNode();
        Node tmp2=list.head.getNextNode();

        previous.setNextNode(list.head);
        list.head.setNextNode(tmp);
        list.head=current;
        current.setNextNode(tmp2);
    }

    public static void removeDuplicateFromSorted(LInkedListImpl list){
        //null check
        Node previous=null;
        Node current=list.head;

        while(current.getNextNode()!=null){
            if(current.getData() == current.getNextNode().getData()){
                current.setNextNode(current.getNextNode().getNextNode());
                continue;
            }
            current = current.getNextNode();
        }
    }


    public static void revertEvenNode(LInkedListImpl list){
        //System.out.println(list.toString());
        LInkedListImpl oddList = new LInkedListImpl();
        LInkedListImpl evenList = new LInkedListImpl();
        Node tmp = list.head;
        int count=1;
        while(tmp!=null){
            if(count%2==0){
                evenList.addAtHead(tmp.getData());
            }
            else {
                oddList.addNode(tmp.getData());
            }
            tmp=tmp.getNextNode();
            count++;
        }

        //System.out.println(oddList.toString());
        //System.out.println(evenList.toString());
        //merge link list
        Node tmpOdd=oddList.head;
        Node tmpEven=evenList.head;

        while(tmpOdd!=null && tmpEven!=null){
            Node tmp2=tmpOdd.getNextNode();
            Node data=new Node(tmpEven.data);
            tmpOdd.setNextNode(data);
            data.setNextNode(tmp2);
            tmpEven = tmpEven.getNextNode();
            tmpOdd = tmpOdd.getNextNode().getNextNode();
        }

        list.head=oddList.head;

    }

    public static void detectAndRemoveLoop(Node input){

        if(input == null){
            throw new IllegalArgumentException();
        }

        Node slowNode = input.getNextNode();
        Node fastNode = input.getNextNode().getNextNode();

        while(fastNode!=null){
            if(fastNode==slowNode){
                break;
            }
            slowNode=slowNode.getNextNode();
            if(fastNode.getNextNode()==null){
                return;
            }
            fastNode=fastNode.getNextNode().getNextNode();
        }

        slowNode = input;
        while(fastNode.getNextNode() != slowNode.getNextNode()) {
            slowNode=slowNode.getNextNode();
            fastNode=slowNode.getNextNode();
        }

        slowNode.setNextNode(null);
    }


   public static String toString(Node head){
           StringBuilder result = new StringBuilder();
           Node tmp = head;
           while(tmp != null){
               result.append(tmp.getData() + "->");
               tmp = tmp.getNextNode();
           }
           return result.toString();
     }


    public static boolean palindrome(NodeX input){

        if(input == null){
            throw new IllegalArgumentException();
        }

        if(input.getNextNode()==null){
            return true;
        }

        Stack<String> data = new Stack<>();

        NodeX tmp = input;

        while(tmp!=null){
            data.push(tmp.getData());
            tmp=tmp.getNextNode();
        }

        tmp = input;
        while(tmp!=null){
            if(data.pop() != tmp.getData()){
                return false;
            }
            tmp=tmp.getNextNode();
        }
        return true;
    }

    public static Node intersectionOfLinklist(Node inputA, Node inputB){

        if(inputA==null || inputB==null){
            throw new IllegalArgumentException();
        }

        Node tmpA = inputA;
        int countA = 1;

        while(tmpA!=null){
            countA++;
            tmpA=tmpA.getNextNode();
        }

        Node tmpB = inputB;
        int countB = 1;

        while(tmpB!=null){
            countB++;
            tmpB=tmpB.getNextNode();
        }

        int diff = countA-countB;

        Node longer = countA > countB ? inputA : inputB;
        Node shorter = countA > countB ? inputB : inputA;

        while(diff>0){
            diff--;
            longer = longer.getNextNode();
        }

        while(longer!=shorter){
            longer = longer.getNextNode();
            shorter = shorter.getNextNode();
        }

        return longer;
    }



    public static LinkList mergeSortedLinklist(LinkList inputA, LinkList inputB){

        LinkList result = new LinkList();
        Node tmpA = inputA.head;
        Node tmpB = inputB.head;

        while(tmpA!=null && tmpB!=null){
            if(tmpA.getData() < tmpB.getData() ){
                result.addData(tmpA.getData());
                tmpA = tmpA.getNextNode();
            }
            else{
                result.addData(tmpB.getData());
                tmpB = tmpB.getNextNode();
            }
        }

        while(tmpA!=null){
            result.addData(tmpA.getData());
            tmpA = tmpA.getNextNode();
        }

        while(tmpB!=null){
            result.addData(tmpB.getData());
            tmpB = tmpB.getNextNode();
        }
        return result;
    }






    public static void main(String[] args){
        LInkedListImpl list = new LInkedListImpl();

        for (int i = 1; i <= 10; i++) {
            list.addNode(i);
        }

        //System.out.println(list.toString());
        //reverse100(list);
        //System.out.println(list.toString());


        //list.insertAfterNode(5, 50);
        System.out.println(list.toString());
        System.out.println(count(list));

        list = new LInkedListImpl();
        for (int i = 1; i <= 2; i++) {
            list.addNode(i);
        }
        System.out.println(count(list));


/*
        System.out.println(list.search(5));
        System.out.println(list.search(15));

        System.out.println(list.delete(5));
        System.out.println(list.delete(10));
        System.out.println(list.toString());
        System.out.println(list.delete(100));

        System.out.println(list.mid());
        System.out.println(list.mid2());

        list.insertAfterNode(4, 4);
        list.insertAfterNode(9, 9);
        list.insertAfterNode(7, 2);
        System.out.println(list.toString());
        list.removeDuplicate();
        System.out.println(list.toString());

        reverse(list);
        System.out.println(list.toString());
        System.out.println(findNodeFromEnd(list, 3));
        System.out.println(findNodeFromEnd2(list, 3).getData());

        System.out.println(findNodeFromEnd(list, 5));
        System.out.println(findNodeFromEnd2(list, 5).getData());

        System.out.println(findNodeFromEnd(list, 1));
        System.out.println(findNodeFromEnd2(list, 1).getData());

        System.out.println(list.toString());
        swapNodeFromEndWithHead(list,3);
        System.out.println(list.toString());
        swapNodeFromEndWithHead(list,1);
        System.out.println(list.toString());
        swapNodeFromEndWithHead(list,8);
        System.out.println(list.toString());
        swapNodeWithHead(list, 3);
        System.out.println(list.toString());

        list = new LInkedListImpl();
        for (int i = 1; i <= 10; i++) {
            list.addNode(i);
        }

        list.insertAfterNode(1, 1);
        list.insertAfterNode(3, 3);
        list.insertAfterNode(3, 3);
        list.insertAfterNode(5, 5);

        System.out.println(list.toString());
        removeDuplicateFromSorted(list);
        System.out.println(list.toString());
*/
        //revertEvenNode(list);
        //System.out.println(list.toString());
        /*
        Node a = new Node(3);
        Node b = new Node(4);
        a.setNextNode(b);
        Node c = new Node(5);
        b.setNextNode(c);
        Node d = new Node(6);
        c.setNextNode(d);
        Node e = new Node(7);
        d.setNextNode(e);
        Node f = new Node(8);
        e.setNextNode(f);
        Node g = new Node(9);
        f.setNextNode(g);  
        g.setNextNode(d);

        detectAndRemoveLoop(a);
        
        System.out.println(toString(a));
        System.out.println("hi");
        */

/*
        NodeX a = new NodeX("M");
        NodeX b = new NodeX("A");
        a.setNextNode(b);
        NodeX c = new NodeX("D");
        b.setNextNode(c);
        NodeX d = new NodeX("A");
        c.setNextNode(d);
        NodeX e = new NodeX("R");
        d.setNextNode(e);
        System.out.println(palindromeWIthSpecialCharacterAndNumber(a));
        */
        /*
        Node a = new Node(1);
        Node b = new Node(2);
        a.setNextNode(b);
        Node c = new Node(3);
        b.setNextNode(c);
        Node d = new Node(4);
        c.setNextNode(d);
        Node e = new Node(5);
        d.setNextNode(e);

        Node aa = new Node(10);
        Node bb = new Node(20);
        aa.setNextNode(bb);
        Node cc = new Node(30);
        bb.setNextNode(cc);
        Node dd = new Node(40);
        cc.setNextNode(dd);
        Node ee = new Node(50);
        dd.setNextNode(ee);
        Node ff = new Node(60);
        ee.setNextNode(ff);

        e.setNextNode(dd);


        System.out.println(intersectionOfLinklist(a, aa).getData());
        */

        LinkList list1 = new LinkList();
        for (int i = 1; i <= 10; i++) {
            list1.addData(i);
        }

        LinkList list2 = new LinkList();
        for (int i = 4; i <= 15; i++) {
            list2.addData(i);
        }

        LinkList result = mergeSortedLinklist(list1, list2);
        System.out.println("hello");
    }
}



class NodeX {
    String data;
    NodeX node;

    public NodeX(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public NodeX getNextNode() {
        return node;
    }

    public void setNextNode(NodeX node) {
        this.node = node;
    }
}

class LinkList{
    Node head;

    public void addData(int input){
        if(head == null){
            head=new Node(input);
            return;
        }

        Node tmp=head;

        while(tmp.getNextNode() !=null){
            tmp=tmp.getNextNode();
        }

        tmp.setNextNode(new Node(input));

    }
}