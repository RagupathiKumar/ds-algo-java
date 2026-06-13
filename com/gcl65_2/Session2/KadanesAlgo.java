package gcl65_2.Session2;

class KadanesAlgo {

    public static void main(String args[]) {
        maxSumSubarray(new int[] {2, -5, 7, -6, 5, 4, -10});
        maxSumSubarray(new int[] {3, 4, -6, 8, -3, 1});
        maxSumSubarray(new int[] {-4, -2, -6, -1});
    }

    private static void maxSumSubarray(int[] arr) {
        int sum = 0, max = Integer.MIN_VALUE;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            max = Math.max(sum, max);
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println(max);
    }
}  