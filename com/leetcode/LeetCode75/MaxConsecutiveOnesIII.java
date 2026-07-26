package leetcode.LeetCode75;

public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2)); // 6
        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3)); // 10
    }

    static int longestOnes(int[] nums, int k) {
        int n = nums.length, i = 0, j = 0;
        int max = 0;
        while (j < n) {
            if (nums[j] == 1) {
                j++;
            } else if (k > 0) {
                j++;
                k--;
            } else if (nums[i] == 1) {
                i++;
            } else {
                i++;
                k++;
            }
            max = Math.max(j - i, max);
        }
        return Math.max(j - i, max);
    }

}
