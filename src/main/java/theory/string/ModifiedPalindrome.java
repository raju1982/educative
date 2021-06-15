package theory.string;

public class ModifiedPalindrome {

    public static boolean solution(String input){

        if(input==null){
            throw new IllegalArgumentException();
        }

        input = input.toLowerCase();

        int i=0;
        int j=input.length()-1;


        while(i<j){

            while(i<j && !isAlphaNumeric(input.charAt(i))){
                i++;
            }

            while(i<j && !isAlphaNumeric(input.charAt(j))){
                j--;
            }

            if(i>=j){
                break;
            }

            if(input.charAt(i)!=input.charAt(j)){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    private static boolean isAlphaNumeric(Character ch){
        return Character.isDigit(ch) || Character.isLetter(ch);
    }

    public static void main(String[] args){
        System.out.println(solution("A man, a plan, a canal: Panama"));
    }


}
