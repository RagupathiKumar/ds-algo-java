package leetcode.LeetCode75;

public class StringCompression {

    public static void main(String[] args) {
        System.out.println(compress(new char[] {'a','a','b','b','c','c','c'})); // 6
        System.out.println(compress(new char[] {'a'})); // 1
        System.out.println(compress(new char[] {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'})); // 4
    }

    static int compress(char[] chars) {
        int n = chars.length, i = 0, j = 0;
        while (i < n) {
            char letter = chars[i];
            int size = 0;

            while (i < n && chars[i] == letter) {
                size++;
                i++;
            }

            chars[j++] = letter;
            if (size > 1) {
                for (char c : Integer.toString(size).toCharArray()) {
                    chars[j++] = c;
                }
            }
        }
        return j;
    }

}
