package gcl65_2.Session4;

// https://leetcode.com/problems/merge-intervals/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class MergeIntervals {
    public static void main(String[] args) {

        int[][] result = new MergeIntervals().merge(new int[][]{
                {5, 8}, {1, 3}, {9, 10}, {2, 4}, {10, 12}
        });

        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        int n = intervals.length;
        int s1 = intervals[0][0], e1 = intervals[0][1], s2 = 0, e2 = 0;
        List<int[]> result = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            s2 = intervals[i][0];
            e2 = intervals[i][1];

            if (e1 >= s2) {
                e1 = Math.max(e1, e2);
            } else {
                result.add(new int[] {s1, e1});
                s1 = s2;
                e1 = e2;
            }
        }
        result.add(new int[] {s1, e1});

        return result.toArray(new int[result.size()][]);
    }

}