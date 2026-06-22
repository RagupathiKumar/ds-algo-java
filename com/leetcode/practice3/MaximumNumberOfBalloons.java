package leetcode.practice3;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/maximum-number-of-balloons/description/
public class MaximumNumberOfBalloons {

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("nlaebolko")); // 1
        System.out.println(maxNumberOfBalloons("loonbalxballpoon")); // 2
        System.out.println(maxNumberOfBalloons("leetcode")); // 0
    }

    static int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for (int i = 0, n = text.length(); i < n; i++) {
            freq[text.charAt(i) - 'a']++;
        }

        int balloons = Integer.MAX_VALUE;
        for (char c : new char[]{'a', 'b', 'l', 'n', 'o'}) {
            int f = freq[c - 'a'];
            if (c == 'l' || c == 'o') {
                f /= 2;
            }
            balloons = Math.min(f, balloons);
        }
        return balloons;
    }

}
