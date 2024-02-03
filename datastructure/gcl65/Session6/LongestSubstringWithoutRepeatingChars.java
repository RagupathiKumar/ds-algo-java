package gcl65.Session6;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {
        System.out.println(longestSubstring("abcadcbb"));
        System.out.println(longestSubstring("bbbbd"));
    }

    private static int longestSubstring(String s) {

        char[] arr = s.toCharArray();
        int n = arr.length, max = Integer.MIN_VALUE;
        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();

        while (j < n) {
            if (!set.contains(arr[j])) {
                set.add(arr[j++]);
                max = Math.max(max, set.size());
            } else {
                set.remove(arr[i++]);
            }
        }

        return max;
    }
}
