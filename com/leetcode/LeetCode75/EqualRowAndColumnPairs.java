package leetcode.LeetCode75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualRowAndColumnPairs {

    public static void main(String[] args) {
        System.out.println(equalPairs(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}})); // 3
    }

    static int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> map = new HashMap<>();
        List<String> colKeys = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder rowKey = new StringBuilder();
            StringBuilder colKey = new StringBuilder();
            for (int j = 0; j < n; j++) {
                rowKey.append(grid[i][j]).append("$");
                colKey.append(grid[j][i]).append("$");
            }
            String rk = rowKey.toString();
            map.put(rk, map.getOrDefault(rk, 0) + 1);
            colKeys.add(colKey.toString());
        }

        return colKeys.stream()
                .mapToInt(key -> map.getOrDefault(key, 0))
                .sum();
    }

}
