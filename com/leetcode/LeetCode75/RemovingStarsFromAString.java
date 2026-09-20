package leetcode.LeetCode75;

import java.util.Stack;

public class RemovingStarsFromAString {

    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e")); // lecoe
        System.out.println(removeStars("erase*****")); // ""
    }

    static String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                st.pop();
            } else {
                st.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }

}
