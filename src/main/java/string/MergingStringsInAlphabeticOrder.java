package string;

import java.util.Arrays;
public class MergingStringsInAlphabeticOrder {

    public static String solution(String inputA, String inputB){
        //illegalArgumentException -> null
        String input = inputA.trim() + inputB.trim();
        char[] inputArray = input.toCharArray();
        Arrays.sort(inputArray); //o
        return new String(inputArray);
    }

    public static void main(String[] args){
        System.out.println(solution("cnt", "ace"));
    }

}


