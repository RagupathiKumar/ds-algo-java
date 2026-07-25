package gcl65_2.Session13;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinNumberOfRefuelingStops {

    public static void main(String[] args) {
        System.out.println(minRefuelStops(100, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}}));   // 2
        System.out.println(minRefuelStops(140, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}}));   // 3
        System.out.println(minRefuelStops(170, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}}));   // 4
        System.out.println(minRefuelStops(180, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}}));   // -1
    }

    static int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int n = stations.length, i = 0;
        int stops = 0;

        while (startFuel < target) {
            while (i < n && startFuel >= stations[i][0]) {
                maxHeap.add(stations[i++][1]);
            }

            if (!maxHeap.isEmpty()) {
                startFuel += maxHeap.poll();
                stops++;
            } else {
                return -1;
            }
        }

        return stops;
    }

}
