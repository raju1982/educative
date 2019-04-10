package binary.tree;

public class FindkthMaximumValueInBST {

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

        StringBuilder strBuild = new StringBuilder();
        inorder(head, strBuild);
        String[] tmp = strBuild.toString().split(",");
        System.out.println(tmp[tmp.length-3]);

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


    public static void inorder(Node head, StringBuilder strBuild){
        if(head==null){
            return;
        }
        inorder(head.getLeftNode(), strBuild);
        strBuild.append(head.getData() + ",");
        inorder(head.getRightNode(), strBuild);
    }

}
