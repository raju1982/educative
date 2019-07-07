package binary.tree;

public class FindAncestorsOfGivenNodeInBinaryTree {

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

        insert(head, eight);
        insert(head, two);
        insert(head, one);
        insert(head, seven);
        insert(head, three);
        insert(head, nine);
        insert(head, six);
        insert(head, four);


        System.out.println(findAncestors(five, 3));
        System.out.println(printAncestors(five, 3));
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


    public static String findAncestors(binary.tree.Node root, int k) {
        if (root == null) {
            return "null";
        }
        StringBuilder ancestors = new StringBuilder();
        Node current = root;
        while (current != null && (current.getData() != k)) {
            ancestors.append(current.getData());
            ancestors.append(",");
            if (k > current.getData()) {
                current = current.getRightNode();
            } else if (k < current.getData()) {
                current = current.getLeftNode();
            }
        }
        return ancestors.toString();
    }

    // Prints the ancestors if target is present in tree, then return true, else returns false.
    static boolean printAncestors(Node node, int target) {
        if (node == null)    // base cases
            return false;

        if (node.getData() == target)
            return true;

        // print this node if target is present in either left or right subtree of this node
        if (printAncestors(node.getLeftNode(), target) || printAncestors(node.getRightNode(), target)) {
            System.out.print(node.getData() + " ");
            return true;
        }
        return false;    // else return false
    }


}
