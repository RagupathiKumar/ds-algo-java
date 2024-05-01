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
        long total = 0;
        
        for (long num : arr) {
            minHeap.add(num);
            if (minHeap.size() > 2) {
                long current = minHeap.poll() + minHeap.poll();
                minHeap.add(current);
                total += current;
            }
        }
        
        total += minHeap.poll() + minHeap.poll();
        return total;
    }
}