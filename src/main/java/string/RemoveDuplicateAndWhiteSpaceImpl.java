package string;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class RemoveDuplicateAndWhiteSpaceImpl {
    public static String removeDuplicate(String input){
        StringBuilder result = new StringBuilder();
        Set<Character> data = new HashSet<>();
        for(int i=0 ; i<input.length(); i++){
            char tmp = input.charAt(i);
            if(!data.contains(tmp)){
                result.append(tmp);
                data.add(tmp);
            }
        }
        return result.toString();
    }

    public static char[] removeWhiteSpace2(char[] input){
        int readPointer=0, writePointer=0;

        for(; readPointer<input.length;){
            if(!(input[readPointer] == ' ') && !(input[readPointer] == '\t')){
                input[writePointer] = input[readPointer];
                writePointer++;
            }
            readPointer++;
        }

        if(writePointer<input.length) {
            input[writePointer] = '\0';
        }

        return input;
    }

    public static String removeWhiteSpace(String input){
        StringBuilder result = new StringBuilder();
        for(int i=0 ; i<input.length(); i++){
            char tmp = input.charAt(i);
            if(tmp != ' '){
                result.append(tmp);
            }
        }
        return result.toString();
    }

    public static void main(String[] args){
        System.out.println(removeDuplicate("rakesh"));
        System.out.println(removeDuplicate("rakesh kandpal"));

        System.out.println(removeWhiteSpace("ra     kesh kan  dpal"));
        System.out.println(Arrays.toString(removeWhiteSpace2("ra     kesh kan  dpal".toCharArray())));
    }
}
