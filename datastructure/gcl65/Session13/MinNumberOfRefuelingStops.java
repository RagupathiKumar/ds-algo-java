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

            // distance covered with existing fuel
            dist += startFuel;
            startFuel = 0;

            // if target is reached already
            if (dist >= target) {
                break;
            }

            // station already crossed
            while (!minHeap.isEmpty() && minHeap.peek()[0] <= dist) {
                maxHeap.add(minHeap.poll());
            }

            // refuelling in station with max fuel
            if (!maxHeap.isEmpty()) {
                startFuel = maxHeap.poll()[1];
                noOfStn++;
            }
        }

        return dist >= target ? noOfStn : -1;
    }

}