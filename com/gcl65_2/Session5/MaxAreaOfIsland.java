package gcl65_2.Session5;

// https://leetcode.com/problems/max-area-of-island/description/

public class MaxAreaOfIsland {

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int area = area(grid, i, j, n, m);
                    max = Math.max(area, max);
                }
            }
        }
        return max;
    }

    private int area(int[][] grid, int i, int j, int n, int m) {
        // base case
        if (i < 0 || i == n || j < 0 || j == m || grid[i][j] != 1) {
            return 0;
        }

        // recursive case
        grid[i][j] = 2; // visited

        return 1
                + area(grid, i, j - 1, n, m)   // left
                + area(grid, i - 1, j, n, m)    // up
                + area(grid, i, j + 1, n, m)    // right
                + area(grid, i + 1, j, n, m);   // down
    }

}
