package leetcode.practice4;

public class MaximumAverageSubarrayI {

    public static void main(String[] args) {
        System.out.println(new MaximumAverageSubarrayI().findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(new MaximumAverageSubarrayI().findMaxAverage(new int[]{5}, 1));
        System.out.println(new MaximumAverageSubarrayI().findMaxAverage(new int[]{-1}, 1));

        System.out.println(new MaximumAverageSubarrayI().findMaxAverage2(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(new MaximumAverageSubarrayI().findMaxAverage2(new int[]{5}, 1));
        System.out.println(new MaximumAverageSubarrayI().findMaxAverage2(new int[]{-1}, 1));
    }

    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length, sum = 0, i = 0, j = 0;
        double max = -Double.MAX_VALUE;

        while (j < n) {
            while (j < n && j - i < k) {
                sum += nums[j++];
            }
            max = Double.max(((double) sum) / k, max);
            sum -= nums[i++];
        }


        return max;
    }

    public double findMaxAverage2(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int i = 0, j = k;
        double max = -Double.MAX_VALUE;
        while (j < nums.length) {
            max = Math.max(sum/k, max);
            sum -= nums[i++];
            sum += nums[j++];
        }
        return Math.max(sum/k, max);
    }

}
