package com.commonpatterns;

public class TwoPointersTechnique {

    public static void main(String[] args) {
        findPair();
    }

    static void findPair() {
        int arr[] = { 2, 3, 5, 8, 9, 10, 11 };
        int val = 17;

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {

            int sum = arr[i] + arr[j];
            if (sum < val) {
                i += 1;
            } else if (sum > val) {
                j -= 1;
            } else {
                System.out.println(String.format("Pair found :: %s - %s", i, j));
                return;
            }
        }

        System.out.println("No pair found.");
    }
}
