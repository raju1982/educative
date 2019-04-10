package binary.tree;

public class MaximumDepth {

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

        System.out.println("maximumDepth value: " + maximumDepth(head));
    }



    public static int maximumDepth(Node node){
        if (node == null) {
            return 0;
        }

        if(node.getLeftNode()==null && node.getRightNode()==null){
            return 0;
        }

        int leftNodeDepth = 1 + maximumDepth(node.getLeftNode());
        int rightNodeDepth = 1 + maximumDepth(node.getRightNode());

        return Math.max(leftNodeDepth, rightNodeDepth);
    }

    public static Node insert(Node head, Node node){
        if(head==null){
            return node;
        }

        if(node.getData()<=head.getData()){
            head.setLeftNode(insert(head.getLeftNode(), node));
        }
        else{
            head.setRightNode(insert(head.getRightNode(), node));
        }
        return head;
    }


}
