package string;

public class PatternMatchingAlgo {

    /* brute force solution*/
    public static boolean hasSubstring(char[] text, char[] pattern){
        int i=0;
        int j=0;
        int k = 0;
        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
            }else{
                j=0;
                k++;
                i = k;
            }
        }
        if(j == pattern.length){
            return true;
        }
        return false;
    }


    /**
     * Compute temporary array to maintain size of suffix which is same as prefix
     * Time/space complexity is O(size of pattern)
     */
    private static int[] computeTemporaryArray(char pattern[]){
        int [] lps = new int[pattern.length];
        int index =0;
        for(int i=1; i < pattern.length;){
            if(pattern[i] == pattern[index]){
                lps[i] = index + 1;
                index++;
                i++;
            }else{
                if(index != 0){
                    System.out.println(index);
                    System.out.println(lps[index-1]);
                    index = lps[index-1];
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
        String subString = "abcdabcy";
        boolean result = KMP(str.toCharArray(), subString.toCharArray());
        System.out.print(result);
    }

}



/*
    public static int matchIndex(String input, String pattern){
        int count;
        int index = -1;
        int jump;
        for(int i=0; i<input.length(); i++){
            count = 0;
            index = i;
            jump=0;
            for(int j=0; j<pattern.length(); j++){
                if(input.charAt(i+jump) == pattern.charAt(j)){
                    count++;
                    jump++;
                }
                else{
                    break;
                }
            }
            if(count == pattern.length()){
                break;
            }
            else{
                index=-1;
            }
        }
        return index;
    }

    public static void main(String[] args){
        System.out.println(matchIndex("abcbcglx", "bcgll"));
        System.out.println(matchIndex("abcbcgll", "bcgll"));
    }
 */