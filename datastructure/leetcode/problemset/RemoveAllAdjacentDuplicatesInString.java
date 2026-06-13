package leetcode.problemset;

// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/

public class RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca")); // ca
        System.out.println(removeDuplicates("azxxzy")); // ay
    }

    static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, n = s.length(); i < n; i++) {
            int length = sb.length();
            if (length > 0 && sb.charAt(length - 1) == s.charAt(i)) {
                sb.deleteCharAt(length - 1);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

}
