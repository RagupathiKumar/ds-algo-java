package gcl65_2.Session10;
// https://leetcode.com/problems/find-the-difference/description/
public class FindTheDifference {

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abecd")); // e
        System.out.println(findTheDifference("", "y")); // y
    }

    static char findTheDifference(String s, String t) {
        int n = s.length(), num = 0;
        for (int i = 0; i < n; i++) {
            num ^= s.charAt(i) ^ t.charAt(i);
        }
        num ^= t.charAt(n);
        return (char) num;
    }
}
