package leetcode.practice5;

public class ShortestAndLexicographicallySmallestBeautifulString { // not solved

    public static void main(String[] args) {
        System.out.println(shortestBeautifulSubstring("100011001", 3)); // 11001
        System.out.println(shortestBeautifulSubstring("1011", 2));      // 11
        System.out.println(shortestBeautifulSubstring("000", 1));       // ""
        System.out.println(shortestBeautifulSubstring("1100001110111100100", 8));       // 11101111001
    }

    static String shortestBeautifulSubstring(String s, int k) {
        int n = s.length(), i = 0, j = 0, minLen = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        String bStr = "";

        while (j < n) {
            if (s.charAt(j) == '0') {
                sb.append(s.charAt(j));
                j++;
            } else if (s.charAt(j) == '1' && k > 0) {
                sb.append(s.charAt(j));
                j++;
                k--;
            } else if (s.charAt(i) == '1') {
                sb.deleteCharAt(0);
                i++;
                k++;
            } else if (s.charAt(i) == '0') {
                sb.deleteCharAt(0);
                i++;
            }

            if (k == 0 && sb.length() < minLen) {
                minLen = sb.length();
                bStr = sb.toString();
            }
        }

        if (k == 0) {
            while (sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.deleteCharAt(sb.length() - 1);
            }
            if (sb.length() < minLen) {
                bStr = sb.toString();
            }
        }

        return bStr;
    }

}
