package leetcode.practice4;

public class MaximumLengthSubstringWithTwoOccurrences {

    public static void main(String[] args) {
        System.out.println(maximumLengthSubstring("bcbbbcba")); // 4
        System.out.println(maximumLengthSubstring("aaaa")); // 2
    }

    static int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int n = s.length(), max = 0;
        int i = 0, j = 0;
        while (j < n) {
            if (freq[s.charAt(j) - 'a'] < 2) {
                freq[s.charAt(j) - 'a']++;
                j++;
            } else {
                freq[s.charAt(i) - 'a']--;
                i++;
            }
            max = Math.max(j - i, max);
        }
        return max;
    }
}
