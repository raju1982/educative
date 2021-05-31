package theory.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedParenthesis {
    public static boolean solution(String input, Map<Character, Character> data){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<input.length(); i++){
            char tmp = input.charAt(i);
            if(data.containsKey(tmp)){
                if(stack.isEmpty() || (stack.pop() != data.get(tmp))){
                    return false;
                }
            }
            else {
                stack.add(tmp);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        Map<Character, Character> data = new HashMap<>();
        data.put(')','(');
        data.put('}','{');
        data.put(']','[');
        System.out.println(solution("{()}([()])", data));
        System.out.println(solution("((())", data));
        System.out.println(solution("(()))", data));
    }
}
