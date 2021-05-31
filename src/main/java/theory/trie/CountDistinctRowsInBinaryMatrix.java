package theory.trie;

public class CountDistinctRowsInBinaryMatrix {


    //time complexity -> O(m*n)
    //auxilary space -> O(m*n)

    static final int rowCount = 4, columnCount = 3;
    static int mat[][] = {{1, 0, 0},
            {1, 1, 1},
            {1, 0, 0},
            {0, 1, 0}};

    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    static boolean insert(TrieNode root, int row) {
        TrieNode curr = root;
        boolean flag = false;

        for (int i = 0; i < columnCount; i++) {
            int index = mat[row][i];

            if (curr.child[index] == null) {
                curr.child[index] = new TrieNode();
                flag = true;
            }

            curr = curr.child[index];
        }

        return flag;
    }

    static int countDis() {
        TrieNode root = new TrieNode();
        int res = 0;
        for (int row = 0; row < rowCount; row++) {
            if (insert(root, row)) {
                res++;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        System.out.println(countDis());
    }
}