package heap.heapImplementation;
import java.util.Arrays;

public class HeapImpl{

    static int parent(int maxIndex, int i){
        int index = (i-1)/2;
        if (index > maxIndex || index<0){
            return -1;
        }
        return index;
    }

    static int rightChild(int maxIndex, int i){
        int index = 2*i +2;
        if (index > maxIndex){
            return -1;
        }
        return index;
    }

    static int leftChild(int size, int i){
        int index = 2*i + 1;
        if (index > size || index<0){
            return -1;
        }
        return index;
    }

    public static void swap(int i, int j, int[] input){
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

    //parent index is input
    //compare to child. if less than child swap.
    //recurstion call
    static void perlocateDown(int parentIndex, int maxIndex, int[] input){
        int rightIndex = rightChild(maxIndex, parentIndex);
        int leftIndex = leftChild(maxIndex, parentIndex);

        if(rightIndex != -1 && input[rightIndex] > input[parentIndex]){
            swap(rightIndex, parentIndex, input);
            perlocateDown(rightIndex, maxIndex, input);
        }

        if(leftIndex != -1 && input[leftIndex] > input[parentIndex]){
            swap(leftIndex, parentIndex, input);
            perlocateDown(leftIndex, maxIndex, input);
        }
    }

    //in end you will have max heap
    static void heapify(int[] input){
        int maxIndex = input.length-1;
        int parentIndex = parent(maxIndex, maxIndex);
        int i=parentIndex;
        while(i>=0){
            perlocateDown(i, maxIndex, input);
            i--;
        }
    }

    static void heapSort(int[] input){
        heapify(input);
        int i = input.length-1;
        while(i>0){
            swap(0, i, input);
            i--;
            perlocateDown(0, i, input);
        }
    }

    //lowest three Math
    public static void main(String[] args){
        //herap sort
        int[] heapArray = new int[] { 1, 4, 7, 12, 15, 14, 9, 2, 3, 16 };
        heapSort(heapArray);
        System.out.println(Arrays.toString(heapArray));

        //bottom 3 element
        heapArray = new int[]  { 1, 4, 7, 12, 15, 14, 9, 2, 3, 16 };
        int[] result = new int[] { 1, 4, 7};
        heapify(result);
        for(int i=3; i<= heapArray.length-1;i++){
            if(heapArray[i]<result[0]){
                result[0] = heapArray[i];
                perlocateDown(0, 2, result);
            }
        }
        System.out.println(Arrays.toString(result));
    }

}