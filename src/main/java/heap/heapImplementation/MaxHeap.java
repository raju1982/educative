package heap.heapImplementation;

public class MaxHeap {
    int[] data;
    int count = 0;

    public MaxHeap(int size){
        data = new int[size];
    }

    public int getParentIndex(int input){
       if(input > data.length ){
           throw new IllegalArgumentException();
       }

       int index = (input-1)/2;
       if(index < 0){
           return -1;
       }
       return index;
    }

    public int getLeftChildIndex(int input){
        if(input > data.length ){
            throw new IllegalArgumentException();
        }

        int index = 2*input + 1;

        if(index > count){
            return -1;
        }
        return index;
    }

    public int getRightChildIndex(int input){
        if(input > data.length ){
            throw new IllegalArgumentException();
        }

        int index = 2*input + 2;

        if(index > count){
            return -1;
        }
        return index;
    }

   public void insert(int input) throws HeapFullException{
        if(count > data.length){
            throw new HeapFullException();
        }
        data[count]=input;
        shiftUP(count);
        count++;
    }

    public void swap(int parentIndex, int childIndex){
        int tmp = data[parentIndex];
        data[parentIndex] = data[childIndex];
        data[childIndex] = tmp;
    }

    public void shiftUP(int index){
        int parentIndex = getParentIndex(index);

        if(parentIndex != -1 && data[parentIndex] < data[index]){
            swap(parentIndex, index);
            shiftUP(parentIndex);
        }
    }

    public void remove(){
        data[0] = data[count-1];
        count--;
        shiftDown(0);
    }

    public void shiftDown(int index){
        if(index == -1 || index >= count){
            return;
        }

        int leftIndex = getLeftChildIndex(index);
        int rightIndex = getRightChildIndex(index);
        int maxValueIndex;

        if(leftIndex!=-1 && rightIndex!=-1){
            if(data[leftIndex] >= data[rightIndex]){
                maxValueIndex = leftIndex;
            }
            else{
                maxValueIndex = rightIndex;
            }
        }
        else{
            if(leftIndex == -1){
                maxValueIndex = rightIndex;
            }
            else if(rightIndex == -1){
                maxValueIndex = leftIndex;
            }
            else{
                maxValueIndex = -1;
            }
        }

        if(maxValueIndex == -1){
            return;
        }
        else if(data[maxValueIndex] > data[index]){
            swap(maxValueIndex, index);
            shiftDown(maxValueIndex);
        }

    }

    public void print(){
       for(int i=0; i<data.length; i++){
            System.out.println(data[i]);
        }
    }

    public static void main(String[] args) throws HeapFullException {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(10);
        maxHeap.insert(12);
        maxHeap.insert(2);
        maxHeap.insert(17);
        maxHeap.insert(11);
        maxHeap.insert(1);
        maxHeap.insert(14);
        maxHeap.insert(21);
        maxHeap.print();
        maxHeap.remove();
        System.out.println("\n\n");
        maxHeap.print();
    }

}

class HeapFullException extends Exception{
}