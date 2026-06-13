package gcl65_2.Session4;

// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
public class CapacityToShipPackagesWithinDDays {

    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5)); // 15
        System.out.println(shipWithinDays(new int[] {3, 2, 2, 4, 1, 4}, 3)); // 6
        System.out.println(shipWithinDays(new int[] {1, 2, 3, 1, 1}, 4)); // 3
    }

    public static int shipWithinDays(int[] weights, int days) {
        int minCapacity = Integer.MAX_VALUE, maxCapacity = 0;
        for (int w : weights) {
            minCapacity = Math.min(w, minCapacity);
            maxCapacity += w;
        }
        while (minCapacity <= maxCapacity) {
            int capacity = minCapacity + ((maxCapacity - minCapacity) / 2);
            int calculatedDays = calculateDays(weights, capacity);
            if (calculatedDays <= days) {
                maxCapacity = capacity - 1;
            } else {
                minCapacity = capacity + 1;
            }
        }

        return minCapacity;
    }

    private static int calculateDays(int[] weights, int capacity) {
        int days = 0, sum = 0;
        for (int w : weights) {
            sum += w;
            if (sum > capacity) {
                days++;
                sum = w;
            }
        }
        return days;
    }


}
