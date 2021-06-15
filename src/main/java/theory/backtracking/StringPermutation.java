package theory.backtracking;

public class StringPermutation {

    //hard to understand
    private static void permute(String str, int low) {
        if (low == str.length()-1) {
            System.out.println(str);
        }
        else {
            for (int i = low; i < str.length(); i++) {
                str = swap(str, low, i);
                permute(str, low + 1);
                str = swap(str, low, i);
            }
        }
    }

    public static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        String str = "ABC";
        permute(str, 0);
    }

}
