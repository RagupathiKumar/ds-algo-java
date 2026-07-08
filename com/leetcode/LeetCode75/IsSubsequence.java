package leetcode.LeetCode75;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length(), i = 0;
        for (int j = 0; i < n && j < m; j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }
        return i == n;
    }

}
