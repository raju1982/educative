package theory.recursion;

import java.util.HashSet;
import java.util.Set;

public class StringPermutation {

    //easy to understand
    static int count = 0;
    public static void sol(String input){
        solRec(input, "");
    }

    private static void solRec(String input, String currentString){
        if(input.length() == 0){
            System.out.println(currentString);
            count++;
            return;
        }

        Set<Character> data = new HashSet<>();
        for(int i=0; i<input.length(); i++){
            char tmp = input.charAt(i);
            if(!data.contains(tmp)){
                data.add(tmp);
                solRec(rmWord(input, i), currentString + tmp);
            }
        }
    }

    private static String rmWord(String input, int i){
        return input.substring(0, i) + input.substring(i+1);
    }

    public static void main(String[] args) {
        sol("ABC");
        System.out.println("count " + count);
        count = 0;
        sol("AAC");
        System.out.println("count " + count);
    }



}


//https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/


/*
 //hard to understand
    private static void permute(String str, int low, int high) {
        if (low == high) {
            System.out.println(str);
        }
        else {
            for (int i = low; i <= high; i++) {
                str = swap(str, low, i);
                permute(str, low + 1, high);
                str = swap(str, low, i);
            }
        }
    }
 */

/*
ABC
ACB
BAC
BCA
CBA
CAB

 */