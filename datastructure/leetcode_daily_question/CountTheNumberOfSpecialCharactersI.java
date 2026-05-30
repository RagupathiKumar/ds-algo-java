package leetcode_daily_question;

// https://leetcode.com/problems/count-the-number-of-special-characters-i/

public class CountTheNumberOfSpecialCharactersI {

    public static void main(String[] args) {
        System.out.println(numberOfSpecialChars("aaAbcBC")); //3
        System.out.println(numberOfSpecialChars("abc")); // 0
        System.out.println(numberOfSpecialChars("abBCab")); // 1
    }

    static int numberOfSpecialChars(String word) {
        char[] chars = word.toCharArray();

        int[] lowerCase = new int[26];
        int[] upperCase = new int[26];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] - 'a' >= 0) {
                lowerCase[chars[i] - 'a'] = 1;
            } else {
                upperCase[chars[i] - 'A'] = 1;
            }
        }

        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (lowerCase[i] == 1 && upperCase[i] == 1) {
                cnt++;
            }
        }
        return cnt;
    }

}
