package leetcode.LeetCode75;

import java.util.Arrays;

public class MaxNumberOfKSumPairs {

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1, cnt = 0;
        while (i < j) {
            if (nums[i] + nums[j] < k) {
                i++;
            } else if (nums[i] + nums[j] > k) {
                j--;
            } else {
                cnt++;
                i++;
                j--;
            }
        }
        return cnt;
    }

}
