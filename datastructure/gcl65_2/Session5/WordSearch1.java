package gcl65_2.Session5;

// https://leetcode.com/problems/word-search/

public class WordSearch1 {

    public static void main(String[] args) {

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(new WordSearch1().exist(board, "ABCCED"));
        System.out.println(new WordSearch1().exist(board, "SEE"));
        System.out.println(new WordSearch1().exist(board, "ABCB")); // false

        System.out.println(new WordSearch1().exist(new char[][] {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCESEEEFS"));
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (exist(board, i, j, n, m, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean exist(char[][] board, int i, int j, int n, int m, String word, int idx) {
        // base case
        if (i < 0 || i == n || j < 0 || j == m || board[i][j] != word.charAt(idx)) {
            return false;
        }

        if (idx == word.length() - 1) {
            return true;
        }

        // recursive case
        boolean exists = false;
        char ch = board[i][j];
        board[i][j] = '-'; // mark visited

        if (exist(board, i, j - 1, n, m, word, idx + 1) ||      // left
                exist(board, i - 1, j, n, m, word, idx + 1) ||  // up
                exist(board, i, j + 1, n, m, word, idx + 1) ||  // right
                exist(board, i + 1, j, n, m, word, idx + 1)) {  // down
            exists = true;
        }

        board[i][j] = ch; // backtracking
        return exists;
    }

}
