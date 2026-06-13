package gcl65_2.Session7;

// https://leetcode.com/problems/group-anagrams/description/

import java.util.*;

public class GroupAnagram {

    public static void main(String[] args) {
//        System.out.println(new GroupAnagram().groupAnagrams1(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
//        System.out.println(new GroupAnagram().groupAnagrams2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        System.out.println(new GroupAnagram().groupAnagrams1(new String[]{"bdddddddddd","bbbbbbbbbbc"}));
        System.out.println(new GroupAnagram().groupAnagrams2(new String[]{"bdddddddddd","bbbbbbbbbbc"}));
    }

    // approach 1
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();

        int n = strs.length;
        for (int i = 0; i < n; i++) {
            String key = strs[i];
            char[] keyChars = key.toCharArray();
            Arrays.sort(keyChars);
            String sortedKey = String.valueOf(keyChars);

            result.computeIfAbsent(sortedKey, k -> new ArrayList<>()).add(key);
        }

        return new ArrayList<>(result.values());
    }

    // approach 2
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();

        int n = strs.length;
        for (int i = 0; i < n; i++) {
            String key = strs[i];
            char[] keyChars = key.toCharArray();

            int[] freq = new int[26];
            for (char ch : keyChars) freq[ch - 'a']++;
            StringBuilder sortedKey = new StringBuilder();
            for (int f : freq) sortedKey.append("#").append(f);

            result.computeIfAbsent(sortedKey.toString(), k -> new ArrayList<>()).add(key);
        }

        return new ArrayList<>(result.values());
    }
}
