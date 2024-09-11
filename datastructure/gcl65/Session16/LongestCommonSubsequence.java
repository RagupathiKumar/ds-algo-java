package gcl65.Session16;

public class LongestCommonSubsequence {

    public static void main(String[] args) {

        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.longestCommonSubsequence("abcdgh", "aedfhr")); // 3
        System.out.println(lcs.longestCommonSubsequence("abcde", "xazyc")); // 2
        System.out.println(lcs.longestCommonSubsequence("abcde", "aec")); // 2

        System.out.println(lcs.longestCommonSubsequence2("abcdgh", "aedfhr")); // 3
        System.out.println(lcs.longestCommonSubsequence2("abcde", "xazyc")); // 2
        System.out.println(lcs.longestCommonSubsequence2("abcde", "aec")); // 2
    }

    /**
     * DP - Bottom Up approach
     * time - O(M x N), space - O(M x N)
     * Note - space can be optimised, check longestCommonSubsequence2
     * */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        int r = dp.length, c = dp[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = 1 + dp[i][j]; // diagonal
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]); // max of top or left
                }
            }
        }

        return dp[r - 1][c - 1];
    }

    /**
     * replacing grid with prev and curr array
     * space optimized
     * */
    public int longestCommonSubsequence2(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    curr[j + 1] = 1 + prev[j]; // diagonal
                } else {
                    curr[j + 1] = Math.max(curr[j], prev[j + 1]); // top or left
                }
            }
            prev = curr.clone();
        }

        return curr[n];
    }

}