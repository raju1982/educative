package linklist.sort;

public class MergeSortBetterImpl {

    static Node mergeSort(Node input){
        if(input==null || input.getNextNode() == null){
            return input;
        }
        Node mid = findMiddleNode(input);
        Node rightListRootNode = mid.getNextNode();
        mid.setNextNode(null);
        Node left = mergeSort(input);
        Node right = mergeSort(rightListRootNode);
        return merge(left, right);
    }

    static Node merge(Node left, Node right){
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        Node result = null;
        if(left.getData() <= right.getData()){
            result = new Node(left.getData());
            result.setNextNode(merge(left.getNextNode(), right));
        }

        if(left.getData() > right.getData()){
            result = new Node(right.getData());
            result.setNextNode(merge(left, right.getNextNode()));
        }
        return result;
    }

    static Node findMiddleNode(Node input){
        //Base case
        if (input == null)
            return input;
        Node slow = input;
        Node fast = input.getNextNode();
        while(fast!= null){
            fast = fast.getNextNode();
            if(fast!=null){
                fast = fast.getNextNode();
                slow = slow.getNextNode();
            }
        }
        return slow;
    }

    public static void main(String[] args){
        Node a = new Node(5);
        Node b = new Node(6);
        Node c = new Node(3);
        Node d = new Node(8);
        Node e = new Node(1);

        a.setNextNode(b);
        b.setNextNode(c);
        c.setNextNode(d);
        d.setNextNode(e);

        Node result = mergeSort(a);
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

    public Node getNextNode(){
        return nextNode;
    }

    public int getData(){
        return this.data;
    }

    public Node getNode(){
        return this.nextNode;
    }
}

//Alice Alone Boy Chair Dear Dog Water Xray Yarn Zing