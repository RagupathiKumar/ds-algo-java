package gcl65_2.Session5;

// https://leetcode.com/problems/surrounded-regions/description/

import java.util.Arrays;

public class SurroundedRegions {

    public static void main(String[] args) {
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        new SurroundedRegions().solve(board);
        for (char[] chars : board) { System.out.println(Arrays.toString(chars)); }

        System.out.println();
        char[][] board2 = {
                {'X','X','X','X'},
                {'X','O','O','O'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        new SurroundedRegions().solve(board2);
        for (char[] chars : board2) { System.out.println(Arrays.toString(chars)); }

        System.out.println();
        char[][] board3 = {
                {'O','X','X','O'},
                {'X','O','X','O'},
                {'X','O','O','X'},
                {'X','O','X','O'},
                {'X','O','O','O'}
        };
        new SurroundedRegions().solve(board3);
        for (char[] chars : board3) { System.out.println(Arrays.toString(chars)); }

    }

    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;

        // visit borders and its connected nodes
        for (int j = 0; j < m; j++) {
            solve(board, 0, j, n, m);
            solve(board, n - 1, j, n, m);
        }
        for (int i = 0; i < n; i++) {
            solve(board, i, 0, n, m);
            solve(board, i, m - 1, n, m);
        }

        // cannot capture visited nodes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'V') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void solve(char[][] board, int i, int j, int n, int m) {
        // base case
        if (i < 0 || i == n || j < 0 || j == m || board[i][j] != 'O') { // border check and visited
            return;
        }

        // recursive case
        board[i][j] = 'V'; // visited

        solve(board, i, j - 1, n, m); // left
        solve(board, i - 1, j, n, m); // up
        solve(board, i, j + 1, n, m); // right
        solve(board, i + 1, j, n, m); // down
    }

}
