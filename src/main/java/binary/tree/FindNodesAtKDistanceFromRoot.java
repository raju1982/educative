package binary.tree;

import java.util.Arrays;

public class FindNodesAtKDistanceFromRoot {

    public static void main(String[] args){

        binary.tree.Node one = new binary.tree.Node(1);
        binary.tree.Node two = new binary.tree.Node(2);
        binary.tree.Node three = new binary.tree.Node(3);
        binary.tree.Node four = new binary.tree.Node(4);
        binary.tree.Node five = new binary.tree.Node(5);
        binary.tree.Node six = new binary.tree.Node(6);
        binary.tree.Node seven = new binary.tree.Node(7);
        binary.tree.Node eight = new binary.tree.Node(8);
        binary.tree.Node nine = new binary.tree.Node(9);

        binary.tree.Node head = insert(null, five);

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

    public static binary.tree.Node insert(binary.tree.Node head, binary.tree.Node node){
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
