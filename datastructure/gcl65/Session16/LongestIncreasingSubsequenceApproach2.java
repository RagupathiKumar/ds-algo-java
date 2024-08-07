package gcl65.Session16;

import java.util.Arrays;

public class LongestIncreasingSubsequenceApproach2 {

    public static void main(String[] args) {
        LongestIncreasingSubsequenceApproach2 app = new LongestIncreasingSubsequenceApproach2();
        System.out.println(app.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18})); // 4
        System.out.println(app.lengthOfLIS(new int[] {9,2,4,10,1,6,7,15,3})); // 5
        System.out.println(app.lengthOfLIS(new int[] {2,10,3,4,7})); // 4
        System.out.println(app.lengthOfLIS(new int[] {8,4,6,1,9,10,2,5,7,0})); // 4
        System.out.println(app.lengthOfLIS(new int[] {3,1,5,2,7})); // 3
        System.out.println(app.lengthOfLIS(new int[] {7,7,7,7,7,7,7})); // 1
    }

    // Approach 2 : DP - Bottom Down Approach
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }


}