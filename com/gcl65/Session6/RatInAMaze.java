package gcl65.Session6;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {

    public static void main(String[] args) {

        int[][] mat = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        List<String> result = new ArrayList<>();
        maze(mat, 0, 0, "", result);
        result.forEach(System.out::println);
    }

    private static void maze(int[][] mat, int i, int j, String path, List<String> result) {

        int n = mat.length;
        int m = mat[0].length;

        // base case
        if (i < 0 || i >= n || j < 0 || j >= m || mat[i][j] != 1) {
            return;
        }

        if (i == n - 1 && j == m - 1) {
            result.add(path);
            return;
        }

        // recursive case
        mat[i][j] = 2; // visited

        maze(mat, i - 1, j, path + "U", result);
        maze(mat, i + 1, j, path + "D", result);
        maze(mat, i, j - 1, path + "L", result);
        maze(mat, i, j + 1, path + "R", result);

        mat[i][j] = 1; // backtracking;
    }

}
