package theory.string;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> finalResult = new ArrayList<>();
        Map<String , List<String>> result = new HashMap<>();

        for(String input : strs){
            char[] arr = input.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            List<String> tmp = null;
            if(result.containsKey(key)){
                tmp = result.get(key);
            }
            else{
                tmp = new ArrayList<>();
            }
            tmp.add(input);
            result.put(key, tmp);
        }

        for(Map.Entry<String , List<String>>  res : result.entrySet()){
            finalResult.add(new ArrayList<>(res.getValue()));
        }

        return finalResult;
    }


    public static void main(String[] args){
        List<List<String>> finalResult = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println(finalResult);
    }

}
