package gcl65_2.Session10;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingCharacter("aabcc")); // a#bbb
        System.out.println(firstNonRepeatingCharacter("abacb")); // aabbc
        System.out.println(firstNonRepeatingCharacter("aabcbdecedbf")); // a#bbcccdd##f
    }

    static String firstNonRepeatingCharacter(String s) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        Map<Character, Integer> freq = new HashMap<>();

        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            if (freq.get(ch) == 1) {
                q.add(ch);
            }

            while (!q.isEmpty() && freq.get(q.peek()) > 1) {
                q.poll();
            }

            sb.append(q.isEmpty() ? '#' : q.peek());
        }

        return sb.toString();
    }

}
