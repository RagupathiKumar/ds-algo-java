package gcl65_2.Session7;

// https://leetcode.com/problems/isomorphic-strings/

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add")); // true
        System.out.println(isIsomorphic("f11", "b23")); // false
        System.out.println(isIsomorphic("paper", "title")); // true
        System.out.println(isIsomorphic("bbbaaaba", "aaabbbba")); // false
        System.out.println(isIsomorphic("badc", "baba")); // false
    }

    static boolean isIsomorphic(String s, String t) {
        char[] chars1 = s.toCharArray(), chars2 = t.toCharArray();
        int n = chars1.length;

        Character[] map = new Character[128];
        boolean[] assigned = new boolean[128];

        for (int i = 0; i < n; i++) {
           if (map[chars1[i]] == null) {
               if (!assigned[chars2[i]]) {
                   map[chars1[i]] = chars2[i];
                   assigned[chars2[i]] = true;
               } else {
                   return false;
               }
           } else if (map[chars1[i]] != chars2[i]) {
               return false;
           }
        }

        return true;
    }

}
