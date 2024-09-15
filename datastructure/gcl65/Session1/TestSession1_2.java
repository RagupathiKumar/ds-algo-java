package gcl65.Session1;

import java.util.Arrays;

public class TestSession1_2 {

    public static void main(String[] args) {
        int[] arr6 = {-1, 1, 0, -3, 3}; // ans - 0,0,9,0,0
        productOfArrayExceptSelf(arr6);
        productOfArrayExceptSelf2(arr6);
        productOfArrayExceptSelf3(arr6);

        arr6 = new int[]{3, 2, 5, 1}; // ans - 10,15,6,30
        productOfArrayExceptSelf(arr6);
        productOfArrayExceptSelf2(arr6);
        productOfArrayExceptSelf3(arr6);

        arr6 = new int[]{1, 2, 3, 4}; // ans - 24,12,8,6
        productOfArrayExceptSelf(arr6);
        productOfArrayExceptSelf2(arr6);
        productOfArrayExceptSelf3(arr6);
    }

    private static void productOfArrayExceptSelf(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int left = 1;
            for (int i1 = 0; i1 < i; i1++) {
                left *= arr[i1];
            }

            int right = 1;
            for (int i1 = i + 1; i1 < n; i1++) {
                right *= arr[i1];
            }

            result[i] = left * right;
        }

        System.out.println(Arrays.toString(result));
    }

    private static void productOfArrayExceptSelf2(int[] arr) {
        int n = arr.length;

        int[] left = new int[n];
        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * arr[i];
        }

        int[] right = new int[n];
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0 ; i--) {
            right[i] = right[i + 1]  * arr[i];
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = (i - 1 < 0 ? 1 : left[i - 1]) * (i + 1 > n - 1 ? 1 : right[i + 1]);
        }

        System.out.println(Arrays.toString(result));
    }

    private static void productOfArrayExceptSelf3(int[] arr) {
        int n = arr.length;

        int[] left = new int[n];
        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * arr[i];
        }

        int[] result = new int[n];
        int right = 1;
        for (int i = n - 1; i > 0; i--) {
            result[i] = left[i - 1] * right;
            right *= arr[i];
        }
        result[0] = right;

        System.out.println(Arrays.toString(result));
    }

}
