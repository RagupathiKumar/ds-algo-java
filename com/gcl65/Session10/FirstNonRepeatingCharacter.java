package gcl65.Session10;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        System.out.println(filter("abacb"));
        System.out.println(filter("aabcbdecedbf"));
    }

    private static String filter(String s) {

        Map<Character, Integer> map = new HashMap<>();
        Deque<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        char[] chars = s.toCharArray();
        for (char c : chars) {

            if (!map.containsKey(c)) {
                q.add(c);
            }
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (!q.isEmpty() && map.get(q.peek()) > 1) {
                q.poll();
            }

            sb.append(q.isEmpty() ? "#" : q.peek());
        }

        return sb.toString();
    }


}
