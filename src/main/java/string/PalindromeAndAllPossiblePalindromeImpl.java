package string;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.Set;
import java.util.HashSet;

public class PalindromeAndAllPossiblePalindromeImpl {

    public static boolean palindrome2(String inputA){

        if(inputA==null){
            throw new IllegalArgumentException();
        }

        if(inputA.length()==1){
            return true;
        }

        int min=0;
        int max=inputA.length()-1;

        while(min<max){
            if(inputA.charAt(min) != inputA.charAt(max)){
                return false;
            }
            min++;
            max--;
        }

        return true;
    }

    @Test
    public void test1(){
        assertTrue(palindrome2("madam"));
    }

    @Test
    public void test2(){
        assertFalse(palindrome2("rakesh"));
    }

    public static Set<String> substringSol(String inputA){
        Set<String> data = new HashSet<>();
        for(int i=0; i<inputA.length(); i++){
            for(int j=i+1; j<inputA.length(); j++){
                String tmp = inputA.substring(i,j);
                if(palindrome2(tmp)){
                    data.add(tmp);
                }
            }
        }
        return data;
    }

    public static void main(String[] args){
        Set<String> data = substringSol("aabbbaa");
        for(String tmp:data){
            System.out.println(data);
        }
    }

}


