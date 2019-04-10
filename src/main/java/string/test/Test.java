package string.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Test {


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


    public static void main(String[] args) {
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

        System.out.println(match ("aabbbbbcdda", "aabbbbbcdda"));
        System.out.println(match ("aabbbbbcdda", "aabb.bb.dda"));
    }


}