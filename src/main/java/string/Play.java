package string;

import java.util.Set;
import java.util.HashSet;

public class Play {


    public static String reverse(String input){
        char[] data = input.toCharArray();

        StringBuilder str = new StringBuilder();
        for(int i=data.length-1; i>=0; i--){
            str.append(data[i]);
        }

        return str.toString();
    }


    public static boolean palindrome(String args){
        char[] input = args.toLowerCase().toCharArray();

        for(int i=0, j=args.length()-1; i<j ; i++,j--){
            if(input[i] != input[j]){
                return false;
            }
        }
        return true;
    }


    public static void LexicographicallySubstring(String input, int k){
        String current = input.substring(0, k);
        String min = current;
        String max = current;

        for(int i=k; i<input.length(); i++){
            current = input.substring(1, k) + input.charAt(i);
            if(current.compareTo(min) < 0){
                min = current;
            }
            if(current.compareTo(max) > 0){
                max = current;
            }
        }

        System.out.println(min);
        System.out.println(max);

    }

    public static boolean anagram(String input1, String input2){

        if(input1==null || input2==null){
            throw new IllegalArgumentException();
        }

        if(input1.length() != input2.length()){
            return false;
        }

        char[] input1Array = input1.toLowerCase().toCharArray();
        char[] input2Array = input2.toLowerCase().toCharArray();
        int[] data = new int[26];

        for(int i=0 ; i<input1Array.length; i++){
            data[input1Array[i]-97]++;
            data[input2Array[i]-97]--;
        }


        for(int i=0; i<data.length; i++){
            if(data[i] != 0){
                return false;
            }
        }
        return true;
    }


    public static String removeDuplicate(String str){
        //illegal argument exception
        Set<Character> data = new HashSet<>();
        StringBuilder strBuilder = new StringBuilder();

        for(int i=0; i< str.length(); i++){
            char tmp = str.charAt(i);
            if(!data.contains(tmp)){
                strBuilder.append(tmp);
                data.add(tmp);
            }
        }
        return strBuilder.toString();
    }

    public static String removeWhiteSPace(String str){
        //illegal argument exception
        Set<Character> data = new HashSet<>();
        data.add(' ');
        StringBuilder strBuilder = new StringBuilder();

        for(int i=0; i< str.length(); i++){
            char tmp = str.charAt(i);
            if(!data.contains(tmp)){
                strBuilder.append(tmp);
            }
        }
        return strBuilder.toString();
    }

    public static void main(String[] args){
        System.out.println(palindrome("rakeshk"));
        System.out.println(palindrome("madam"));

        System.out.println(reverse("rakesh"));
        System.out.println(reverse("madam"));

        LexicographicallySubstring("rakesh kandpal", 3);

        System.out.println(anagram("Listen", "SILENT"));
        System.out.println(anagram("Liston", "SILENT"));

        System.out.println(removeDuplicate("rakesh kandpal"));

        System.out.println(removeWhiteSPace("   Quick brown fox jumped   over lazy   dog           "));
    }


}
