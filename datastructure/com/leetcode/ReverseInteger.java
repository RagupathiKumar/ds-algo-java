package com.leetcode;

// https://leetcode.com/problems/reverse-integer/
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(123));
        System.out.println(new ReverseInteger().reverse(-123));
        System.out.println(new ReverseInteger().reverse(120));
        System.out.println(new ReverseInteger().reverse(1534236469));
        System.out.println(new ReverseInteger().reverse(-2147483648));
    }

    public int reverse(int x) {
        long num = 0;
        while (x != 0) {
            num = num * 10 + (x % 10);
            x /= 10;
        }
        return (int) ((num < Integer.MIN_VALUE || num > Integer.MAX_VALUE) ? 0 : num);
    }

}
