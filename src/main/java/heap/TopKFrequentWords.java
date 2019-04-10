package heap;

import java.util.*;


public class TopKFrequentWords {

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        Comparator<String> stringLengthComparator = new Comparator<String>() {
            @Override
            public int compare(String w1, String w2) {
                return count.get(w1).equals(count.get(w2)) ? w2.compareTo(w1) : count.get(w1) - count.get(w2) ;
            }
        };

        PriorityQueue<String> heap = new PriorityQueue<String>(stringLengthComparator);

        for (String word: count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<String> ans = new ArrayList();

        while (!heap.isEmpty()) {
            ans.add(heap.poll());
        }

        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args){
        //System.out.println(Arrays.toString(topKFrequent(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 3).toArray(new String[0])));

        System.out.println(Arrays.toString(topKFrequent(new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 3).toArray(new String[0])));
    }
}
