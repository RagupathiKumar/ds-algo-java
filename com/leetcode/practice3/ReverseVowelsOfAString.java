package leetcode.practice3;

public class ReverseVowelsOfAString {

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if ("AEIOUaeiou".indexOf(chars[i]) == -1) {
                i++;
            } else if ("AEIOUaeiou".indexOf(chars[j]) == -1) {
                j--;
            } else {
                char c = chars[i];
                chars[i++] = chars[j];
                chars[j--] = c;
            }
        }

        return new String(chars);
    }

}
