package gcl65.Session4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestSession4 {

    public static void main(String[] args) {

        String str = "Take LeetCode Contest";
        System.out.println(reverseWords(str));

        System.out.println(romanToInt("LVIII")); // 58
        System.out.println(romanToInt("MCMXCIV")); // 1994

        int[][] arr = {{5, 8}, {1, 3}, {9, 10}, {2, 4}, {10, 12}};
        int[][] result = mergeRagu(arr);
        for (int[] a : result) {
            System.out.print(Arrays.toString(a) + ", ");
        }

        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));

        System.out.println(longestPalindrome("forgeeksskeegfor"));;
    }

    static int start = 0;
    static int max = Integer.MIN_VALUE;

    public static void longestPalindrome(String s, int l, int r) {
        int n = s.length();
        while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        int len = r - l - 1;
        if (len > max) {
            max = len;
            start = l + 1;
        }
    }

    public static String longestPalindrome(String s) {

        // odd len str has single mid whereas even len str has two mid

        int n = s.length();
        for (int i = 0; i < n; i++) {
            longestPalindrome(s, i, i); // odd len str
            longestPalindrome(s, i, i + 1); // even len str
        }

        return s.substring(start, start + max);
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int n = s.length();
        int[] chars = new int[26];
        for (int i = 0; i < n; i++) {
            chars[s.charAt(i) - 'a']++;
            chars[t.charAt(i) - 'a']--;
        }

        for (int c : chars) {
            if (c > 0) {
                return false;
            }
        }

        return Arrays.stream(chars).allMatch(num -> num == 0);
    }

    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        int i = 0;
        for (int j = 0; j < n; j++) {
            if (chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
        }
        reverse(chars, i, n - 1);

        return String.valueOf(chars);
    }

    private static void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[i];
            chars[i++] = chars[j];
            chars[j--] = temp;
        }
    }

    public static int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int curr = romanToInt(chars[i]);

            if (i + 1 < n) {
                int next = romanToInt(chars[i + 1]);
                if (curr < next) {
                    curr = next - curr;
                    i++;
                }
            }

            sum += curr;
        }

        return sum;
    }

    private static int romanToInt(char c) {
        if (c == 'I') {
            return 1;
        } else if (c == 'V') {
            return 5;
        } else if (c == 'X') {
            return 10;
        } else if (c == 'L') {
            return 50;
        } else if (c == 'C') {
            return 100;
        } else if (c == 'D') {
            return 500;
        } else if (c == 'M') {
            return 1000;
        }
        return 0;
    }

    public static int[][] mergeRagu(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int n = intervals.length;
        int i = 0;

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int j = 1; j < n; j++) {
            if (result.get(i)[1] >= intervals[j][0]) { // overlapping
                result.get(i)[1] = intervals[j][1];
            } else {
                result.add(intervals[j]);
                i++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static int[][] mergeChaman(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();
        int n = intervals.length;

        int s1 = intervals[0][0], e1 = intervals[0][1];
        for (int i = 1; i < n; i++) {
            int s2 = intervals[i][0], e2 = intervals[i][1];

            if (e1 >= s2) { // overlapping
                e1 = Math.max(e1, e2);
            } else {
                result.add(new int[] {s1, e1});
                s1 = s2;
                e1 = e2;
            }
        }
        result.add(new int[]{s1, e1});

        return result.toArray(new int[result.size()][]);
    }

}
