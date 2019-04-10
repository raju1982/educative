package binary.tree;

public class CountTrees {
    public static int countTree(int noOfNodes){
        if(noOfNodes<=1){
            return 1;
        }
        int sum=0;
        for(int i=0; i<=noOfNodes; i++){
            int leftNode = countTree(i-1);
            int rightNode = countTree(noOfNodes-i);

            sum = sum + (leftNode*rightNode);
        }
        return sum;
    }

}

