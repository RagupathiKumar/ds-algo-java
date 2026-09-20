package leetcode.LeetCode75;

import java.util.Arrays;

public class DetermineIfTwoStringsAreClose {

    public static void main(String[] args) {
        System.out.println(closeStrings("abc", "bca")); // true
        System.out.println(closeStrings("a", "aa")); // false
        System.out.println(closeStrings("cabbba", "abbccc")); // true
    }

    static boolean closeStrings(String word1, String word2) {
        int n = word1.length(), m = word2.length();

        int[] freq1 = new int[26];
        for (int i = 0; i < n; i++) {
            freq1[word1.charAt(i) - 'a']++;
        }

        int[] freq2 = new int[26];
        for (int i = 0; i < m; i++) {
            freq2[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((freq1[i] != 0) != (freq2[i] != 0)) {
                return false;
            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }

}
