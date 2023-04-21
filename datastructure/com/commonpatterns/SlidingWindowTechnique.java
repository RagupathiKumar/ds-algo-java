package com.commonpatterns;

public class SlidingWindowTechnique {

    public static void main(String[] args) {
        findMaxInKElements();
    }

    static void findMaxInKElements() {
        int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        int k = 4;

        int currentMax = -1;
        for (int i = 0; i < arr.length - k + 1; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            currentMax = Math.max(currentMax, sum);
        }

        System.out.println("Max :: " + currentMax);
    }

}
