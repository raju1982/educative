package array;
import java.util.Arrays;

public class ReorderUnsortedArrayBasedOnIndex {

    public static void reorderArray(int[] input, int[] order){
        if(input == null || order==null || (input.length!=order.length)){
            throw new IllegalArgumentException();
        }

        for(int i=0; i<input.length; i++){
            if(i != order[i]){  //0!=2
                //swap Math
                int tmp=input[i]; //5
                input[i]=input[order[i]]; //8,9,8,12,14,1
                input[order[i]] = tmp; //8,9,5,12,14,1

                //swap index
                tmp=order[i];
                order[i]=order[tmp];
                order[tmp] = tmp;
            }
        }

    }

    //better solution ******
    // Method to reorder elements of arr[] according to index[]
    static void reorder(int[] arr, int[] index)
    {
        int temp[] = new int[arr.length];

        // arr[i] should be present at index[i] index
        for (int i=0; i<arr.length; i++)
            temp[index[i]] = arr[i];

        // Copy temp[] to arr[]
        for (int i=0; i<arr.length; i++)
        {
            arr[i] = temp[i];
            index[i] = i;
        }
    }



    public static void main(String[] args){
        int[] input = new int[] {5,9,8,12,14,1};
        int[] order = new int[] {2,0,1,3,5,4};
        reorderArray(input, order);
        System.out.println(Arrays.toString(input));
    }
}

