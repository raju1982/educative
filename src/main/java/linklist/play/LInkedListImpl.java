package linklist.play;

import java.util.Set;
import java.util.HashSet;

public class LInkedListImpl {

    Node head;

    //insert at end
    public void addNode(int input){
        Node data = new Node(input);
        if(head==null){
            head = data;
            return;
        }

        Node tmp = head;
        while(tmp.getNextNode() != null){
            tmp = tmp.getNextNode();
        }
        tmp.setNextNode(data);
    }

    public void addAtHead(int input){
        Node data = new Node(input);
        data.setNextNode(head);
        head = data;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        Node tmp = head;
        while(tmp != null){
            result.append(tmp.getData() + "->");
            tmp = tmp.getNextNode();
        }
        return result.toString();
    }

    public void insertAfterNode(int previous, int value){
        Node tmp = head;
        Node data = new Node(value);

        while(tmp != null){
            if(tmp.getData() == previous){
                data.setNextNode(tmp.getNextNode());
                tmp.setNextNode(data);
                break;
            }
            tmp = tmp.getNextNode();
        }
    }



    public int search(int val){
        Node tmp = head;
        int index = 1;
        while(tmp != null){
            if(tmp.getData() == val){
                return index;
            }
            index++;
            tmp = tmp.getNextNode();
        }
        return -1;
    }

    public boolean delete(int val){
        Node tmp = head;
        while(tmp.getNextNode().getNextNode()!=null){
            if(tmp.getNextNode().getData()==val){
                break;
            }
            tmp = tmp.getNextNode();
        }
        if(tmp.getNextNode().getData()==val){
            tmp.setNextNode(tmp.getNextNode().getNextNode());
            return true;
        }
        return false;
    }

    /* better solution */
    /*
    public static boolean delete2(LinkListPlay list, int value) {
        linklist.Node tmp = list.getHead();
        linklist.Node previousNode = null;
        if (tmp == null) {
            return false;
        }
        while(tmp!=null) {
            if (tmp.getData() == value) {
                previousNode.setNextNode(tmp.getNextNode());
                return true;
            }
            previousNode = tmp;
            tmp = tmp.getNextNode();
        }
        return false;
    }
     */

    /* better solution */
        /*public static boolean detectLoop(LinkListPlay list){

        linklist.Node jumpOne = list.getHead();
        linklist.Node jumpTwo = list.getHead();

        while(jumpOne!=null || jumpTwo!=null){
            jumpOne = jumpOne.getNextNode();
            if(jumpTwo.getNextNode() == null){
                return false;
            }
            jumpTwo = jumpTwo.getNextNode().getNextNode();
            if(jumpOne==jumpTwo){
                return true;
            }
        }
        return false;
    }
    */


    public int mid(){
        Node singleJump = head;
        Node doubleJump = head;
        int count = 1;
        while(doubleJump!=null){
            if(doubleJump.getNextNode() == null){
                return count;
            }
            singleJump = singleJump.getNextNode();
            doubleJump = doubleJump.getNextNode().getNextNode();
            count++;
        }
        return count;
    }

    public int mid2(){
        Node singleJump = head;
        Node doubleJump = head;
        while(doubleJump!=null){
            if(doubleJump.getNextNode() == null){
                return singleJump.getData();
            }
            singleJump = singleJump.getNextNode();
            doubleJump = doubleJump.getNextNode().getNextNode();
        }
        return singleJump.getData();
    }

    public void removeDuplicate(){
        Node tmp = head;
        Node previous = null;
        Set<Integer> data = new HashSet<>();

        while(tmp!=null){
            if(data.contains(tmp.getData())){
                previous.setNextNode(tmp.getNextNode());
            }
            data.add(tmp.getData());
            previous = tmp;
            tmp = tmp.getNextNode();
        }
    }

    public void reverse(){
        Node next = head;;
        Node previous = null;
        while(next!=null){
            Node tmp = next.getNextNode();
            next.setNextNode(previous);
            head = next;
            previous = next;
            next = tmp;
        }
    }



    public static void main(String[] args){
        LInkedListImpl  list = new LInkedListImpl();

        for (int i = 1; i <= 10; i++) {
            list.addNode(i);
        }

        System.out.println(list.toString());
        list.insertAfterNode(5, 50);
        System.out.println(list.toString());
        //System.out.println(list.count());

        //System.out.println(list.count());

        System.out.println(list.search(5));
        System.out.println(list.search(15));

        System.out.println(list.delete(5));
        System.out.println(list.delete(10));
        System.out.println(list.toString());
        System.out.println(list.delete(100));

        //System.out.println(detectLoop(list));

        System.out.println(list.mid());
        System.out.println(list.mid2());

        list.insertAfterNode(4, 4);
        list.insertAfterNode(9, 9);
        list.insertAfterNode(7, 2);
        System.out.println(list.toString());
        list.removeDuplicate();
        System.out.println(list.toString());
        list.reverse();
        System.out.println(list.toString());
    }

}