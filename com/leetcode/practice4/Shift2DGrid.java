package leetcode.practice4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shift2DGrid {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(new Shift2DGrid().shiftGrid(grid, 1));
        System.out.println(new Shift2DGrid().shiftGrid(grid, 4));
        System.out.println(new Shift2DGrid().shiftGrid(grid, 9));

        int[][] grid2 = {
                {1},
                {2},
                {3},
                {4},
                {7},
                {6},
                {5}
        };
        System.out.println(new Shift2DGrid().shiftGrid(grid2, 23));
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int len = n * m;

        int[][] grid2 = new int[n][m];
        for (int i = 0; i < len; i++) {
            int index = (i + k) % len;
            grid2[index / m][index % m] = grid[i / m][i % m];
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(grid2[i][j]);
            }
            result.add(row);
        }
        return result;
    }

}
