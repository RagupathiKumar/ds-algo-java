package gcl65.Session15;

public class GasStation {

    // I wrote a solution with O(N square) time complexity (I used two for loops)
    // Chaman gave this solution with O(N)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = 0, currBal = 0, totBal = 0;

        for (int i = 0; i < n; i++) {
            currBal += gas[i] - cost[i];
            totBal += gas[i] - cost[i];

            if (currBal < 0) { // looks like Kadane's Algo, need to confirm
                currBal = 0;
                start = i + 1;
            }
        }

        return totBal >= 0 ? start : -1;
    }

}