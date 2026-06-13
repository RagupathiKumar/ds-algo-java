package gcl65_2.Session4;

import static java.lang.System.out;

// https://www.geeksforgeeks.org/dsa/painters-partition-problem/
public class PaintersPartitionProblem {

    public static void main(String[] args) {
        out.println(new PaintersPartitionProblem().minTime(new int[] {5, 10, 30, 20, 15}, 3)); // 35
        out.println(new PaintersPartitionProblem().minTime(new int[] {10, 20, 30, 40}, 2)); // 60
        out.println(new PaintersPartitionProblem().minTime(new int[] {100, 200, 300, 400}, 1)); // 1000
    }

    public int minTime(int[] arr, int k) {
        int n = arr.length;
        if (n < k) {
            return -1;
        }

        int minTime = Integer.MIN_VALUE, maxTime = 0;
        for (int i = 0; i < n; i++) {
            minTime = Math.max(minTime, arr[i]);
            maxTime += arr[i];
        }

        int time = -1;
        while (minTime <= maxTime) {
            int midTime = minTime + (maxTime - minTime) / 2;
            int painters = calculatePainters(arr, midTime, k);
            if (painters <= k) {
                time = midTime;
                maxTime = midTime - 1;
            } else {
                minTime = midTime + 1;
            }
        }

        return time;
    }

    private int calculatePainters(int[] arr, int midTime, int k) {
        int n = arr.length;
        int time = 0, painters = 0;
        for (int i = 0; i < n; i++) {
            time += arr[i];
            if (time > midTime) {
                painters++;
                time = arr[i];
            }
        }
        if (time > 0) {
            painters++;
        }
        return painters;
    }


}
