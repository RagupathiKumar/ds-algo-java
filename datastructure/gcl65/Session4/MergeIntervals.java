package gcl65.Session4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {

        int[][] arr = {{5, 8}, {1, 3}, {9, 10}, {2, 4}, {10, 12}};
        List<int []> result = new ArrayList<>();

        Arrays.sort(arr, Comparator.comparingInt(value -> value[0]));

        int s1 = arr[0][0];
        int e1 = arr[0][1];

        for (int i = 1; i < arr.length; i++) {
            int s2 = arr[i][0];
            int e2 = arr[i][1];

            if (s2 <= e1) { // overlapping
                e1 = Math.max(e1, e2);
            } else { // non-overlapping
                result.add(new int[] {s1, e1});
                s1 = s2;
                e1 = e2;
            }
        }

        result.add(new int[] {s1, e1});

        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

}
