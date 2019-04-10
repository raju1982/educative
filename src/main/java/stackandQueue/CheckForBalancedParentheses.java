package stackandQueue;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class CheckForBalancedParentheses {

    public static boolean CheckForBalancedParentheses(String input) {
        //char[] tmpArray=input.toCharArray();
        Set<Character> closingBracket = new HashSet<>();
        closingBracket.add('}');
        closingBracket.add(')');
        closingBracket.add(']');

        Map<Character, Character> mappingTable = new HashMap<>();
        mappingTable.put('}', '{');
        mappingTable.put(')', '(');
        mappingTable.put(']', '[');

        Stack<Character> tmpStack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char tmp = input.charAt(i);
            if (closingBracket.contains(tmp)) {
                if (tmpStack.peek() != mappingTable.get(tmp)) {
                    return false;
                }
            }
            tmpStack.add(tmp);
        }
        return true;
    }

    public static void main(String[] str) {
        System.out.println(CheckForBalancedParentheses("{[({})]}"));
        System.out.println(CheckForBalancedParentheses("[{(}]"));
    }

}
