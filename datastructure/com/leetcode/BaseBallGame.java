package com.leetcode;

import java.util.Stack;

public class BaseBallGame {

    public static void main(String[] args) {
        System.out.println(new BaseBallGame().calPoints(new String[] {"5","2","C","D","+"}));
        System.out.println(new BaseBallGame().calPoints(new String[] {"5","-2","4","C","D","9","+","+"}));
        System.out.println(new BaseBallGame().calPoints(new String[] {"1","C"}));
    }

    public int calPoints(String[] operations) {

        Stack<Integer> s = new Stack<>();

        for (String o : operations) {
            if (o.equals("+")) {
                int a = s.pop();
                int b = s.pop();
                s.push(b);
                s.push(a);
                s.push(a + b);
            } else if (o.equals("D")) {
                s.push(s.peek() * 2);
            } else if (o.equals("C")) {
                s.pop();
            } else {
                s.push(Integer.valueOf(o));
            }
        }

        int sum = 0;
        while (!s.isEmpty()) {
            sum += s.pop();
        }

        return sum;
    }
}
