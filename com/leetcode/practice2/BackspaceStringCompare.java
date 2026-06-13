package leetcode.practice2;

// https://leetcode.com/problems/backspace-string-compare/description/

import java.util.Stack;

public class BackspaceStringCompare {

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c")); // true
        System.out.println(backspaceCompare("ab##", "ab##")); // true
        System.out.println(backspaceCompare("a#c", "b")); // false
        System.out.println(backspaceCompare("a##c", "#a#c")); // true
    }

    static boolean backspaceCompare(String s, String t) {
        char[] s1 = s.toCharArray();
        Stack<Character> st1 = new Stack<>();
        for (int i = 0, n = s1.length; i < n; i++) {
            if (s1[i] != '#') {
                st1.push(s1[i]);
            } else if (!st1.isEmpty()) {
                st1.pop();
            }
        }

        char[] t1 = t.toCharArray();
        Stack<Character> st2 = new Stack<>();
        for (int i = 0, n = t1.length; i < n; i++) {
            if (t1[i] != '#') {
                st2.push(t1[i]);
            } else if (!st2.isEmpty()) {
                st2.pop();
            }
        }

        while (!st1.isEmpty() && !st2.isEmpty()) {
            if (st1.pop() != st2.pop()) {
                return false;
            }
        }
        return st1.isEmpty() && st2.isEmpty();
    }

}
