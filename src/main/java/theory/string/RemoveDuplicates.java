package theory.string;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    //one solution
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


    //other solution
    public static String modifyString(String input){
        char[] arr = input.toCharArray();
        int writeIndex = 0;

        Set<Character> set = new HashSet<>();
        for(int readIndex=0; readIndex<input.length(); readIndex++){
            char tmp = arr[readIndex];
            if(!set.contains(tmp)){
                arr[writeIndex] = tmp;
                writeIndex++;
                set.add(tmp);
            }
        }

        return new String(arr, 0, writeIndex);
    }

    public static void main(String[] args){
        String input = "rakesh kandpal";
        System.out.println(sol(input));
    }
}
