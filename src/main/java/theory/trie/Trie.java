package theory.trie;

public class Trie {

    static final int ALPHABET_SIZE = 26;

    //An array that consists of the children nodes.
    // The size of this array depends on the number of alphabets (26 for the English language).
    // By default, all elements are set to Null.
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;
    }

    static TrieNode root;

    static void insert(String key) {
        int index;
        TrieNode pCrawl = root;

        for (int level = 0; level < key.length(); level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null) {
                pCrawl.children[index] = new TrieNode();
            }
            pCrawl = pCrawl.children[index];
        }

        pCrawl.isEndOfWord = true;
    }


    static boolean search(String key) {
        int index;
        TrieNode pCrawl = root;

        for (int level = 0; level < key.length(); level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null) {
                return false;
            }
            pCrawl = pCrawl.children[index];
        }

        return (pCrawl != null && pCrawl.isEndOfWord);
    }

    static int countWords(TrieNode node){
        int result  = 0;
        if(node.isEndOfWord){
            result++;
        }
        for(int i=0; i<ALPHABET_SIZE; i++){
            if(node.children[i]!=null){
                result = result + countWords(node.children[i]);
            }
        }
        return result;
    }

    static int countWords(){
        return countWords(root);
    }

    static boolean isEmpty(TrieNode root) {
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (root.children[i] != null) {
                return false;
            }
        }
        return true;
    }

    static TrieNode remove(TrieNode root,String key, int i) {
        if (root == null) {
            return null;
        }

        if (i == key.length()) {
            if (root.isEndOfWord) {
                root.isEndOfWord = false;
            }
            if (isEmpty(root)) {
                root = null;
            }
            return root;
        }

        int index = key.charAt(i) - 'a';
        root.children[index] = remove(root.children[index], key, i + 1);

        if (isEmpty(root) && root.isEndOfWord == false) {
            root = null;
        }

        return root;
    }

    public static void main(String args[]) {
        String keys[] = {"bad", "bat", "geek", "geeks", "cat", "cut"};
        root = new TrieNode();

        for (int i = 0; i < keys.length; i++) {
            insert(keys[i]);
        }

        System.out.println (search("geek"));
        System.out.println (search("geeks"));
        System.out.println (search("ca") );

        root = remove(root, "zoo", 0);

        System.out.println(countWords());
    }
}
