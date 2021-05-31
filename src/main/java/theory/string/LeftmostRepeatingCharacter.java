package theory.string;

import java.util.Arrays;

public class LeftmostRepeatingCharacter {
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

    public static void main(String[] args){
        System.out.println(solution("geeksforgeeks"));
    }
}
