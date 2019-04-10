package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KLArgestElement {

    public static int[] randomNumberArray = new int[] {2, 5, 6, 21, 67, 88, 4, 1, 3, 9, 99};

    public static void main(String[] args) throws heapFullException {
          kLargest(3) ;
          System.out.println(Arrays.toString(KlargetImpl(3)));
    }

    public static Integer[] KlargetImpl(int size){
        PriorityQueue<Integer> tmp = new PriorityQueue<>(size);
        for(int i=0; i<randomNumberArray.length; i++ ){
            if(tmp.size() < size){
                tmp.add(randomNumberArray[i]);
            }else{
                if(randomNumberArray[i] > tmp.peek()){
                    tmp.poll();
                    tmp.add(randomNumberArray[i]);
                }
                System.out.println(Arrays.toString(tmp.toArray(new Integer[3])));
            }
        }
        return tmp.toArray(new Integer[3]);
    }



    public static void kLargest(int size) throws heapFullException {
        // create min heap
        MinHeap minHeap = new MinHeap(size);
        for(int i=0; i<randomNumberArray.length; i++ ){
            if(!minHeap.isfull()){
               minHeap.insert(randomNumberArray[i]);
            } else{
                if(randomNumberArray[i] > minHeap.getHighestPriorityIndex()){
                      minHeap.removeHighestPriorityElement();
                      minHeap.insert(randomNumberArray[i]);
                }
            }
            minHeap.printHeap();
        }
        //insert in min heap
    }
}


class MinHeap {

    int[] data;
    int count = 0;

    public MinHeap(int size) {
        data = new int[size];
    }

    public void printHeap(){
        for(int i=0; i<count; i++)  {
            System.out.print(data[i] + ",");
        }
        System.out.println();
    }

    public void insert(int i) throws heapFullException {
        if (isfull()) {
            throw new heapFullException();
        }
        data[count] = i;
        shiftup(count);
        count++;
    }

    public void shiftup(int index) {
        int parentIndex = getParentIndex(index);
        if (parentIndex == -1) {
            return;
        }
        if (data[parentIndex] > data[index]) {
            swap(index, parentIndex);
            shiftup(parentIndex);
        }
    }

    public void swap(int index, int parentIndex) {
        int tmp = data[index];
        data[index] = data[parentIndex];
        data[parentIndex] = tmp;
    }

    public void removeHighestPriorityElement() {
        data[0] = data[count - 1];
        count--;
        shiftDown(0);
    }

    public int getHighestPriorityIndex(){
        return data[0];
    }

    public void shiftDown(int index) {
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);
        int maxIndex = -1;
        if (leftChildIndex != -1 && rightChildIndex != -1) {
            maxIndex = data[leftChildIndex] < data[rightChildIndex] ? leftChildIndex : rightChildIndex;
        } else if (leftChildIndex == -1 && rightChildIndex != -1) {
            maxIndex = rightChildIndex;
        } else if (leftChildIndex != -1 && rightChildIndex == -1) {
            maxIndex = leftChildIndex;
        }

        if (maxIndex == -1) {
            return;
        }

        if (data[maxIndex] < data[index]) {
            swap(maxIndex, index);
            shiftDown(maxIndex);
        }
    }

    public boolean isfull() {
        return count >= data.length;
    }

    public int getParentIndex(int index) {
        int parentIndex = (2 * index - 1) / 2;
        if (parentIndex < 0) {
            return -1;
        }
        return parentIndex;
    }

    public int getLeftChildIndex(int index) {
        int leftChild = 2 * index + 1;
        if (leftChild >= count) {
            return -1;
        }
        return leftChild;
    }

    public int getRightChildIndex(int index) {
        int rightChild = 2 * index + 2;
        if (rightChild >= count) {
            return -1;
        }
        return rightChild;
    }
}

class heapFullException extends Exception {
}