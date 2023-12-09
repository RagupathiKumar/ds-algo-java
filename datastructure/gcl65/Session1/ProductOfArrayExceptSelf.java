package gcl65.Session1;

import gcl65.Common.Util;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {

        int[] arr = {-1, 1, 0, -3, 3};
        // int[] arr = {3, 2, 5, 1};
        // int[] arr = {1, 2, 3, 4};

        printProductArray(arr);
        printProductArrayNg(arr);
    }

    /**
     * OPTIMIZED
     * SPACE = O(1) -- (result array not included)
     * TIME = O(N) + O(N) == O(N)
     * */
    private static void printProductArrayNg(int[] arr) {
        int size = arr.length;
        int[] result = new int[size];

        result[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result[i] = result[i - 1] * arr[i];
        }

        int rightProduct = 1;
        for (int i = size - 1; i >= 1; i--) {
            result[i] = result[i - 1] * rightProduct;
            rightProduct = rightProduct * arr[i];
        }
        result[0] = rightProduct;

        Util.print(result);
    }

    /**
     * SPACE = left array O(N) + right array O(N) == O(N) -- (result array not included)
     * TIME = O(N) + O(N) + O(N) == O(N)
     * */
    private static void printProductArray(int[] arr) {
        int size = arr.length;

        int[] leftProductArray = new int[size];
        leftProductArray[0] = arr[0];
        for (int i = 1; i < size; i++) {
            leftProductArray[i] = leftProductArray[i - 1] * arr[i];
        }

        int[] rightProductArray = new int[size];
        rightProductArray[size - 1] = arr[size - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            rightProductArray[i] = rightProductArray[i + 1] * arr[i];
        }

        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int leftProduct = (i - 1 < 0 ? 1 : leftProductArray[i - 1]);
            int rightProduct = (i + 1 > size - 1 ? 1 : rightProductArray[i + 1]);
            output[i] = leftProduct * rightProduct;
        }

        Util.print(output);
    }

}
