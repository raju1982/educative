package heap.heapImplementation;
import java.util.Arrays;

public class util {
    public static void heapify(int[] input, int endIndex, String type){

        //int endIndex = input.length-1;
        int startIndex=parentIndex(endIndex, endIndex);

        for(int i=startIndex; i>=0 ; i--){
            if(type.equalsIgnoreCase("max")){
                //System.out.println("startIndex " + i);
                maxPerlocateDown(i, endIndex, input);
            }
        }
    }


    public static void maxPerlocateDown(int index, int endIndex, int[] input){
        int leftChildIndex = leftChildIndex(index, endIndex);
        int rightChildIndex = rightChildIndex(index, endIndex);
        //System.out.println("leftChildIndex " + leftChildIndex);
        //System.out.println("rightChildIndex " + rightChildIndex);

        if(leftChildIndex != -1 && input[leftChildIndex] > input[index]){
            swap(leftChildIndex, index, input);
            maxPerlocateDown(leftChildIndex, endIndex, input);
        }

        if(rightChildIndex != -1 && input[rightChildIndex] > input[index]){
            swap(rightChildIndex, index, input);
            maxPerlocateDown(rightChildIndex, endIndex, input);
        }
    }

    public static void heapSort(int[] input){
        int i = input.length-1;

        while(i>=0){
            heapify(input, i,"max");
            swap(0,i,input);
            i--;
        }
    }



    //swap values present at index
    public static void swap(int indexA, int indexB, int[] input ){
        int tmp = input[indexA];
        input[indexA] = input[indexB];
        input[indexB] = tmp;
    }


    //valid value or -1
    //(n-1)/2
    public static int parentIndex(int index, int endIndex){
        int parentIndex = (index-1)/2;
        if(parentIndex<0 || parentIndex>endIndex){
            return -1;
        }
        return parentIndex;
    }

    //valid value or -1
    //2*n+1
    public static int leftChildIndex(int index, int endIndex){
        int leftChildIndex = 2*index+1;
        if(leftChildIndex<0 || leftChildIndex>endIndex){
            return -1;
        }
        return leftChildIndex;
    }

    //valid value or -1
    //2*n+2
    public static int rightChildIndex(int index, int endIndex){
        int rightChildIndex = index*2+2;
        if(rightChildIndex<0 || rightChildIndex>endIndex){
            return -1;
        }
        return rightChildIndex;
    }

    public static int minElementinMinheap(int[] data){
        int parentIndex = parentIndex(data.length-1, data.length-1);

        int minValue = data[parentIndex+1];

        for(int i=parentIndex+1; i<data.length-1; i++){
            if(data[i] < minValue){
                minValue = data[i];
            }
        }
        return minValue;
    }

    public static void main(String[] args){
        int[] data = new int[] {12, 3, 2,8,5,10,25,4};
        heapify(data, data.length-1,"max");
        System.out.println(Arrays.toString(data));

        System.out.println(minElementinMinheap(data));


        heapSort(data);
        System.out.println(Arrays.toString(data));

        //minimum three
        int[] data2 = new int[] {12, 3, 2,8,5,10,25,4};
        int[] minThree = new int[3];

        for(int i=0; i<3; i++){
            minThree[i] = data2[i];
        }

        heapify(minThree, minThree.length-1, "max");

        for(int i=3; i<=data2.length-1; i++) {
            if (data2[i] < minThree[0]) {
                minThree[0] = data2[i];
                heapify(minThree, minThree.length - 1, "max");
            }
        }

        System.out.println(Arrays.toString(minThree));
    }



}
