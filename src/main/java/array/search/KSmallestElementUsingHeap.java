package array.search;

//import heap.heapImplementation.HeapFullException;

public class KSmallestElementUsingHeap {
    public static final int[] randomNumberArray = new int[] {2, 5, 6, 21, 67, 88, 4, 1, 3, 9, 99};

    public static void main(String[] args) throws HeapFullException {
        kSmallest(3) ;
        //System.out.println(Arrays.toString(KlargetImpl(3)));
    }

    public static void kSmallest(int size) throws HeapFullException {
        // create min heap
        MaxHeap maxHeap = new MaxHeap(size);
        for(int i=0; i<randomNumberArray.length; i++ ){
            if(!maxHeap.isFull()){
                maxHeap.insert(randomNumberArray[i]);
            } else{
                if(randomNumberArray[i] < maxHeap.getHighestPriorityIndex()){
                    maxHeap.removeHighestPriorityElement();
                    maxHeap.insert(randomNumberArray[i]);
                }
            }
            maxHeap.printHeap();
        }
    }
}


class MaxHeap {
    int[] data;
    int count = 0;

    public MaxHeap(int size) {
        data = new int[size];
    }

    public boolean isFull(){
        return (count >= data.length);
    }

    public int getHighestPriorityIndex(){
        return data[0];
    }

    public void removeHighestPriorityElement(){
        data[0] = data[count-1];
        count--;
        shiftDown(0);
    }

    public int getParentIndex(int input) {
        if (input > data.length) {
            throw new IllegalArgumentException();
        }

        int index = (input - 1) / 2;
        if (index < 0) {
            return -1;
        }
        return index;
    }

    public int getLeftChildIndex(int input) {
        if (input > data.length) {
            throw new IllegalArgumentException();
        }

        int index = 2 * input + 1;

        if (index > count) {
            return -1;
        }
        return index;
    }

    public int getRightChildIndex(int input) {
        if (input > data.length) {
            throw new IllegalArgumentException();
        }

        int index = 2 * input + 2;

        if (index > count) {
            return -1;
        }
        return index;
    }

    public void insert(int input) throws HeapFullException {
        if (count > data.length) {
            throw new HeapFullException();
        }
        data[count] = input;
        shiftUP(count);
        count++;
    }

    public void swap(int parentIndex, int childIndex) {
        int tmp = data[parentIndex];
        data[parentIndex] = data[childIndex];
        data[childIndex] = tmp;
    }

    public void shiftUP(int index) {
        int parentIndex = getParentIndex(index);

        if (parentIndex != -1 && data[parentIndex] < data[index]) {
            swap(parentIndex, index);
            shiftUP(parentIndex);
        }
    }

    public void remove() {
        data[0] = data[count - 1];
        count--;
        shiftDown(0);
    }

    public void shiftDown(int index) {
        if (index == -1 || index >= count) {
            return;
        }

        int leftIndex = getLeftChildIndex(index);
        int rightIndex = getRightChildIndex(index);
        int maxValueIndex;

        if (leftIndex != -1 && rightIndex != -1) {
            if (data[leftIndex] >= data[rightIndex]) {
                maxValueIndex = leftIndex;
            } else {
                maxValueIndex = rightIndex;
            }
        } else {
            if (leftIndex == -1) {
                maxValueIndex = rightIndex;
            } else if (rightIndex == -1) {
                maxValueIndex = leftIndex;
            } else {
                maxValueIndex = -1;
            }
        }

        if (maxValueIndex == -1) {
            return;
        } else if (data[maxValueIndex] > data[index]) {
            swap(maxValueIndex, index);
            shiftDown(maxValueIndex);
        }

    }

    public void printHeap() {
        for (int i = 0; i < count; i++) {
            System.out.print(data[i] + ",");
        }
        System.out.println();
    }
}

//class HeapFullException extends Exception{
//}