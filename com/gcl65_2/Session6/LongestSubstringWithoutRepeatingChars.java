package gcl65_2.Session6;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < n) {
            if (!set.contains(chars[j])) {
                set.add(chars[j]);
                max = Math.max(j - i + 1, max);
                j++;
            } else {
                set.remove(chars[i]);
                i++;
            }
        }

        return max;
    }

}
