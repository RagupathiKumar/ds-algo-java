package gcl65.Session14;

import java.util.Deque;
import java.util.LinkedList;

public class RottingOranges {

    class Node {
        int row;
        int col;
        int time;
        public Node(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        Deque<Node> q = new LinkedList<>();
        int fresh = 0;
        int n = grid.length, m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Node(i, j, 0));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                time = node.time;

                for (int[] dir : dirs) {
                    int row = node.row + dir[0];
                    int col = node.col + dir[1];
                    if (row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        fresh--;
                        q.add(new Node(row, col, node.time + 1));
                    }
                }
            }
        }

        return fresh == 0 ? time : -1;
    }

}