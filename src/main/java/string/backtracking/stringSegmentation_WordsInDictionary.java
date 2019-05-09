package string.backtracking;

import java.util.Set;
import java.util.HashSet;

class stringSegmentation_WordsInDictionary {
    public static boolean can_segment_string(String s, Set<String> dict) {
        Set<String> solved = new HashSet<String>();
        //solved contains string that are not in dict.
        return can_segment_string(s, dict, solved);
    }

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

    public static String breakWord(char[] str,int low,Set<String> dictionary){
        StringBuffer buff = new StringBuffer();
        for(int i= low; i < str.length; i++){
            buff.append(str[i]);
            if(dictionary.contains(buff.toString())){
                String result = breakWord(str, i+1, dictionary);
                if(result != null){
                    return buff.toString() + " " + result;
                }
            }
        }
        if(dictionary.contains(buff.toString())){
            return buff.toString();
        }
        return null;
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<String>();
        String s = new String();
        s = "applepie";

        dict.add("pie");
        dict.add("pear");
        dict.add("apple");
        dict.add("peach");

        System.out.println("Result = " + can_segment_string(s, dict));

        Set<String> dictionary = new HashSet<String>();
        dictionary.add("I");
        dictionary.add("like");
        dictionary.add("had");
        dictionary.add("play");
        dictionary.add("to");
        dictionary.add("Ihadrequesttoplay");
        String str = "Ihadrequesttoplay";

        System.out.println("Result = " + can_segment_string(str, dictionary));

        System.out.println(breakWord(str.toCharArray(),0,dictionary));
        System.out.println(breakWord(s.toCharArray(),0,dict));
    }
}