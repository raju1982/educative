package string.backtracking;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class regxMatch {

    static boolean regx_match_rec(String text, String pattern) {
        //base case
        if (text.isEmpty() && pattern.isEmpty()) {
            return true;
        }

        //Here 'b*' can match with 0 or more b's in the text.
        // So, we need to match the remaining pattern i.e. 'c' with 'bbbc', 'bbc', 'bc' and 'c'.
        if (pattern.length() > 1 && pattern.charAt(1) == '*') {

            String remaining_pattern = pattern.substring(2);
            String remaining_text = text;

            for (int i = 0; i < text.length() + 1; ++i) {

                if (regx_match_rec(remaining_text, remaining_pattern)) {
                    return true;
                }

                if (remaining_text.isEmpty()) {
                    return false;
                }

                if (pattern.charAt(0) != '.' &&
                        remaining_text.charAt(0) != pattern.charAt(0)) {
                    return false;
                }

                remaining_text = remaining_text.substring(1);
            }
        }

        if (text.isEmpty() || pattern.isEmpty()) {
            return false;
        }

        //Handling the '.' operator is a also very easy as it can match with any character in the text.

        //Suppose the given text is 'fabbbc' and the given pattern is '.ab*c'.
        // We'll start matching from the first character of both the text and the pattern.
        // The first character of the pattern is '.' and the first character of the text is 'f'.
        // As '.' matches with any character, they match. Now, we'll match the remaining text and the remaining pattern recursively

        //In this solution, we use indices of text and pattern instead of creating sub-strings and pass the same strings in the recursive calls.

        if (pattern.charAt(0) == '.' || pattern.charAt(0) == text.charAt(0)) {
            String remaining_text = "";
            if (text.length() >= 2) {
                remaining_text = text.substring(1);
            }

            String remaining_pattern = "";
            if (pattern.length() >= 2) {
                remaining_pattern = pattern.substring(1);
            }

            return regx_match_rec(remaining_text, remaining_pattern);
        }

        return false;
    }

    static boolean regx_match(String text, String pattern) {
        return regx_match_rec(text, pattern);
    }

    public static void test(String s, String p) {
        boolean output2 = regx_match(s, p);

        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(s);

        if (output2) {
            System.out.println(s + " " + p + " matched - ");
        } else {
            System.out.println(s + " " + p + " did not match - ");
        }
    }



    public static void main(String[] args) {
        test("abb", "abb");
        test("abbc", "ab*c");
        test("abb", "ab*");

        test("", "b*c");
        test("a", "ab*");
        test("aaabbbbbcccd", "a*bbb*.*d");
        test("aaabbbbbcccde", "a*bbb*.*d");
        test("aabcd", "aa*d");


        test("aaabbbbbcccd", "a*bbb*c*d");
        test("a", "ab*");

        test("b", "b*");

        test("", "aa*d");
        test("", "a*");
        test("b", "b*c");

    }
}





    /*
    static boolean match(String text, String pattern, int textIndex, int patternIndex) {
        //base case
        if (text.length() == textIndex && pattern.length() == patternIndex) {
            return true;
        }

        if (patternIndex < pattern.length() - 1 && pattern.charAt(patternIndex + 1) == '*') {

            for (int k = textIndex; k <= text.length(); ++k) {
                if (match(text, pattern, k, patternIndex + 2)) {
                    return true;
                }
                //not single text string matched with pattern.
                if (k >= text.length()) {
                    return false;
                }
                //
                if (pattern.charAt(patternIndex) != '.' && text.charAt(k) != pattern.charAt(patternIndex)) {
                    return false;
                }
            }
        }  //Handling the '.' operator is a also very easy as it can match with any character in the text.

           //Suppose the given text is 'fabbbc' and the given pattern is '.ab*c'.
        // We'll start matching from the first character of both the text and the pattern.
        // The first character of the pattern is '.' and the first character of the text is 'f'.
        // As '.' matches with any character, they match. Now, we'll match the remaining text and the remaining pattern recursively

        //In this solution, we use indices of text and pattern instead of creating sub-strings and pass the same strings in the recursive calls.
        else if(textIndex < text.length() && patternIndex < pattern.length() && (pattern.charAt(patternIndex) == '.' || pattern.charAt(patternIndex) == text.charAt(textIndex))) {
            return match(text, pattern, textIndex + 1, patternIndex + 1);
        }

        return false;
    }
    public static boolean match(String text, String pattern) {
        return match(text, pattern, 0, 0);
    }
    public static void test(String text, String pattern) {
        boolean output = match(text, pattern);

        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher(text);

        if (output) {
            System.out.println(text + " " + pattern + " matched - ");
        } else {
            System.out.println(text + " " + pattern + " did not match - ");
        }
    }
    public static void main(String[] args) {
        test("abb", "abb");
        test("abbc", "ab*c");
        test("abb", "ab*");

        test("", "b*c");
        test("a", "ab*");
        test("aaabbbbbcccd", "a*bbb*.*d");
        test("aaabbbbbcccde", "a*bbb*.*d");
        test("aabcd", "aa*d");


        test("aaabbbbbcccd", "a*bbb*c*d");
        test("a", "ab*");

        test("b", "b*");

        test("", "aa*d");
        test("", "a*");
        test("b", "b*c");

    }

}
     */