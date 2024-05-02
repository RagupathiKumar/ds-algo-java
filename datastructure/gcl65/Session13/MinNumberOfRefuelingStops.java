package gcl65.Session13;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinNumberOfRefuelingStops {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int dist = 0;
        int stops = 0;
        int i = 0, n = stations.length;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        while (dist < target && startFuel > 0){

            // distance covered with existing fuel
            dist += startFuel;
            startFuel = 0;

            // if target is reached already
            if (dist >= target) {
                break;
            }

            // station already crossed
            while (i < n && dist >= stations[i][0]) {
                maxHeap.add(stations[i][1]);
                i++;
            }

            // refuelling in station with max fuel
            if (!maxHeap.isEmpty()) {
                startFuel = maxHeap.poll();
                stops++;
            }
        }

        return dist >= target ? stops : -1;
    }

}