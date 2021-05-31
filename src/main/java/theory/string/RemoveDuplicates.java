package theory.string;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static String sol(String input){
        if(input == null || input.trim().length() == 0){
            throw new IllegalArgumentException();
        }

        input = input.trim();

        if(input.length() == 1){
            return input;
        }

        Set<Character> data = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.length(); i++){
            char tmp = input.charAt(i);
            if(!data.contains(tmp)){
                data.add(tmp);
                sb.append(tmp);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args){
        String input = "rakesh kandpal";
        System.out.println(sol(input));
    }
}
