package gcl65_2.Session13;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {

    }

    class Dist {
        int dist;
        int x;
        int y;

        Dist(int d, int x, int y) {
            this.dist = d;
            this.x = x;
            this.y = y;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Dist> maxHeap = new PriorityQueue<>((d1, d2) -> d2.dist - d1.dist);

        for (int[] p : points) {
            maxHeap.add(new Dist(p[0] * p[0] + p[1] * p[1], p[0], p[1]));
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][];
        for (int i = 0; i < k; i++) {
            Dist dist = maxHeap.poll();
            result[i] = new int[]{dist.x, dist.y};
        }
        return result;
    }

}
