package string;

import java.util.StringTokenizer;

// Java program to find Minimum Distance
// Between Words of a String
/*
Find minimum distance between two words (order preserved) in a big string.
For e.g 1. "hello how are you" - distance between "hello" and "you" is 3.
e.g 2. "hello how are hello you" - distance is 1
e.g 3. "you are hello" - distance is -1. Order of "hello" and "you" should be preserved.
e.g 4. "hello how are hello" - distance is -1 since "you" didnt occur even once.
 */
public class MinimumDistanceBetweenWordsOfAString {

    // Java program to extract words from
// a strung using stringstream
        static int distance(String s, String w1, String w2) {

            if (w1.equals(w2)) {
                return 0;
            }

            // get individual words in a list
            String[] words = s.split(" ");
            int n = words.length;

            // assume total length of the string as
            // minimum distance
            int min_dist = n;

            // Find the first occurrence of any of the two
            // numbers (w1 or w2) and store the index of
            // this occurrence in prev
            int prev = 0, i = 0;
            for (i = 0; i < n; i++) {
                if (words[i].equals(w1) || words[i].equals(w2)) {
                    prev = i;
                    break;
                }
            }
            // Traverse after the first occurrence
            while (i < n) {
                if (words[i].equals(w1) || words[i].equals(w2)) {

                    // If the current element matches with
                    // any of the two then check if current
                    // element and prev element are different
                    // Also check if this value is smaller than
                    // minimum distance so far
                    if ((!words[prev].equals(words[i])))
                        if((i - prev) < min_dist) {
                            min_dist = i - prev - 1;
                    }
                    prev = i;
                }
                i++;
            }
            return min_dist;
        }
// Driver code

        public static void main(String[] args) {
            String s = "geeks for geeks contribute practice";
            String w1 = "geeks";
            String w2 = "practice";
            System.out.println(distance(s, w1, w2));
// This code is contributed by princiRaj1992
        }



/*
    public static int distance2(String str,String a,String b){
        if (a.equals(b))
            return 0;
        int aIndex=-1;
        int bIndex=-1;
        int minDistance=Integer.MAX_VALUE;
        String[] aS=str.toLowerCase().split("[ \t]+");
        int i=0;
        for(String t:aS){
            if(t.equals(a)){
                aIndex=i;
            }
            if(t.equals(b)){
                bIndex=i;
            }
            if(aIndex!=-1 && bIndex!=-1){
                minDistance = minDistance > Math.abs(bIndex-aIndex) ? bIndex-aIndex : minDistance;
            }
            i++;
        }
        if(aIndex ==-1 || bIndex==-1)
            return -1;
        else
            return minDistance;
    }

    // Driver code
    public static void main(String args[]) {
        String s = "geeks for geeks contribute practice";
        String w1 = "geeks";
        String w2 = "practice";

        //System.out.println(distance(s, w1, w2));
        System.out.println(distance2(s, "practice", "geeks"));
    }

//contributed by Arnab Kundu
*/



}
