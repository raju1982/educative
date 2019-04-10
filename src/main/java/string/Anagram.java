package string;

public class Anagram {

    public static void main(String[] args){
        System.out.println(anagramTest("Listen", "SILENT"));
        System.out.println(anagramTest("Liston", "SILENT"));
    }

    public static boolean anagramTest(String stringA, String stringB){

        if(stringA==null || stringB==null || stringA.length() != stringB.length()){
            return false;
        }

        char[] charA = stringA.toLowerCase().toCharArray();
        char[] charB = stringB.toLowerCase().toCharArray();
        int[] input = new int[26];

        for(int i=0 ; i<charA.length; i++) {
            input[charA[i]-97]++;
            input[charB[i]-97]--;
        }

        for(int i=0; i<input.length;i++){
            if(input[i] != 0){
                return false;
            }
        }
        return true;
    }
}
