package heap.heap.complex;

//heapify
//heapsort

import java.util.Arrays;


public class Heap{

    int[] data;

    public Heap(int[] data){
        this.data=data;
    }

    public void heapifyMaxheap(int endIndex){
        //parent index
        int parentIndex = getParentIndex(endIndex, endIndex);

        for(int i=parentIndex; i>=0; i--){
            maxheap(i,endIndex);
        }

    }

    public void heapifyMinheap(int endIndex){
        //parent index
        int parentIndex = getParentIndex(endIndex, endIndex);

        for(int i=parentIndex; i>=0; i--){
            minheap(i,endIndex);
        }

    }

    public void swap(int indexA, int indexB){
        int tmp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = tmp;
    }


    public void maxheap(int index, int endIndex){
        int leftIndex = leftChildIndex(index, endIndex);
        int rightIndex = rightChildIndex(index, endIndex);

        if(leftIndex!=-1 && data[leftIndex] > data[index]){
            swap(leftIndex, index);
            maxheap(leftIndex, endIndex);
        }

        if(rightIndex!=-1 && data[rightIndex] > data[index]){
            swap(rightIndex, index);
            maxheap(rightIndex, endIndex);
        }

    }


    public void minheap(int index, int endIndex){
        int leftIndex = leftChildIndex(index, endIndex);
        int rightIndex = rightChildIndex(index, endIndex);

        if(leftIndex!=-1 && data[leftIndex] < data[index]){
            swap(leftIndex, index);
            maxheap(leftIndex, endIndex);
        }

        if(rightIndex!=-1 && data[rightIndex] < data[index]){
            swap(rightIndex, index);
            maxheap(rightIndex, endIndex);
        }
    }

    public void heapSort(){
        int endIndex = data.length-1;
        //heapifyMaxheap(endIndex);

        while(endIndex>0){
            heapifyMaxheap(endIndex);
            swap(0, endIndex);
            endIndex--;
        }
    }


    public int getParentIndex(int index, int endIndex){
        int parentIndex = (index-1)/2;
        if(parentIndex<0 || parentIndex>endIndex){
            return -1;
        }
        else{
            return parentIndex;
        }
    }

    public int leftChildIndex(int index, int endIndex){
        int childIndex = 2*index+1;
        if(childIndex > endIndex){
            return -1;
        }
        else{
            return childIndex;
        }
    }

    public int rightChildIndex(int index, int endIndex){
        int childIndex = 2*index+2;
        if(childIndex > endIndex){
            return -1;
        }
        else{
            return childIndex;
        }
    }

    public static void main(String[] args){
        int[] data = new int[] {12, 3, 2,8,5,10,25,4};
        Heap heap = new Heap(data);

        heap.heapifyMinheap(data.length-1);
        System.out.println(Arrays.toString(data));

        heap.heapifyMaxheap(data.length-1);
        System.out.println(Arrays.toString(data));

        heap.heapSort();
        System.out.println(Arrays.toString(data));
    }

}

