package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KlargestElementUsingPriorityQueue {
    public static int[] randomNumberArray = new int[] {2, 5, 6, 21, 67, 88, 4, 1, 3, 9, 99};

    public static void main(String[] args) throws heapFullException {
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

}
