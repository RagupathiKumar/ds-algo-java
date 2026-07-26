package leetcode.practice4;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {

    class KthLargest {

        private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        private int kth;

        public KthLargest(int k, int[] nums) {
            kth = k;
            for (int num : nums) {
                this.add(num);
            }
        }

        public int add(int val) {
            minHeap.add(val);
            if (minHeap.size() > kth) {
                minHeap.poll();
            }
            return minHeap.peek();
        }
    }

}
