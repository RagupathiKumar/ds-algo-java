package gcl65_2.Session3;

//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

class MinCapacityToShipPackages {

    public static void main(String[] args) {
        System.out.println(minCapacity(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println(minCapacity(new int[] {1, 2, 3, 1, 1}, 4));
    }

    private static int minCapacity(int[] weights, int days) {
        int s = -1, e = 0;
        for (int w : weights) {
            s = Math.max(w, s);
            e += w;
        }

        int minNeededCapacity = 0;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int calculatedDays = calculateDays(weights, mid);
            if (calculatedDays <= days) {
                minNeededCapacity = mid;
                e = mid - 1;
            } else if (calculatedDays > days) {
                s = mid + 1;
            }
        }

        /*for (int capacity = s; capacity <= e; capacity++) {
            int calculatedDays = calculateDays(weights, capacity);
            if (calculatedDays == days) {
                return capacity;
            }
        }*/

        return minNeededCapacity;
    }

    private static int calculateDays(int[] weights, int capacity) {
        int n = weights.length;
        int days = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += weights[i];
            if (sum > capacity) {
                days += 1;
                sum = weights[i];
            }
        }
        if (sum > 0) {
            days += 1;
        }
        return days;
    }
}