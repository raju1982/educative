package binary.tree;

import java.util.Arrays;

public class FindNodesAtKDistanceFromRoot {

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
        strBuild = findNode(head, 2, strBuild);
        String[] str = strBuild.toString().split(",");
        System.out.println(Arrays.toString(str));

    }

    public static Node insert(Node head, Node node){
        if(head==null){
            return node;
        }

        if(head.getData() >= node.getData()){
            head.setLeftNode(insert(head.getLeftNode(), node));
        }
        else{
            head.setRightNode(insert(head.getRightNode(), node));
        }
        return head;
    }

    public static StringBuilder findNode(Node node, int k, StringBuilder strBuilder){
        if(node == null){
            return null;
        }
        if(k==0){
            strBuilder.append(node.getData() + ",");
        }
        else {
            findNode(node.getLeftNode(), k - 1, strBuilder);
            findNode(node.getRightNode(), k - 1, strBuilder);
        }
        return strBuilder;
    }

}
