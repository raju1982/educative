package string;

public class FindStringOrIndexOf {
    public static void main(String[] args) {
        System.out.println("\nResult = "
                + findMe("findMe", "Can you findMe from this String?"));
    }

    public static int findMe(String subString, String inputString) {
        int matches = -1;
        for (int outer = 0; outer <= inputString.length() - subString.length(); outer++){
            for (int inner = 0; inner < subString.length(); inner++){
                if (inputString.charAt(outer + inner) == subString.charAt(inner)){
                    // letter matched, proceed.
                    if (inner == subString.length()-1){
                        //last letter matched, so a word match at position "outer"
                        matches=outer;
                        //proceed with outer. Room for improvement: Skip next n chars beeing
                        // part of the match already.
                        break;
                    }
                }else{
                    //no match for "outer" position, proceed to next char.
                    break;
                }
            }
        }
        return matches;
    }

}
