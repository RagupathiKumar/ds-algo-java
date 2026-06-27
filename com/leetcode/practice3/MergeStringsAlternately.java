package leetcode.practice3;

public class MergeStringsAlternately {

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr"));
        System.out.println(mergeAlternately("ab", "pqrs"));
        System.out.println(mergeAlternately("abcd", "pq"));
    }

    static String mergeAlternately(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length(), i = 0;
        StringBuilder b = new StringBuilder();

        while (i < len1 && i < len2) {
            b.append(word1.charAt(i)).append(word2.charAt(i));
            i++;
        }

        b.append(word1.substring(i)).append(word2.substring(i));
        return b.toString();
    }

}
