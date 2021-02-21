package theory.binarytree;

import java.util.ArrayList;
import java.util.List;

public class SerializeAndDeserializeABinaryTree {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.setLeftNode(new Node(20));
        root.setRightNode(new Node(30));
        root.getLeftNode().setLeftNode(new Node(40));
        root.getLeftNode().setRightNode(new Node(50));
        root.getRightNode().setLeftNode(new Node(60));
        root.getRightNode().setRightNode(new Node(70));
        inOrderTraversal(root);


        // first solution using list
        List<Integer> serializedTree = new ArrayList<>();
        Serialize(root, serializedTree);
        System.out.println("\n" + serializedTree.toString());
        Node node = deSerialize(serializedTree);
        inOrderTraversal(node);

        //second solution using string
        String result = Serialize(root);
        System.out.println( "\n" + result);
        Node node2 = deSearlize(result);
        inOrderTraversal(node2);
    }

    //use preOrder traversal to create serializedTree.
    private static final int NULL_MARKER = -1;
    public static void Serialize(Node node, List<Integer> serializedTree){
        if(node == null){
            serializedTree.add(NULL_MARKER);
            return;
        }
        serializedTree.add(node.getData());
        Serialize(node.getLeftNode(), serializedTree);
        Serialize(node.getRightNode(), serializedTree);
    }

    private static int index = 0;
    public static Node deSerialize(List<Integer> serializedTree){
        if(serializedTree == null || serializedTree.size() == index){
            return null;
        }
        int tmpValue = serializedTree.get(index);
        index++;
        if(tmpValue == NULL_MARKER){
            return null;
        }
        Node tmpNode = new Node(tmpValue);
        tmpNode.setLeftNode(deSerialize(serializedTree));
        tmpNode.setRightNode(deSerialize(serializedTree));
        return tmpNode;
    }

    public static void inOrderTraversal(Node node){
        if(node!=null){
            inOrderTraversal(node.getLeftNode());
            System.out.print(node.getData() + "\t");
            inOrderTraversal(node.getRightNode());
        }
    }


    //second solution using string
    public static String Serialize(Node node){
        StringBuffer strBuffer = new StringBuffer();
        Serialize(node, strBuffer);
        return strBuffer.toString();
    }

    private static final String NULL = "%";
    public static void Serialize(Node node, StringBuffer serializedTreeString){
        if(node == null){
            serializedTreeString.append(NULL).append(",");
            return;
        }
        serializedTreeString.append(node.getData()).append(",");
        Serialize(node.getLeftNode(), serializedTreeString);
        Serialize(node.getRightNode(), serializedTreeString);
    }

    private static int indexInString = 0;

    public static Node deSearlize(String serializedTreeString){
        return deSearlize(serializedTreeString.split(","));
    }

    public static Node deSearlize(String[] serializedTreeString){
        if(serializedTreeString == null){
            return null;
        }
        String nodeValue = serializedTreeString[indexInString];
        indexInString++;
        if(nodeValue.equalsIgnoreCase(NULL)){
            return null;
        }
        Node node = new Node(Integer.valueOf(nodeValue));
        node.setLeftNode(deSearlize(serializedTreeString));
        node.setRightNode(deSearlize(serializedTreeString));
        return node;
    }

}
