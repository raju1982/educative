package string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;


public class firstNonRepeatingCharacter {
    static final int NO_OF_CHARS = 26;
    static char count[] = new char[NO_OF_CHARS];

    /* calculate count of characters
    in the passed string */
    static void getCharCountArray(String str) {
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i)-97]++;
    }

    /* The method returns index of first non-repeating
    character in a string. If all characters are repeating
    then returns -1 */
    static int firstNonRepeating(String str) {
        str = str.trim().toLowerCase();
        getCharCountArray(str);
        int index = -1, i;

        for (i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)-97] == 1) {
                index = i;
                break;
            }
        }

        return index;
    }

    // Driver method
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        int index = firstNonRepeating(str);

        System.out.println(index == -1 ? "Either all characters are repeating or string " +
                "is empty" : "First non-repeating character is " + str.charAt(index));

        String input="abc123de56";
        String numbers[] = input.split("\\[a-z]");
        System.out.println("Math");

        //String numbers[] = input.split("\\s+");

    }




    //2nd solution
    public static char getFirstNonRepeatedChar(String str) {

        Map<Character, Integer> counts = new LinkedHashMap<>(str.length());
        for (char c : str.toCharArray()) {
            counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
        }

        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("didn't find any non repeated Character");
    }




    /* * Finds first non repeated character in a String in just one pass.
* It uses two storage to cut down one iteration, standard space vs time
* trade-off.Since we store repeated and non-repeated character separately,
* at the end of iteration, first element from List is our first non * repeated character from String.
*/
    public static char firstNonRepeatingChar(String word) {
        Set<Character> repeating = new HashSet<>();
        List<Character> nonRepeating = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (repeating.contains(letter)) {
                continue;
            }
            if (nonRepeating.contains(letter)) {
                nonRepeating.remove((Character) letter);
                repeating.add(letter);
            } else {
                nonRepeating.add(letter);
            }
        }
        return nonRepeating.get(0);
    }

}
