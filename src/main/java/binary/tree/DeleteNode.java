package binary.tree;

public class DeleteNode {

    public static binary.tree.Node insert(binary.tree.Node root, binary.tree.Node input){
        if(root == null){
            return input;
        }

        if(input.getData()<=root.getData()){
            root.setLeftNode(insert(root.getLeftNode(), input));
        }
        else{
            root.setRightNode(insert(root.getRightNode(), input));
        }
        return root;
    }

    public static binary.tree.Node search(binary.tree.Node root, int input){
        if(root == null){
            return null;
        }

        int tmp = root.getData();
        if(tmp ==  input){
            return root;
        }

        if(input < tmp){
            return search(root.getLeftNode(), input);
        }
        else {
            return search(root.getRightNode(), input);
        }
    }

    public static int min(binary.tree.Node root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        if(root.getLeftNode() == null){
            return root.getData();
        }
        return min(root.getLeftNode());
    }

    //1.node is leaf node.
    //2.node has 1 child.
    //3.node has 2 children.
    static boolean delete(int value, binary.tree.Node rootNode) {
        if(rootNode == null){
            return false;
        }
        binary.tree.Node currentNode = rootNode;
        binary.tree.Node parent = null; //To Store parent of currentNode
        while(currentNode != null && (currentNode.getData() != value)) {
            parent = currentNode;
            if (currentNode.getData() > value)
                currentNode = currentNode.getLeftNode();
            else
                currentNode = currentNode.getRightNode();

        }
        if(currentNode == null) {
            return false;
        }
        else if(currentNode.getLeftNode() == null && currentNode.getRightNode() == null) {
            if(currentNode.getData() <= parent.getData()){
                parent.setLeftNode(null);
                return true;
            }
            else{
                parent.setRightNode(null);
                return true;
            }
        }
        else if(currentNode.getLeftNode() == null){
            if(parent.getRightNode() == currentNode){
                parent.setRightNode(currentNode.getRightNode());
            }
            else{
                parent.setLeftNode(currentNode.getRightNode());
            }
        }
        else if(currentNode.getRightNode() == null){
            if(parent.getRightNode() == currentNode){
                parent.setRightNode(currentNode.getLeftNode());
            }
            else{
                parent.setLeftNode(currentNode.getLeftNode());
            }
        }
        else{
            int minValue = min(currentNode.getRightNode());
            delete(minValue, rootNode);
            currentNode.setData(minValue);
            return true;
        }
        return false;
    }

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

        Node root = insert(null, five);
        insert(root, three);
        insert(root, eight);
        insert(root, one);
        insert(root, two);
        insert(root, four);
        insert(root, six);
        insert(root, seven);
        insert(root, nine);

        System.out.println("hi");

        //System.out.println(delete(10, root));

        //System.out.println(delete(2, root));

        System.out.println(delete(8, root));

        System.out.println("hi");

    }
}
