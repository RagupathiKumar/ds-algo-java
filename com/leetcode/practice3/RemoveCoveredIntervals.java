package leetcode.practice3;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveCoveredIntervals {

    public static void main(String[] args) {
        System.out.println(removeCoveredIntervals(new int[][]{{1, 4}, {3, 6}, {2, 8}})); // 2
        System.out.println(removeCoveredIntervals(new int[][]{{1, 4}, {2, 3}})); // 1
    }

    static int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        int cnt = 1;
        int a = intervals[0][0];
        int b = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int c = intervals[i][0];
            int d = intervals[i][1];

            if (a < c) {
                if (b < c || b < d) {
                    cnt++;
                    a = c;
                    b = d;
                }
            } else {
                b = Math.max(b, d);
            }
        }

        return cnt;
    }

}
