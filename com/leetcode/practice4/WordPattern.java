package leetcode.practice4;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog")); // true
        System.out.println(wordPattern("abba", "dog cat cat fish")); // false
        System.out.println(wordPattern("aaaa", "dog cat cat dog")); // false
        System.out.println(wordPattern("ab", "dog dog")); // false
        System.out.println(wordPattern("aaa", "aa aa aa aa")); // false
    }

    static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        int n = pattern.length();
        if (words.length != n) {
            return false;
        }

        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            if (map1.get(ch) == null && map2.get(word) == null) {
                map1.put(ch, word);
                map2.put(word, ch);
            } else if (map1.get(ch) != null && !map1.get(ch).equals(word)) {
                return false;
            } else if (map2.get(word) != null && !map2.get(word).equals(ch)) {
                return false;
            }
        }
        return true;
    }

}
