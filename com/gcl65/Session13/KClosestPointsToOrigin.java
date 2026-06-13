package gcl65.Session13;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int[][] result = new KClosestPointsToOrigin().kClosest(points, 2);
        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a1, a2) -> (a2[0]*a2[0] + a2[1]*a2[1]) - (a1[0]*a1[0] + a1[1]*a1[1])
        );

        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.remove();
            }
        }

        int[][] result = new int[k][2];
        while (k-- > 0) {
            result[k] = maxHeap.poll();
        }

        return result;
    }

}