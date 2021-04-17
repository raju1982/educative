package theory.heap;


import java.util.PriorityQueue;

public class KClosestElements {
    static class Pair {
        int key;
        int value;
        Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public static void printKClosest(int[] data, int count, int value) {
        PriorityQueue<Pair> queue = new PriorityQueue<>((p1, p2) -> p2.value - p1.value);
        for(int i=0; i<data.length; i++){
            if(i<count){
                queue.add(new Pair(data[i], Math.abs(value-data[i])));
            }
            else{
                int tmp = Math.abs(value-data[i]);
                if(tmp<queue.peek().value){
                    queue.poll();
                    queue.add(new Pair(data[i], tmp));
                }
            }
        }

        while(!queue.isEmpty()){
            System.out.print(queue.poll().key + " ");
        }
    }

    public static void main (String[] args)
    {
       int value=35; int count = 3;
        printKClosest(new int[] {10,30,5,40,38,80,70},count,value);
    }

}

