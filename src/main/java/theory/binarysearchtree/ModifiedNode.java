package theory.binarysearchtree;

public class ModifiedNode {
    private int x;
    private ModifiedNode left, right;
    private int leftNodeCount;

    public ModifiedNode(int x){
        this.x = x;
    }

    public int getData(){
        return x;
    }

    public ModifiedNode getLeftNode() {
        return left;
    }

    public void setLeftNode(ModifiedNode left) {
        this.left = left;
    }

    public ModifiedNode getRightNode() {
        return right;
    }

    public void setRightNode(ModifiedNode right) {
        this.right = right;
    }

    public int getLeftNodeCount() {
        return leftNodeCount;
    }

    public void setLeftNodeCount(int leftNodeCount) {
        this.leftNodeCount = leftNodeCount;
    }
}
