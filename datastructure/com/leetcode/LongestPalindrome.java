package com.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-palindrome
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("abccccdd"));
        System.out.println(new LongestPalindrome().longestPalindrome("a"));
        System.out.println(new LongestPalindrome().longestPalindrome("Aa"));
    }

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length(), len = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.compute(c, (key, cnt) -> cnt == null ? 1 : cnt + 1);

            if (map.get(c) == 2) { // since a pair exists
                len += 2;
                map.remove(c); // zeroing it won't help, remove the key
            }
        }

        return map.isEmpty() ? len : len + 1;
    }

}
