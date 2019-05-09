package string;

// Java program to count special
// Palindromic substring

import java.lang.*;

public class CountSpecialPalindromesInAString {

    // Driver code
    public static void main(String args[]) {
        String str = "abcbaba";
        System.out.println(count(str));
        //System.out.println(CountSpecialPalindrome(str));
        str="mnonopoo";
        System.out.println(count(str));
    }

    public static int count(String str){
        int count = 1;
        int[] sol = new int[str.length()];
        int i=0;
        int result = 0;
        for(;i<str.length()-1; i++){
            if(str.charAt(i) != str.charAt(i+1)){
                result = result + (count * (count + 1) / 2);
                sol[i] = count;
                count = 1;
            }
            else {
                count++;
            }
        }
        result = result +  (count * (count + 1) / 2);
        if(str.charAt(str.length()-1) == str.charAt(str.length()-2)) {
            sol[--i] = count;
        }
        else{
            sol[i] = count;
        }

        for(int j=0 ; j<str.length()-1; j++){
            if((j>0 && str.charAt(j-1) == str.charAt(j+1)) && (str.charAt(j-1) != str.charAt(j))){
                result = result + Math.min(sol[j-1], sol[j+1]);
            }
        }

        return result;
    }
}
