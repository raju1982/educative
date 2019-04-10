package binary.tree;

public class PrintRange {
    public static void printRange(Node node, int low, int high){
        if(node == null){
            return;
        }
        int data = node.getData();

        if(data >= low && data <= high){
            System.out.println(data);
        }

        if(data >= low){
            printRange(node.getLeftNode(), low, high);
        }

        if(data < high){
            printRange(node.getRightNode(), low, high);
        }
    }
}
