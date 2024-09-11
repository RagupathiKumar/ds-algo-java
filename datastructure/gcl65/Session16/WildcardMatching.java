package gcl65.Session16;

public class WildcardMatching {

    public static void main(String[] args) {
        System.out.println(new WildcardMatching().isMatch("aebmnc", "a?b*c"));
        System.out.println(new WildcardMatching().isMatch2("aebmnc", "a?b*c"));

        System.out.println(new WildcardMatching().isMatch("acdcb", "a*c?b"));
        System.out.println(new WildcardMatching().isMatch2("acdcb", "a*c?b"));
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

    public boolean isMatch2(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[] prev = new boolean[n + 1];
        boolean[] curr = new boolean[n + 1];

        prev[0] = true; // empty s, empty p match
        for (int i = 0; i < n && p.charAt(i) == '*'; i++) { // for first char as *
            prev[i + 1] = true;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    curr[j + 1] = prev[j]; // diagonal
                } else if (p.charAt(j) == '*') {
                    curr[j + 1] = prev[j + 1]  || curr[j];
                } else {
                    curr[j + 1] = false;
                }
            }

            prev = curr.clone();
        }

        return curr[n];
    }
}