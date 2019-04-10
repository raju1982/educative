package array.play;

public class Test {

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

    public static void main(String[] args){
        System.out.println(matchIndex("abcbcglx", "bcgll"));
        System.out.println(matchIndex("abcbcgll", "bcgll"));

        System.out.println(hasSubstring("abcbcglx".toCharArray(), "bcgll".toCharArray()));
        System.out.println(hasSubstring("abcbcgll".toCharArray(), "bcgll".toCharArray()));
    }
}
