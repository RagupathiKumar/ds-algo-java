package gcl65_2.Session5;

// https://leetcode.com/problems/number-of-islands/

class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(new NumberOfIslands().numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int numIslands = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    numIslands += 1;
                    dfs(grid, n, m, i, j);
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int n, int m, int i, int j) {
        // base case
        if (i < 0 || i == n || j < 0 || j == m || grid[i][j] != '1') {
            return; // border check and not a land
        }

        // recursive case
        grid[i][j] = '2'; // visited

        dfs(grid, n, m, i, j - 1); // left
        dfs(grid, n, m, i - 1, j); // top
        dfs(grid, n, m, i, j + 1); // right
        dfs(grid, n, m, i + 1, j); // down
    }

}