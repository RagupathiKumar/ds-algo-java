package leetcode.LeetCode75;

public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] rightArray = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            rightArray[i] = rightArray[i + 1] + nums[i + 1];
        }

        int left = 0;
        for (int i = 0; i < n; i++) {
            if (left == rightArray[i]) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }

}
