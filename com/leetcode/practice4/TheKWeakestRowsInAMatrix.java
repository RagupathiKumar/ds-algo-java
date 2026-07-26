package leetcode.practice4;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TheKWeakestRowsInAMatrix {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(kWeakestRows(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}}, 3))); // [2,0,3]

        System.out.println(Arrays.toString(kWeakestRows(new int[][]{
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0}}, 2))); // [0,2]

        System.out.println(Arrays.toString(kWeakestRows(new int[][]{
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}}, 3))); // [0,1,2]
    }

    static class Pair {
        int cnt;
        int i;
        Pair(int cnt, int i) {
            this.cnt = cnt;
            this.i = i;
        }
    }

    static int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> {
            int diff = p2.cnt - p1.cnt;
            if (diff == 0) {
                return p2.i - p1.i;
            }
            return diff;
        });
        int n = mat.length, m = mat[0].length;

        for (int i = 0; i < n; i++) {
            int j = 0;
            while (j < m && mat[i][j] > 0) {
                j++;
            }
            maxHeap.add(new Pair(j, i));
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[] arr = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            arr[i] = maxHeap.poll().i;
        }
        return arr;
    }

}
