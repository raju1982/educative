package string;

public class MakingAnagrams {
    public static int anagramTest(String stringA, String stringB){

        if(stringA==null || stringB==null){
            throw new IllegalArgumentException();
        }

        char[] charA = stringA.toLowerCase().toCharArray();
        char[] charB = stringB.toLowerCase().toCharArray();
        int[] input = new int[26];

        for(int i=0 ; i<charA.length; i++) {
            input[charA[i]-97]++;
        }

        for(int i=0 ; i<charB.length; i++) {
            input[charB[i]-97]--;
        }

        int count=0;
        for(int i=0; i<input.length;i++){
            if(input[i] != 0){
                count = count + Math.abs(input[i]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(anagramTest("cde", "abc"));
        System.out.println(anagramTest("showman", "woman"));
    }
}
