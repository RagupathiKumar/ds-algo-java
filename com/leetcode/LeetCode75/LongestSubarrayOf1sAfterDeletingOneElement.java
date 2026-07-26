package leetcode.LeetCode75;

public class LongestSubarrayOf1sAfterDeletingOneElement {

    public int longestSubarray(int[] nums) {
        int n = nums.length, del = 1;
        int cnt = 0, max = 0;
        int i = 0, j = 0;
        while (j < n) {
            max = Math.max(cnt - del, max);
            if (nums[j] == 1) {
                cnt++;
                j++;
            } else if (del > 0) {
                del--;
                j++;
            } else if (nums[i] == 1) {
                cnt--;
                i++;
            } else {
                del++;
                i++;
            }
        }
        return Math.max(cnt - del, max);
    }

}
