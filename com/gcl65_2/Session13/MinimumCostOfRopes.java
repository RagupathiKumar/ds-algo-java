package gcl65_2.Session13;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {

    public static void main(String[] args) {

    }

    public static int minCost(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int len : arr) {
            minHeap.add(len);
        }

        int cost = 0;
        while (minHeap.size() > 1) {
            int len = minHeap.poll() + minHeap.poll();
            cost += len;
            minHeap.add(len);
        }
        return cost;
    }

}
