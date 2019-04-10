package binary.tree;

public class MinimumAndMaximumValueInBST {

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);

        Node head = insert(null, five);

        insert(head, eight);
        insert(head, two);
        insert(head, one);
        insert(head, seven);
        insert(head, three);
        insert(head, nine);
        insert(head, six);
        insert(head, four);

        System.out.println("minValueInBST value: " + minValueInBST(head));
        System.out.println("maxValueInBST value: " + maxValueInBST(head));
    }

    //THAT IS THE NODE WITH THE SMALLEST VALUE - THE LEFT MOST LEAF NODE IN THE TREE

    public static int minValueInBST(Node head){
        if(head == null){
            return Integer.MIN_VALUE;
        }

        if(head.getLeftNode() == null){
            return head.getData();
        }

        return minValueInBST(head.getLeftNode());
    }

    public static int maxValueInBST(Node head){
        if(head == null){
            return Integer.MAX_VALUE;
        }

        if(head.getRightNode() == null){
            return head.getData();
        }

        return maxValueInBST(head.getRightNode());
    }

    public static Node insert(Node head, Node node){
        if(head==null){
            return node;
        }

        if(node.getData() <= head.getData()){
            head.setLeftNode(insert(head.getLeftNode(), node));
        }
        else{
            head.setRightNode(insert(head.getRightNode(), node));
        }
        return head;
    }
}
