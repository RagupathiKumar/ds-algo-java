package gcl65_2.Session7;

// https://leetcode.com/problems/first-unique-character-in-a-string/description/

public class FirstUniqueCharInString {

    public static void main(String[] args) {
        System.out.println(new FirstUniqueCharInString().firstUniqChar("leetcode")); // 0
        System.out.println(new FirstUniqueCharInString().firstUniqChar("loveleetcode")); // 2
        System.out.println(new FirstUniqueCharInString().firstUniqChar("aabb")); // -1
    }

    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] freq = new int['z' - 'a' + 1];

        for (int i = 0; i < n; i++) {
            freq[chars[i] - 'a'] += 1;
        }

        for (int i = 0; i < n; i++) {
            if (freq[chars[i] - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
