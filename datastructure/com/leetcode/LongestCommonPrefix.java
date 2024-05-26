package com.leetcode;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String s = new LongestCommonPrefix().longestCommonPrefix(new String[]{ "flower", "flow", "flight"});
        System.out.println(s);
    }

    public String longestCommonPrefix(String[] strs) {
        return longestCommonPrefix(strs, strs[0], 1);
    }

    private String longestCommonPrefix(String[] strs, String s1, int i) {
        // base case
        if (i >= strs.length) {
            return s1;
        }

        // recursive case
        String s2 = strs[i];
        StringBuilder b = new StringBuilder();
        int n = Math.min(s1.length(), s2.length());

        for (int j = 0; j < n; j++) {
            if (s1.charAt(j) != s2.charAt(j)) {
                break;
            }
            b.append(s1.charAt(j));
        }

        if (b.length() == 0) {
            return b.toString();
        }

        return longestCommonPrefix(strs, b.toString(), ++i);
    }

    public String longestCommonPrefix2(String[] strs) {
        StringBuilder s = new StringBuilder();
        int n = strs.length, firstStrLen = strs[0].length();

        for (int charIndex = 0; charIndex < firstStrLen; charIndex++) {
            char ch = strs[0].charAt(charIndex);
            for (int i = 1; i < n; i++) {
                if (charIndex > strs[i].length() - 1 || ch != strs[i].charAt(charIndex)) {
                    return s.toString();
                }
            }
            s.append(ch);
        }

        return s.toString();
    }

}
