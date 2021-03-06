package string.search;

import java.util.*;

public class KthMostFrequentString {

    public static String kthMostFrequent(String[] strings, int k) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String s : strings) {
            Integer x = map.get(s);
            if (x == null) x = 0;
            map.put(s, ++x);
        }

        List<Map.Entry> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                Integer v1 = (Integer) ((Map.Entry) o1).getValue();
                Integer v2 = (Integer) ((Map.Entry) o2).getValue();
                return v1.compareTo(v2);
            }
        });

        if (list.size() > k) {
            return (String) (list.get(list.size()-k)).getKey();
        }
        return null;
    }


    public static String kthMostFrequent2(String[] strings, int k) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String s : strings) {
            Integer x = map.get(s);
            if (x == null) x = 0;
            map.put(s, ++x);
        }

        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return map.get(o2) - map.get(o1);
            }
        });

        if (list.size() > k) {
            return list.get(k-1);
        }
        return null;
    }

    public static void main(String[] args){
        //System.out.println(Arrays.toString(topKFrequent(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 3).toArray(new String[0])));
        System.out.println(kthMostFrequent(new String[] {"the", "day", "is", "sunny", "the", "the", "day", "sunny", "is", "is", "hello","is"}, 1));
        System.out.println(kthMostFrequent2(new String[] {"the", "day", "is", "sunny", "the", "the", "day", "sunny", "is", "is", "hello","is"}, 1));
        System.out.println(kthMostFrequent(new String[] {"the", "day", "is", "sunny", "the", "the", "day", "sunny", "is", "is", "hello","is"}, 2));
        System.out.println(kthMostFrequent2(new String[] {"the", "day", "is", "sunny", "the", "the", "day", "sunny", "is", "is", "hello","is"}, 2));
        System.out.println(kthMostFrequent(new String[] {"the", "day", "is", "sunny", "the", "the", "day", "sunny", "is", "is", "hello","is"}, 3));
        System.out.println(kthMostFrequent2(new String[] {"the", "day", "is", "sunny", "the", "the", "day", "sunny", "is", "is", "hello","is"}, 3));
    }
}
