package theory.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {


    /*first question, print true or false based on whether we can break the string or not.*/
    public static boolean wordBreak(String input, List<String> wordDict) {
        if(input==null || input.trim().length() == 0){
            return false;
        }

        Map<String,Boolean> memo = new HashMap<>();

        return sol(input,  wordDict, 0, memo);
    }

    public static boolean sol(String input, List<String> dict, int startIndex, Map<String,Boolean> memo){

        if(input.length() == startIndex){
            return true;
        }

        String rest = input.substring(startIndex);

        if(memo.containsKey(rest)){
            return memo.get(rest);
        }

        for(int j = startIndex + 1; j<=input.length(); j++){
            String tmp = input.substring(startIndex, j);
            if(dict.contains(tmp)){
                if(sol(input, dict, startIndex + tmp.length(), memo)){
                    memo.put(rest, true);
                    return true;
                }
            }
        }

        memo.put(rest, false);
        return false;
    }

    public static void main(String[] args){
        List<String> dict = new ArrayList<>();
        dict.add("apple");
        dict.add("pear");
        dict.add("pier");
        dict.add("pie");


        System.out.println(wordBreak("applepie", dict));
        System.out.println(wordBreak("applepeer", dict));

        dict.clear();
        dict.add("leet");
        dict.add("code");
        System.out.println(wordBreak("leetcode", dict));

        dict.clear();
        dict.add("apple");
        dict.add("pen");
        System.out.println(wordBreak("applepenapple", dict));

        dict.clear();
        dict.add("cats");
        dict.add("dog");
        dict.add("sand");
        dict.add("and");
        dict.add("cat");
        System.out.println(wordBreak("catsandog", dict));

        dict.clear();
        dict.add("aaaa");
        dict.add("aaa");
        System.out.println(wordBreak("aaaaaaa", dict));

        dict.clear();
        dict.add("a");
        dict.add("aa");
        dict.add("aaa");
        dict.add("aaaa");
        dict.add("aaaaa");
        dict.add("aaaaaa");
        dict.add("aaaaaaa");
        dict.add("aaaaaaaa");
        dict.add("aaaaaaaaa");
        dict.add("aaaaaaaaaa");
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", dict));
    }



}
