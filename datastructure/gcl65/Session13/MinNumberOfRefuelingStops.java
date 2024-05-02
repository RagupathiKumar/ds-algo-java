package gcl65.Session13;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinNumberOfRefuelingStops {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int dist = 0;
        int noOfStn = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int[] station : stations) {
            minHeap.add(station);
        }

        while (dist < target && startFuel > 0){

            dist += startFuel;
            if (dist >= target) {
                break;
            }

            while (!minHeap.isEmpty() && dist <= minHeap.peek()[0]) {
                maxHeap.add(minHeap.poll());
            }

            startFuel = maxHeap.poll()[1];
            noOfStn++;
        }

        return dist >= target ? noOfStn : -1;
    }

}