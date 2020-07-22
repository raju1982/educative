package com.ds.algo.string;

public class PatternMatchingAlgo {

    //https://www.youtube.com/watch?v=KG44VoDtsAA
    //https://www.youtube.com/watch?v=GTJr8OvyEVQ



    /**
     * Compute temporary array to maintain size of suffix which is same as prefix
     * Time/space complexity is O(size of pattern)
     */
    private static int[] computeTemporaryArray(char pattern[]){
        int [] lps = new int[pattern.length];
        //j=[i-1]
        int j =0;
        for(int i=1; i < pattern.length;){
            if(pattern[i] == pattern[j]){
                lps[i] = j + 1;
                j++;
                i++;
            }else{
                if(j != 0){
                    j = lps[j-1];
                }else{
                    lps[i] =0;
                    i++;
                }
            }
        }
        return lps;
    }

    /**
     * KMP algorithm of pattern matching.
     */
    public static boolean KMP(char []text, char []pattern){

        int lps[] = computeTemporaryArray(pattern);
        int i=0;
        int j=0;
        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
            }else{
                if(j!=0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        if(j == pattern.length){
            return true;
        }
        return false;
    }

    public static void main(String args[]){
        String str = "abcxabcdabcdabcy";
        String pattern = "abcdabcy";
        boolean result = KMP(str.toCharArray(), pattern.toCharArray());
        System.out.println(result);
        System.out.println(KMP("abcxabcdabcdabcy".toCharArray(), "abcxdabcy".toCharArray()));
    }

}

