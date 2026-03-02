package gcl65_2.Session1;

import java.util.Arrays;

import static java.lang.System.out;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        out.println(Arrays.toString(arrayProduct(new int[] {1, 2, 3, 4})));
        out.println(Arrays.toString(arrayProduct(new int[] {-1, 1, 0, -3, 3})));
        out.println(Arrays.toString(arrayProduct(new int[] {3, 2, 5, 1})));
        out.println();
        out.println(Arrays.toString(arrayProduct2(new int[] {1, 2, 3, 4})));
        out.println(Arrays.toString(arrayProduct2(new int[] {-1, 1, 0, -3, 3})));
        out.println(Arrays.toString(arrayProduct2(new int[] {3, 2, 5, 1})));
        out.println();
        out.println(Arrays.toString(arrayProduct3(new int[] {1, 2, 3, 4})));
        out.println(Arrays.toString(arrayProduct3(new int[] {-1, 1, 0, -3, 3})));
        out.println(Arrays.toString(arrayProduct3(new int[] {3, 2, 5, 1})));
    }

    // approach 1
    private static int[] arrayProduct(int[] arr) {
        int n = arr.length;

        int[] leftProductArray = new int[n]; // O(N)
        leftProductArray[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProductArray[i] = arr[i - 1] * leftProductArray[i - 1];
        }


        int[] rightProductArray = new int[n]; // O(N)
        rightProductArray[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightProductArray[i] = arr[i + 1] * rightProductArray[i + 1];
        }

        int[] result = new int[n]; // O(N)
        for (int i = 0; i < n; i++) {
            result[i] = leftProductArray[i] * rightProductArray[i];
        }
        return result;
    }

    // approach 2
    private static int[] arrayProduct2(int[] arr) {
        int n = arr.length;

        int[] leftProductArray = new int[n];
        leftProductArray[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProductArray[i] = arr[i - 1] * leftProductArray[i - 1];
        }

        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            leftProductArray[i] = leftProductArray[i] * rightProduct;
            rightProduct *= arr[i];
        }

        return leftProductArray;
    }

    // approach 3
    private static int[] arrayProduct3(int[] arr) {
        int n = arr.length;

        int[] leftProdArr = new int[n];
        leftProdArr[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProdArr[i] = arr[i - 1] * leftProdArr[i - 1];
        }

        int rightProd = 1;
        for (int i = n - 1; i >= 0; i--) {
            leftProdArr[i] = leftProdArr[i] * rightProd;
            rightProd *= arr[i];
        }

        return leftProdArr;
    }

}
