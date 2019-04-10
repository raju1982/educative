package dynamicprograming;

public class EditDistance {

    public static int editDistance(char[] strA, char[] strB) {

        int[][] tmp = new int[strA.length + 1][strB.length + 1];

        for (int i = 0; i < tmp[0].length; i++) {
            tmp[0][i] = i;
        }

        for (int i = 0; i < tmp.length; i++) {
            tmp[i][0] = i;
        }

        for (int i = 1; i <= strA.length; i++) {
            for (int j = 1; j <= strB.length; j++) {
                if (strA[i-1] == strB[j-1]) {
                    tmp[i][j] = tmp[i - 1][j - 1];
                }
                else {
                    tmp[i][j] = 1 + Math.min(Math.min(tmp[i - 1][j - 1], tmp[i - 1][j]), tmp[i][j - 1]);
                }
            }
        }

        return tmp[strA.length][strB.length];
    }


    public static void main(String[] args) {
        System.out.println(editDistance("azced".toCharArray(), "abcdef".toCharArray()));
    }


}
