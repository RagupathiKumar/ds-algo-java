package gcl65.Session13;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {

    public static void main(String[] args) {
        long total = new MinimumCostOfRopes().minCost(new long[] {4, 3, 2, 6}, 4);
        System.out.println(total);
    }

    long minCost(long arr[], int n) 
    {
        // your code here
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (long num : arr) {
            minHeap.add(num);
        }

        long cost = 0;
        
        while (minHeap.size() > 1) {
            long rope1 = minHeap.poll();
            long rope2 = minHeap.poll();
            cost += rope1 + rope2;
            minHeap.add(rope1 + rope2);
        }
      
        return cost;
    }
}