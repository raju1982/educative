package string.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AnagramImpl{

    public static boolean isAnagram (String inputA, String inputB){
        if(inputA==null || inputB==null){
            throw new IllegalArgumentException();
        }

        inputA = inputA.trim().toLowerCase();
        inputB = inputB.trim().toLowerCase();

        if(inputA.length() != inputB.length()){
            return false;
        }

        int[] data = new int[26];

        for(int i=0; i<inputA.length(); i++){
            data[inputA.charAt(i)-97]++;
            data[inputB.charAt(i)-97]--;
        }

        for(int i=0; i<data.length; i++){
            if(data[i] != 0){
                return false;
            }
        }

        return true;
    }

    @Test
    public void test1(){
        Assert.assertTrue(isAnagram ("cinema", "iceman"));
    }

    @Test
    public void test2(){
        Assert.assertFalse(isAnagram ("cinemas", "iceman"));
    }
}


