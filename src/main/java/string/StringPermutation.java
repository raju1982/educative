package string;


// Java program to print all permutations of a
// given string.
public class StringPermutation
{
    public static void main(String[] args)
    {
        String str = "ABC";
        int n = str.length();
        permute(str, 0, n-1);
    }

    /**
     * permutation function
     * @param str string to calculate permutation for
     * @param low starting index
     * @param high end index
     */
    private static void permute(String str, int low, int high)
    {
        System.out.println("begin: permute low " + low + " high " + high);
        if (low == high)
            System.out.println(str);
        else
        {
            for (int i = low; i <= high; i++)
            {
                str = swap(str,low,i);
                System.out.println("swap: " + str.charAt(low) + " " + str.charAt(i));
                permute(str, low+1, high);
                str = swap(str,low,i);
                System.out.println("swap: " + str.charAt(low) + " " + str.charAt(i));
            }
        }
        System.out.println("end: permute low " + low + " high " + high);
    }

    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}

// This code is contributed by Mihir Joshi
