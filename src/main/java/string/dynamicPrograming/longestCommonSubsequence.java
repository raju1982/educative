package string.dynamicPrograming;

/*
A string is said to be a child of a another string if it can be formed by deleting 0 or more characters from the other string. Given two strings of equal length, what's the longest string that can be constructed such that it is a child of both?

For example, ABCD and ABDC have two children with maximum length 3, ABC and ABD. They can be formed by eliminating either the D or C from both strings. Note that we will not consider ABCD as a common child because we can't rearrange characters and ABCD  ABDC.
 */

public class longestCommonSubsequence {

    public static int solution(String inputA, String inputB){
        //null check

        int[][] data = new int[inputA.length()][inputB.length()];
        int result = 0;

        for(int i=1; i<data.length; i++){
            for(int j=1; j<data[0].length; j++){
                if(inputA.charAt(i-1) == inputB.charAt(j-1)){
                    data[i][j] = data[j-1][i-1] + 1;
                }
                else{
                    data[i][j] = Math.max(data[i-1][j], data[i][j-1]);
                }
                if(result < data[i][j] ){
                    result = data[i][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        String str1 = "ABCDGHLQR";
        String str2 = "AEDPHR";
        System.out.println(solution(str1, str2));
    }


}
