package string;
import java.util.Map;
import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    //the current substring with non-repeating characters with the help of a start and end index
    //the longest non-repeating substring output
    //a lookup table of already visited characters
    static String getUniqueCharacterSubstring(String input) {
        //character & last index on which it was present
        Map<Character, Integer> visited = new HashMap<>();
        String output = "";
        for (int start = 0, end = 0; end < input.length(); end++) {
            char currChar = input.charAt(end);
            //if character is present, then start will change
            //start will be last index + 1
            if (visited.containsKey(currChar)) {
                start = Math.max(visited.get(currChar)+1, start);
            }
            //always store the max length substring
            if (output.length() < end - start + 1) {
                output = input.substring(start, end + 1);
            }
            //store last index
            visited.put(currChar, end);
        }
        return output;
    }



    public static void main(String[] args){
        //System.out.println(getUniqueCharacterSubstring("pwwkew"));
        System.out.println(getUniqueCharacterSubstring("abcabcbb"));
        //System.out.println(getUniqueCharacterSubstring("bbbbb"));
    }
}

/*
wke
abc
b

 */