package string;

import java.util.HashSet;
import java.util.Set;

public class StringHasUniqueChars {

    //best solution
    public static boolean hasUniqueChar (String inputA){
        //null check

        if(inputA.length() == 1 ){
            return true;
        }

        if(inputA.length() > 26 ){
            return false;
        }

        Set<Character> data = new HashSet<Character>();

        for(int i=0; i<inputA.length(); i++){
            data.add(inputA.charAt(i));
        }

        if(data.size() == inputA.length()){
            return true;
        }

        return false;
    }


    public static boolean isUnique(String input){

        int length = input.length();
        input = input.trim();

        if(length > 26){
            return false;
        }

        boolean[] answer = new boolean[26];


        for(int i=0; i<length ; i++){
            if(answer[input.charAt(i)-97]){
                return false;
            }
            else{
                answer[input.charAt(i)-97] = true;
            }
        }

        return true;
    }


    /* Assumes only letters a through z. */
    public static boolean isUniqueChars(String str) {
        if (str.length() > 26) { // Only 26 characters
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(isUnique("rakeshkandpal"));
        System.out.println(isUnique("rakeshzgndpul"));

        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars(word));
        }
    }

}
