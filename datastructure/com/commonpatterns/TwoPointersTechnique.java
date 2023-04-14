package com.commonpatterns;

import java.util.Arrays;

public class TwoPointersTechnique {

    public static void main(String[] args) {
        // findPair();
        findFour();
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
                System.out.println(String.format("Value pair found :: %s - %s", arr[i], arr[j]));
                return;
            }
        }

        System.out.println("No pair found.");
    }

    static void findFour() {
        int arr[] = { 1, 4, 45, 5, 7, 20, 6, 10, 12 };
        int x = 21;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 3; i++) {
            for (int j = i + 1; j < arr.length - 2; j++) {

                int k = j + 1, l = arr.length - 1;
                
                while (k < l) {
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if (sum == x) {
                        System.out.println(String.format("Values :: %s %s %s %s", arr[i], arr[j], arr[k], arr[l]));
                        return;
                    } else if (sum < x) {
                        k++;
                    } else if (sum > x) {
                        l--;
                    }
                }
            }
        }
    }
}
