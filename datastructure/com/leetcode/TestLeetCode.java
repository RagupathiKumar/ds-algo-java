package com.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class TestLeetCode {
    public static void main(String[] args) {

        int[] A = null;

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int N = s.nextInt();
            A = new int[N];
            for (int j = 0; j < N; j++) {
                A[j] = s.nextInt();
            }
        }

        System.out.println(Arrays.toString(A));
    }

}
