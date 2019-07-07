package stackandQueue;

// Java Program to find minimum number of '(' or ')'
// must be added to make Parentheses string valid.

public class MinimumNumberOfParenthesesToBeAddedToMakeItValid
{

    /*
    Approach: We keep the track of balance of the string i:e the number of ‘(‘ minus the number of ‘)’. A string is valid if its balance is 0, and also every prefix has non-negative balance.

     Now, consider the balance of every prefix of S. If it is ever negative (say, -1), we must add a ‘(‘ bracket at the beginning. Also, if the balance of S is positive (say, +P), we must add P times ‘)’ brackets at the end.
     */
    // Function to return required minimum number
    static int minParentheses(String p)
    {

        // maintain balance of string
        int bal = 0;
        int ans = 0;
        int tmp = 0;

        for (int i = 0; i < p.length(); ++i) {

            //System.out.println("bal: "  + bal + " char: " + p.charAt(i));

            tmp = p.charAt(i) == '(' ? 1 : -1;
            bal = bal + tmp;

            // It is guaranteed bal >= -1
            if (bal == -1) {
                ans += 1;
                bal += 1;
            }
        }

        return bal + ans;
    }

    public static void main(String args[])
    {
        String p = "()";

        // Function to print required answer
        System.out.println(minParentheses(p));

        p = "()))((";
        System.out.println(minParentheses(p));
    }
}
//This code is contributed by Sumit Ghosh
