package string;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
 */

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        String ref = strs[0];

        for (int i = 0; i < ref.length(); i++) {
            char c = ref.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                System.out.println(strs[j]);
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return ref.substring(0, i);
                }
            }
        }

        return ref;
    }

    public static void main(String[] args){
        System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));
    }
}

