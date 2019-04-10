package binary.tree;

public class FindAncestorsOfGivenNodeInBinaryTree {

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

        insert(head, eight);
        insert(head, two);
        insert(head, one);
        insert(head, seven);
        insert(head, three);
        insert(head, nine);
        insert(head, six);
        insert(head, four);


        System.out.println(findAncestors(five, 3));
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


        public static String findAncestors(Node root, int k) {
            if (root == null){
                return "null";
            }
            StringBuilder ancestors = new StringBuilder();
            Node current = root;
            while (current != null){
                if (k > current.getData()){
                    ancestors.append(current.getData());
                    ancestors.append(",");
                    current = current.getRightNode();
                }
                else if (k < current.getData()){
                    ancestors.append(current.getData());
                    ancestors.append(",");
                    current = current.getLeftNode();
                }
                else{
                    return ancestors.toString();
                }

            }
            return "";
        }


}
