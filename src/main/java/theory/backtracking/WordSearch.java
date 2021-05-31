package theory.backtracking;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private List<Pair> findAllMoves(boolean[][] visited, int i, int j) {
        List<Pair> pairs = new ArrayList<>();
        if (j - 1 >= 0 && !visited[i][j - 1]) {
            pairs.add(new Pair(i, j - 1));
        }
        if (j + 1 < visited[0].length && !visited[i][j + 1]) {
            pairs.add(new Pair(i, j + 1));
        }

        if (i - 1 >= 0 && !visited[i - 1][j]) {
            pairs.add(new Pair(i - 1, j));
        }
        if (i + 1 < visited.length && !visited[i + 1][j]) {
            pairs.add(new Pair(i + 1, j));
        }
        return pairs;
    }


    private boolean existRec(char[][] board, String word, StringBuilder currentWord, boolean[][] visited, int x, int y) {
        if (currentWord.toString().equalsIgnoreCase(word)) {
            return true;
        }

        for (Pair pair : findAllMoves(visited, x, y)) {
            currentWord.append(board[pair.x][pair.y]);
            visited[pair.x][pair.y] = true;
            if (existRec(board, word, currentWord, visited, pair.x, pair.y)) {
                return true;
            }
            visited[pair.x][pair.y] = false;
            currentWord.setLength(currentWord.length() - 1);
        }

        return false;
    }


    public boolean exist(char[][] board, String word) {
        StringBuilder sb = null;
        boolean[][] visited = null;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    sb = new StringBuilder();
                    visited = new boolean[board.length][board[0].length];
                    visited[i][j] = true;
                    sb.append(board[i][j]);
                    if (existRec(board, word, sb, visited, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(new WordSearch().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));

        System.out.println(new WordSearch().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));

        System.out.println(new WordSearch().exist(new char[][]{{'A'}}, "A"));
    }
}
