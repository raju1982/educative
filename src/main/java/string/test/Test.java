package string.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Test {

/*
    public static boolean can_segment_string(String s, Set<String> dict, Set<String> solved) {
        for (int i = 1; i <= s.length(); ++i) {
            String first = s.substring(0, i);
            if (dict.contains(first)) {
                String second = s.substring(i);

                if (second == null || second.length() == 0 || dict.contains(second)) {
                    return true;
                }

                if (!solved.contains(second)) {
                    if (can_segment_string(second, dict, solved)) {
                        return true;
                    }
                    solved.add(second);
                }
            }
        }
        return false;
    }

    public static boolean can_segment_string(String str, Set dictionary, Set<String> solved, Set<String> processed){

        if(solved.contains(str) || dictionary.contains(str) || str.trim().length() == 0){
            solved.add(str);
            return true;
        }

        if(processed.contains(str)){
            return false;
        }

        for(int i=0; i<str.length(); i++){
            String tmp = str.substring(0,i);
            String rest = str.substring(i);
            if(dictionary.contains(tmp)){
                solved.add(tmp);
                if(can_segment_string(rest, dictionary, solved, processed)){
                    return true;
                }
                else{
                    processed.add(rest);
                    continue;
                }
            }
        }

        return false;
    }


    public static boolean match (String text, String pattern){
        //text==null || pattern==null  illegalArgumentException

        text = text.toLowerCase();
        pattern = pattern.toLowerCase();

        if(text.equals(pattern)){
            return true;
        }

        for(int i=0,j=0; i<text.length() && j<pattern.length();){
            if(pattern.charAt(j) == '.'|| text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
                continue;
            }
      else{
                return false;
            }
        }

        return true;
    }
*/

    public static int binarySearch(String[] input, int start, int end, String searchParam){
        if(start>end){
            return -1;
        }

        int mid = start + (end-start)/2;

        String midValue = input[mid].trim();

        if(midValue.length() == 0){
            int i = mid-1;
            int j = mid+1;

            while(true){
                if(i<start && j>end){
                    return -1;
                }
                if(i>=start && input[i].trim().length() != 0){
                    mid = i;
                    break;
                }
                if(j<=end && input[j].trim().length() != 0){
                    mid = j;
                    break;
                }
                i--;
                j++;
            }
        }
        midValue = input[mid].trim();
        int tmp = midValue.compareTo(searchParam);

        if(tmp == 0){
            return mid;
        }
        else if(tmp>0){
            return binarySearch(input, start, mid-1, searchParam);
        }
        else{
            return binarySearch(input, mid+1, end, searchParam);
        }
    }

    public static String[] topKwords(String input, int size){
        String[] data = input.split(" ");

        Map<String, Integer> countMap = new HashMap<>();

        for(int i=0; i<data.length; i++){
            if(countMap.containsKey(data[i])){
                countMap.put(data[i], countMap.get(data[i]) + 1);
            }
            else{
                countMap.put(data[i], 1);
            }
        }

        PriorityQueue<Integer> pQueue = new PriorityQueue<>(size);

        for(Map.Entry<String, Integer> tmp : countMap.entrySet()){

            int val = tmp.getValue();

            if(pQueue.size()<size){
                pQueue.offer(val);
            }
            else{
                if(val > pQueue.peek()){
                    pQueue.poll();
                    pQueue.offer(val);
                }
            }
        }

        String[] solution = new String[size];
        int i = 0;

        for(Map.Entry<String, Integer> tmp : countMap.entrySet()){
            if(pQueue.contains(tmp.getValue())){
                solution[i++] = tmp.getKey();
            }
        }

        return solution;
    }


    public static void main(String[] args){
        String str = "hi this is new way to hi ui is new from is this new hi is";
        String[] solution = topKwords(str, 3);
        System.out.println(Arrays.toString(solution));
    }

/*
    public static void main(String[] args){
        String[] input = new String[]{"at", "ball", "", "car", "", "dad", "", "","eight", "","","","high"};
        System.out.println(binarySearch(input, 0, input.length, "eight"));
        System.out.println(binarySearch(input, 0, input.length, "dime"));
    }
*/

    //public static void main(String[] args) {
        /*Set<String> dict = new HashSet<String>();
        String s = new String();
        s = "applepie";

        dict.add("pie");
        dict.add("pear");
        dict.add("apple");
        dict.add("peach");
        Set<String> solved = new HashSet<String>();
        Set<String> processed = new HashSet<String>();
        System.out.println("Result = " + can_segment_string(s, dict,solved,processed));

        Set<String> dictionary = new HashSet<String>();
        dictionary.add("I");
        dictionary.add("like");
        dictionary.add("had");
        dictionary.add("play");
        //dictionary.add("to");
        dictionary.add("liketo");
        String str = "Ihadliketoplay";

        solved = new HashSet<String>();
        processed = new HashSet<String>();
        System.out.println("Result = " + can_segment_string(str, dictionary ,solved,processed));
        */
        //System.out.println(breakWord(str.toCharArray(),0,dictionary));
        //System.out.println(breakWord(s.toCharArray(),0,dict));

        //System.out.println(match ("aabbbbbcdda", "aabbbbbcdda"));
        //System.out.println(match ("aabbbbbcdda", "aabb.bb.dda"));
    //}


}