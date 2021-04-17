package theory.heap;

public class MinHeap {

    private int capacity;
    private int[] data;
    private int index;

    public MinHeap(int capacity){
        this.capacity = capacity;
        this.data = new int[capacity];
        this.index = 0;
    }

    private int getParentIndex(int i){
        return (i-1)/2;
    }

    private int leftChildIndex(int i){
        return (2*i)+1;
    }

    private int rightChildIndex(int i){
        return (2*i)+2;
    }

    public void insert(int value){
        if(index==capacity){
            throw new RuntimeException("min heap is full");
        }
        data[index] = value;
        for(int i=index; i!=0 && data[getParentIndex(i)] > data[index];){
            int tmp = data[i];
            int parenIndex = getParentIndex(i);
            data[i] = data[parenIndex];
            data[parenIndex] = tmp;
            i = parenIndex;
        }
        index++;
    }

    private void minHeapify(int i){
        int leftChIndex = leftChildIndex(i);
        int rightChIndex = rightChildIndex(i);
        int minIndex = i;
        if(leftChIndex<=index-1){
            minIndex = data[leftChIndex]>data[rightChIndex]?rightChIndex:leftChIndex;
        }
        if(rightChIndex<=index-1){
            minIndex = data[rightChIndex]>data[minIndex]?minIndex:rightChIndex;
        }
        if(minIndex!=i){
            int tmp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = tmp;
            minHeapify(minIndex);
        }
    }

    public int extractMin(){
        if(index==0){
            throw new RuntimeException("min heap is empty");
        }
        if(index==1){
            index--;
            return data[0];
        }
        int tmp = data[0];
        data[0]=data[index-1];
        index--;
        minHeapify(0);
        return tmp;
    }

    public static void main(String[] args){
        MinHeap h=new MinHeap(11);
        h.insert(3);
        h.insert(2);
        h.insert(15);
        h.insert(20);
        System.out.print(h.extractMin());
    }
}
