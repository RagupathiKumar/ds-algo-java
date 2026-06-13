package gcl65.Session16;

public class MinimumPathSum {

    public static void main(String[] args) {
        MinimumPathSum _this = new MinimumPathSum();

        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        System.out.println(_this.minPathSum(grid));
        System.out.println(_this.minPathSum2(grid));
    }

    // Top-Down Approach
    private int minPathSum(int[][] grid) {
        return minPathSum(grid, grid.length - 1, grid[0].length - 1, 0, 0, grid[0][0]);
    }

    private int minPathSum(int[][] grid, int m, int n, int i, int j, int path) {
        // base case
        if (i == m && j == n) {
            return path;
        }

        // recursive case
        int min = Integer.MAX_VALUE;
        if (i < m) {
            min = Math.min(min, minPathSum(grid, m, n, i + 1, j, path + grid[i + 1][j]));
        }

        if (j < n) {
            min = Math.min(min, minPathSum(grid, m, n, i, j + 1, path + grid[i][j + 1]));
        }

        return min;
    }

    // Bottom-Up Approach
    private int minPathSum2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // summing up 1st row
        for (int j = 1; j < m; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        // summing up 1st column
        for (int i = 1; i < n; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[n - 1][m - 1];
    }

}