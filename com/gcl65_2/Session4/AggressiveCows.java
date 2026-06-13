package gcl65_2.Session4;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/aggressive-cows/1
public class AggressiveCows {

    public static void main(String[] args) {
        System.out.println(new AggressiveCows().aggressiveCows(new int[] {1, 2, 4, 8, 9}, 3));
        System.out.println(new AggressiveCows().aggressiveCows(new int[] {10, 1, 2, 7, 5}, 3));
        System.out.println(new AggressiveCows().aggressiveCows(new int[] {2, 12, 11, 3, 26, 7}, 5));

        System.out.println(new AggressiveCows().aggressiveCows(new int[] {18, 8, 20, 7, 9, 1, 14, 17, 11, 19, 6, 15, 2, 13, 5}, 6));
    }

    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);

        int n = stalls.length;
        int minDist = 1, maxDist = stalls[n - 1] - stalls[0];
        int dist = 0;

        while (minDist <= maxDist) {
            int midDist = minDist + (maxDist - minDist) / 2;
            int aggressiveCows = calcAggressiveCows(stalls, midDist);
            if (aggressiveCows >= k) {
                dist = Math.max(midDist, dist);
                minDist = midDist + 1;
            } else {
                maxDist = midDist - 1;
            }
        }

        return dist;
    }

    private int calcAggressiveCows(int[] stalls, int midDist) {
        int n = stalls.length, cows = 0, i = 0;
        for (int j = 1; j < n; j++) {
            if (stalls[j] - stalls[i] >= midDist) {
                cows++;
                i = j;
            }
        }
        return cows + 1;
    }

}
