package gcl65.Session4;

import java.util.Arrays;

public class ReverseWordsInString {

    public static void main(String[] args) {

        String str = "Take LeetCode Contest";

        char[] chars = str.toCharArray();

        int i = 0;
        for (int j = 0; j < chars.length; j++) {
            if (chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
        }
        reverse(chars, i, chars.length - 1);

        System.out.println(String.valueOf(chars));
    }

    private static void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[j];
            chars[j] = chars[i];
            chars[i] = temp;
            i++;
            j--;
        }
    }

}
