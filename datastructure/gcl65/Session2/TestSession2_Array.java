package gcl65.Session2;

import java.util.Arrays;

public class TestSession2_Array {

    public static void main(String[] args) {

        int[] arr1 = {0, 2, 1, 3, 0, 1, 2, 1, 2, 1}; // 5
        getSumOfTrappedRainWater(arr1);

        int[] arr2 = {-3, 0, 7, -4, -8, 2, 1}; // 224
        System.out.println(findMaxProductsOf3Numbers(arr2));
        System.out.println(findMaxProductsOf3Numbers2(arr2));

        int[] arr3 = {2, -5, 7, -6, 5, 4, -10}; // 10
        System.out.println(maximumSumSubarray(arr3));

    }

    private static void getSumOfTrappedRainWater(int[] arr) {
        int n = arr.length;

        int[] left = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, arr[i - 1]);
            left[i] = max;
        }

        int[] right = new int[n];
        max = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            max = Math.max(max, arr[i + 1]);
            right[i] = max;
        }

        int sum = 0;
        for (int i = 1; i < n - 1; i++) {
            sum += Math.max(Math.min(left[i], right[i]) - arr[i], 0);
        }
        System.out.println(sum);
    }

    private static int findMaxProductsOf3Numbers(int[] arr) {
        Arrays.sort(arr); // NlogN
        int n = arr.length;
        return Math.max(arr[n - 1] * arr[n - 2] * arr[n - 3], arr[0] * arr[1] * arr[n - 1]);
    }

    private static int findMaxProductsOf3Numbers2(int[] arr) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }

    private static int maximumSumSubarray(int arr[]) {
        int max = Integer.MIN_VALUE;
        int curr = 0;
        for (int num : arr) {
            curr += num;
            max = Math.max(max, curr);
            curr = Math.max(curr, 0);
        }
        return max;
    }
}
