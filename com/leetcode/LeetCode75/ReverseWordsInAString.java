package leetcode.LeetCode75;

public class ReverseWordsInAString {

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue")); // blue is sky the
        System.out.println(reverseWords("  hello world  ")); // world hello
        System.out.println(reverseWords("a good   example")); // example good a
    }

    static String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (!strings[i].isEmpty()) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(strings[i]);
            }
        }
        return sb.toString();
    }

}
