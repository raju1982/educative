package theory.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeftmostRepeatingCharacter {
    //one solution
    public static int solution(String input){
        input = input.toLowerCase();
        int[] data = new int[26];
        Arrays.fill(data, -1);
        int result = -1;
        for(int i=0; i<input.length(); i++){
            int index = input.charAt(i)-97;
            if(data[index] == -1){
                data[index] = i;
            }
            else{
                if(result==-1){
                    result = i;
                }
                else{
                    result =  Math.min(result, data[index]);
                }
            }
        }
        return result;
    }

    //second solution
    public static char sol(String input){
        Map<Character, Integer> data = new HashMap<>();
        int minIndex=Integer.MAX_VALUE;
        for(int i=0; i<input.length(); i++){
            char tmp = input.charAt(i);
            if(data.containsKey(tmp)){
                minIndex = Math.min(data.get(tmp), minIndex);
                continue;
            }
            data.put(tmp, i);
        }

        return input.charAt(minIndex);
    }

    public static void main(String[] args){
        System.out.println(solution("geeksforgeeks"));
    }
}
