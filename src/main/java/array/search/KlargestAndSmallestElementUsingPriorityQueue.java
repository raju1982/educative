package array.search;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KlargestAndSmallestElementUsingPriorityQueue {
    public static int[] randomNumberArray = new int[] {2, 5, 6, 21, 67, 88, 4, 1, 3, 9, 99};

    public static void main(String[] args) {
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


    public static void KlargestElement(int[] input, int size){
        PriorityQueue<Integer> data = new PriorityQueue<>(size);
        //load priority queue
        for(int i=0; i<size; i++){
            data.offer(input[i]);
        }

        for(int i=size; i<input.length; i++){
            if(input[i]>data.peek()){
                data.poll();
                data.offer(input[i]);
            }
        }
        System.out.println(Arrays.toString(data.toArray()));
    }


    public static void KSmallestElement(int[] input, int size){
        //max heap
        PriorityQueue<Integer> data = new PriorityQueue<>(size, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b-a;
            }
        } );

        //load priority queue
        for(int i=0; i<size; i++){
            data.offer(input[i]);
        }

        for(int i=size; i<input.length; i++){
            if(input[i]<data.peek()){
                data.poll();
                data.offer(input[i]);
            }
        }
        System.out.println(Arrays.toString(data.toArray()));
    }

}
