package string;

public class palindromeWIthSpecialCharacterAndNumberRemoveSpecialCharacter {
    public static void main(String[] args){
        System.out.println(palindromeCheck("madam"));
        System.out.println(palindromeCheck("rakesh"));
        System.out.println(palindromeCheck("9Red rum, sir, is murder9"));
    }

    public static boolean palindromeCheck(String input){

        input = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if(input == null || input.trim().length() <2){
            return false;
        }

        char[] charArray = input.toLowerCase().toCharArray();

        for(int i=0; i<charArray.length/2; i++){
            if(charArray[i] != charArray[charArray.length-1-i]){
                return false;
            }
        }

        return true;
    }
}
