package gcl65.Session7;

import java.util.*;

public class GroupAnagram {

    public static void main(String[] args) {
        List<List<String>> result = groupAnagramsNg(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (List<String> list : result) {
            System.out.println(list);
        }
    }

    public static List<List<String>> groupAnagramsNg(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] arr = new int[26];
            for (char c : str.toCharArray()) {
                arr[c - 'a']++;
            }

            StringBuilder key = new StringBuilder();
            for (int i : arr) {
                key.append(i);
            }

            map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = key(str);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private static String key(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    private static boolean isAnagram(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        int[] sum = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            sum[s1.charAt(i) - 'a']++;
            sum[s2.charAt(i) - 'a']--;
        }

        for (int num : sum) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }

}