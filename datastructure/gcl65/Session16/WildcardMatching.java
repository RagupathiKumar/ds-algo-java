package gcl65.Session16;

public class WildcardMatching {

    public static void main(String[] args) {
        System.out.println(new WildcardMatching().isMatch("aebmnc", "a?b*c"));
    }

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true; // empty s, empty p match

        for (int i = 0; i < n && p.charAt(i) == '*'; i++) { // for first char as *
            dp[0][i + 1] = true;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    dp[i + 1][j + 1] = dp[i][j + 1]  || dp[i + 1][j];
                }
            }
        }

        return dp[m][n];
    }
}