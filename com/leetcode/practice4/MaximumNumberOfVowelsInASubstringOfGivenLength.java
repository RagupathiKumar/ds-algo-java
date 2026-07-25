package leetcode.practice4;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {

    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3)); // 3
        System.out.println(maxVowels("aeiou", 2)); // 2
        System.out.println(maxVowels("leetcode", 3)); // 2
    }

    static int maxVowels(String s, int k) {
        int n = s.length(), vowels = 0, max = 0;

        for (int i = 0; i < k; i++) {
            if (vowel(s.charAt(i))) {
                vowels++;
            }
        }

        int i = 0, j = k;
        while (j < n) {
            max = Math.max(vowels, max);
            if (vowel(s.charAt(i++))) {
                vowels--;
            }
            if (vowel(s.charAt(j++))) {
                vowels++;
            }
        }
        return Math.max(vowels, max);
    }

    private static boolean vowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
