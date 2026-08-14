package gcl65_2.Session14;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(new RottingOranges().orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> rotten = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    rotten.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int mins = 0;

        while (!rotten.isEmpty()) {
            for (int i = 0, size = rotten.size(); i < size; i++) {
                int[] rc = rotten.poll();
                for (int[] dir : dirs) {
                    int r = rc[0] + dir[0], c = rc[1] + dir[1];
                    if (r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 1) {
                        fresh--;
                        grid[r][c] = 2;
                        rotten.add(new int[]{r, c});
                    }
                }
            }
            if (!rotten.isEmpty()) {
                mins++;
            }
        }
        return fresh == 0 ? mins : -1;
    }

}
