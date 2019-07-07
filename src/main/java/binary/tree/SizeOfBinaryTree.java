package binary.tree;

public class SizeOfBinaryTree {
    public static void main(String[] args) {
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

        insert(head, one);
        insert(head, seven);
        insert(head, three);
        insert(head, eight);
        insert(head, two);
        insert(head, nine);
        insert(head, six);
        insert(head, four);

        System.out.println(size(head));
    }

    public static binary.tree.Node insert(binary.tree.Node head, binary.tree.Node node) {
        if (head == null) {
            return node;
        }

        if (node.getData() <= head.getData()) {
            head.setLeftNode(insert(head.getLeftNode(), node));
        } else {
            head.setRightNode(insert(head.getRightNode(), node));
        }
        return head;
    }

    public static int size(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSize = size(root.getLeftNode());
        int rightSize = size(root.getRightNode());
        return leftSize + rightSize + 1;
    }

}
