package gcl65_2.Session4;

// https://leetcode.com/problems/reverse-words-in-a-string/description/

import java.util.StringJoiner;

public class ReverseWordsInString2 {

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInString2().reverseWords(" the sky is blue "));
        System.out.println(new ReverseWordsInString2().reverseWords("   hello   world   "));
        System.out.println(new ReverseWordsInString2().reverseWords("a good   example"));
    }

    public String reverseWords(String s) {

        char[] chars = s.toCharArray();
        int j = chars.length - 1;
        StringBuilder sb = new StringBuilder();

        while (j >= 0) {
            while (j >= 0 && chars[j] == ' ') {
                j--;
            }

            int i = j;
            while (i >= 0 && chars[i] != ' ') {
                i--;
            }

            if (j < 0) {
                break;
            }

            if (sb.length() > 0) {
                sb.append(' ');
            }
            for (int idx = i + 1; idx <= j; idx++) {
                sb.append(chars[idx]);
            }
            j = i;
        }

        return sb.toString();
    }

}
