package binary.tree;

public class CheckIfTwoTreesAreIdentical {

        public static boolean are_identical(
                Node root1,
                Node root2) {

            if (root1 == null && root2 == null) {
                return true;
            }

            if (root1 != null && root2 != null) {
                return   ((root1.data == root2.data) &&
                        are_identical(root1.getLeftNode(), root2.getLeftNode()) &&
                        are_identical(root1.getRightNode(), root2.getRightNode()));
            }

            return false;
        }

    public static void main(String[] args){

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

        insert(head, one);
        insert(head, seven);
        insert(head, three);
        insert(head, eight);
        insert(head, two);
        insert(head, nine);
        insert(head, six);
        insert(head, four);


        Node ten = new Node(1);
        Node elevan = new Node(2);
        Node twelve = new Node(3);
        Node thirteen = new Node(4);
        Node fourteen = new Node(5);
        Node fifteen = new Node(6);
        Node sixteen = new Node(7);
        Node seventeen = new Node(8);
        Node eighteen = new Node(9);

        Node head2 = insert(null, fourteen);

        insert(head2, ten);
        insert(head2, sixteen);
        insert(head2, twelve);
        insert(head2, seventeen);
        insert(head2, elevan);
        insert(head2, eighteen);
        insert(head2, fifteen);
        insert(head2, thirteen);



        System.out.println("same " + Boolean.toString(are_identical(head,head) == true));
        System.out.println("null " + Boolean.toString(are_identical(head, null) == false));
        System.out.println("null,null " + Boolean.toString(are_identical(null, null) == true));
        System.out.println("different " + Boolean.toString(are_identical(head, head2) == false));
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
