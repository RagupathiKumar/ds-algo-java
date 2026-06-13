package gcl65.Session5;

public class NumberOfIslands {

    public static void main(String[] args) {

        int[][] mat = {
                {1, 1, 1, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 1, 0, 0, 1}
        };

        int n = mat.length;
        int m = mat[0].length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    count++;
                    dfs(mat, i, j);
                }
            }
        }

        System.out.println(count);
    }

    private static void dfs(int[][] mat, int i, int j) {

        int n = mat.length;
        int m = mat[0].length;

        // base case
        if (i < 0 || i >= n || j < 0 || j >= m || mat[i][j] != 1) {
            return;
        }

        // recursive case
        mat[i][j] = 2; // visited

        dfs(mat, i, j - 1); // go left
        dfs(mat, i - 1, j); // go top
        dfs(mat, i, j + 1); // go right
        dfs(mat, i + 1, j); // go bottom
    }

}
