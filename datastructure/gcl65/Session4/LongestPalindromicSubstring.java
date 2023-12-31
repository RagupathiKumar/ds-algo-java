package gcl65.Session4;

public class LongestPalindromicSubstring {

    private static int startLeft = -1;
    private static int maxLen = Integer.MIN_VALUE;

    public static void main(String[] args) {

        String s = "forgeeksskeegfor";
        System.out.println(palindrom(s, 0, s.length() - 1));

        String s1 = "ablevelab";
        System.out.println(palindrom(s1, 0, s1.length() - 1));


        System.out.println(palindrom2(s));
        System.out.println(palindrom2(s1));


        // Chaman's solution below
        for (int i = 0; i < s.length(); i++) {

            // for even string size
            logestPalindrom(s, i, i);

            // for even string size
            logestPalindrom(s, i, i + 1);
        }

        System.out.println(s.substring(startLeft, startLeft + maxLen));
    }

    private static void logestPalindrom(String s, int l, int r) {

        int n = s.length() - 1;
        while (l >= 0 && r <= n && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        int len = r - l - 1;
        if (len > maxLen) {
            maxLen = len;
            startLeft = l + 1;
        }
    }

    private static String palindrom2(String s) {

        int maxStartIndex = -1, maxLen = Integer.MIN_VALUE, left, right;

        for (int i = 0; i < s.length(); i++) {

            left = i;
            right = i;

            while (s.charAt(left) == s.charAt(right)) {

                if (left == right && right + 1 <= s.length() - 1 && s.charAt(left) == s.charAt(right + 1)) {
                    right = left + 1;
                }

                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    maxStartIndex = left;
                }

                left--;
                right++;

                if (left < 0 || right > s.length() - 1) {
                    break;
                }
            }

        }

        return s.substring(maxStartIndex, maxStartIndex + maxLen);
    }

    // recursive approach also works in TIME O(n cube) -- not a good one
    private static String palindrom(String s, int start, int end) {

        if (start > end) {
            return "";
        }

        String p1 = palindrom(s, start, end - 1);
        String p2 = palindrom(s, start + 1, end);

        String p = s.substring(start, end + 1);
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                p = "";
                break;
            }
            start++;
            end--;
        }

        if (p.length() > p1.length()) {
            return p;
        } else if (p1.length() > p2.length()) {
            return p1;
        }
        return p2;
    }


}
