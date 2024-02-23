package com.leetcode;

import java.util.Stack;

public class MakeTheStringGreat {

    public static void main(String[] args) {
        System.out.println(makeGood("leEeetcode"));
        System.out.println(makeGood("abBAcC"));
        System.out.println(makeGood("s"));
    }

    public static String makeGood(String s) {

        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && ((st.peek() == ((c - 'A') + 'a')) || (st.peek() == ((c - 'a') + 'A')))) {
                st.pop();
            } else {
                st.push(c);
            }
        }

        String str = "";
        while (!st.isEmpty()) {
            str = st.pop() + str;
        }
        return str;
    }

}
