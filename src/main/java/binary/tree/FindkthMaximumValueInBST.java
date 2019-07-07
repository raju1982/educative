package binary.tree;

public class FindkthMaximumValueInBST {

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
        inorder(head, strBuild);
        String[] tmp = strBuild.toString().split(",");
        System.out.println(tmp[tmp.length-3]);
        System.out.println(find_nth_highest_in_bst(head,3).getData());

    }

    public static binary.tree.Node insert(binary.tree.Node head, binary.tree.Node node){
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

    public static int current_count = 0;
    public static Node find_nth_highest_in_bst(Node head, int n){
        if(head==null){
            return null;
        }
        Node result = find_nth_highest_in_bst(head.getRightNode(), n);

        if(result != null) {
            return result;
        }

        current_count++;
        if(n == current_count) {
            return head;
        }

        result = find_nth_highest_in_bst(head.getLeftNode(), n);

        if(result != null) {
            return result;
        }

        return null;
    }


}

/*
public static BinaryTreeNode find_nth_highest_in_bst(
      BinaryTreeNode node,
      int n) {

    if (node == null) {
      return null;
    }

    BinaryTreeNode result =
      find_nth_highest_in_bst(node.right, n);

    if(result != null) {
      return result;
    }

    current_count++;
    if(n == current_count) {
      return node;
    }

    result =
      find_nth_highest_in_bst(node.left, n);

    if(result != null) {
      return result;
    }

    return null;
  }
 */