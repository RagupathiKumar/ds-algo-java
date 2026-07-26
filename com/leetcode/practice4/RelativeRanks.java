package leetcode.practice4;

import java.util.PriorityQueue;

public class RelativeRanks {

    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a1, a2) -> a2[0] - a1[0]);
        int n = score.length;
        for (int i = 0; i < n; i++) {
            maxHeap.add(new int[]{score[i], i});
        }

        String[] arr = new String[n];
        for (int i = 1; i <= n; i++) {
            int idx = maxHeap.poll()[1];
            if (i == 1) {
                arr[idx] = "Gold Medal";
            } else if (i == 2) {
                arr[idx] = "Silver Medal";
            } else if (i == 3) {
                arr[idx] = "Bronze Medal";
            } else {
                arr[idx] = i + "";
            }
        }
        return arr;
    }

}
