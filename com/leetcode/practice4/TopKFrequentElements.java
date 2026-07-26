package leetcode.practice4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            minHeap.add(new int[] {e.getValue(), e.getKey()});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = minHeap.poll()[1];
        }
        return arr;
    }

}
