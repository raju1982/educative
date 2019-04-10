package binary.tree;

public class SortedOrderPrintCompleteTreeArray {
    private void print(int arr[],int current){
        if(current >= arr.length){
            return;
        }
        // print left subtree
        print(arr,2*current+1);
        // print root
        System.out.println(arr[current]);
        // print right subtree
        print(arr,2*current+2);
    }

    public void print(int arr[]){
        print(arr,0);
    }

    public static void main(String args[]){
        int arr[] = {4, 2, 5, 1, 3};
        SortedOrderPrintCompleteTreeArray sop = new SortedOrderPrintCompleteTreeArray();
        sop.print(arr);
    }
}
