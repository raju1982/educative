package string.search;

import java.util.*;

public class TopKFrequentElements {
    public static void topKFrequentElement(String[] input, int size) {
        Map<String, Integer> data = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            String tmp = input[i];
            if (data.containsKey(tmp)) {
                data.put(tmp, data.get(tmp) + 1);
            } else {
                data.put(tmp, 1);
            }
        }

        PriorityQueue<String> prQueue = new PriorityQueue<>(size, Comparator.comparingInt(data::get));

        /*
                PriorityQueue<String> prQueue = new PriorityQueue<>(size, new Comparator<String>() {
            public int compare(String strA, String strB) {
                return data.get(strA) - data.get(strB);
            }
        } );

         PriorityQueue<String> prQueue = new PriorityQueue<>(size, (strA, strB) -> data.get(strA) - data.get(strB));
         */


        for (Map.Entry<String, Integer> tmp : data.entrySet()) {
            prQueue.add(tmp.getKey());
            if (prQueue.size() > 3) {
                prQueue.poll();
            }
        }

        System.out.println(Arrays.toString(prQueue.toArray()));
    }

    public static void main(String[] args){
        String str = "hi this is new way to hi ui is new from is this new hi is";
        String[] input = str.split(" ");
        topKFrequentElement(input,3);
    }

}

/*
class Pair{
    int num;
    int count;
    public Pair(int num, int count){
        this.num=num;
        this.count=count;
    }
}

 class TopKFrequentWords {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //count the frequency for each element
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }

        // create a min heap
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparing(Pair->Pair.count));

        //maintain a heap of size k.
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            Pair p = new Pair(entry.getKey(), entry.getValue());
            queue.offer(p);
            if(queue.size()>k){
                queue.poll();
            }
        }

        //get all elements from the heap
        List<Integer> result = new ArrayList<>();
        while(queue.size()>0){
            result.add(queue.poll().num);
        }

        //reverse the order
        Collections.reverse(result);

        return result;
    }
}
 */

