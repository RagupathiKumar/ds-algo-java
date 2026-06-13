package gcl65_2.Session4;

// https://leetcode.com/problems/longest-palindromic-substring/

class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("ablevelab"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("ablevvelab"));
    }

    private int start = -1;
    private int maxLen = Integer.MIN_VALUE;

    public String longestPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            longestPalindrome(s, i, i); // odd lengthen string or string with one centre
            longestPalindrome(s, i, i + 1); // even lengthen string or string with two centres
        }
        return s.substring(start, start + maxLen);
    }

    public void longestPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        int len = right - left - 1;
        if (len > maxLen) {
            maxLen = len;
            start = left + 1;
        }
    }

}