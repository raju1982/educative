package theory.trie.impl;

import java.util.Arrays;

class DictWord {

    public static boolean isFormationPossible(Trie trie, String word) {
        int length = word.length();

        if(length == 0){
            return true;
        }

        for(int i = 1; i <= length; i++) {
            //Slice the word into two strings in each iteration
            String first = word.substring(0, i);
            String second = word.substring(i);
            //If both substrings are present in the trie, the condition is fulfilled
            if(trie.search(first) && isFormationPossible(trie, second)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String args[]){
        // Input dict (use only 'a' through 'z' and lower case)
        String dict[] = {"the", "hello", "there", "answer","any", "dragon", "world", "their",  "inc"};

        //Create Trie and insert dictionary elements in it
        Trie trie = new Trie();

        for(int i = 0; i < dict.length; i++) {
            trie.insert(dict[i]);
        }

        System.out.println("Keys: "+ Arrays.toString(dict));

        if(isFormationPossible(trie, "helloworlddragon"))
            System.out.println("true");
        else
            System.out.println("false");

    }


}
