package heap.heapImplementation;

public class HeapSort {

    static int[] heapArray = { 1, 4, 7, 12, 15, 14, 9, 2, 3, 16 };

    public static void maxHeapFromArray(){
        int maxIndex = heapArray.length-1;

        while(maxIndex>=0) {
            int parentIndex = (maxIndex - 1) / 2;
            for (int i = parentIndex; i >= 0; i--) {
                shiftDown(i, maxIndex);
            }
            swap(maxIndex, 0);
            maxIndex = maxIndex - 1;
        }

        /*
            public static void heapsort() {
        heapify(array.length - 1);

        int endIndex = array.length - 1;
        while (endIndex > 0) {
            swap(0, endIndex);
            endIndex--;
            percolateDown(0, endIndex);
        }
    }
         */

    }

    public static void shiftDown(int index, int maxIndex){
        System.out.println("index " + index + " " + maxIndex );
        if(index == -1 || index>maxIndex){
            return;
        }
        int leftIndex = 2*index + 1;
        int rightIndex = 2*index + 2;
        int maxValueIndex=-1;

        if(leftIndex>maxIndex){
            leftIndex = -1;
        }

        if(rightIndex>maxIndex){
            rightIndex = -1;
        }

        if(leftIndex!= -1 && rightIndex!=-1){
            maxValueIndex = (heapArray[leftIndex] > heapArray[rightIndex])?leftIndex:rightIndex;
            swap(maxValueIndex, index);
            shiftDown(maxValueIndex, maxIndex);
        }

        if(leftIndex!= -1 && heapArray[leftIndex] > heapArray[index]){
            swap(leftIndex, index);
            shiftDown(leftIndex, maxIndex);
        }

        if(rightIndex!= -1 && heapArray[rightIndex] > heapArray[index]){
            swap(rightIndex, index);
            shiftDown(rightIndex, maxIndex);
        }
    }

    public static void swap(int maxIndex, int index){
        int tmp = heapArray[maxIndex];
        heapArray[maxIndex] = heapArray[index];
        heapArray[index] = tmp;
    }

    public static void print(){
        System.out.println("\n");
        for(int i=0; i<heapArray.length; i++) {
            System.out.print(heapArray[i] + ",");
        }
    }

    public static void main(String[] args){
        //int[] heapArray = { 1, 4, 7, 12, 15, 14, 9, 2, 3, 16 };
        maxHeapFromArray();
        print();
    }

}
