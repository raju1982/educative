package theory.dynamicprograming;

public class LongestCommonSubstring {
    static Integer[][][] memo;
    public static int findLongestCommonSubsequence(String s1, String s2, int s1Index, int s2Index, int length){
        if(s1Index==0 || s2Index==0){
            return length;
        }

        if(memo[s1Index][s2Index][length]!=null){
            return memo[s1Index][s2Index][length];
        }

        int val = length;
        if(s1.charAt(s1Index-1) == s2.charAt(s2Index-1)){
            val = findLongestCommonSubsequence(s1, s2, s1Index-1, s2Index-1, length+1);
        }

        memo[s1Index][s2Index][length] = Math.max(Math.max(findLongestCommonSubsequence(s1, s2, s1Index-1, s2Index, 0),
                findLongestCommonSubsequence(s1, s2, s1Index, s2Index-1, 0)), val);

        return memo[s1Index][s2Index][length];
    }

    public static void main(String[] args){
        String s1 = "abdca";
        String s2 = "cbda";
        int minLength = Math.min(s1.length(), s2.length());
        memo = new Integer[s1.length()+1][s2.length()+1][minLength];
        System.out.println(findLongestCommonSubsequence(s1, s2, s1.length(), s2.length(), 0));

        s1 = "passport";
        s2 = "ppsspt";
        minLength = Math.min(s1.length(), s2.length());
        memo = new Integer[s1.length()+1][s2.length()+1][minLength];
        System.out.println(findLongestCommonSubsequence(s1, s2, s1.length(), s2.length(), 0));
    }

}
