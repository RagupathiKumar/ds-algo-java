package gcl65.Session1;

import java.util.Arrays;

public class TestSession1 {

    public static void main(String[] args) {
        // 1
        int[] arr = {3, 1, 0, 4, 2};
        System.out.println("Missing number = " + missingNumber(arr));

        // 2
        int[] arr2 = {1, 6, 3, 2, 5};
        reverseArray(arr);
        System.out.println("Reverse array = " + Arrays.toString(arr2));

        // 3
        int[] arr3 = {1, 3, 4, 8, 9, 11, 12, 15};
        System.out.println("Pairs count = " + countPairs(arr3, 12));
        System.out.println("Pairs count = " + countPairs(arr3, 13));

        // 4
        int[] arr4 = {1, 0, 3, 2, 0};
        moveZeros(arr4);
        System.out.println(Arrays.toString(arr4));

        arr4 = new int[]{0, 0, 3, 1, 0};
        moveZeros(arr4);
        System.out.println(Arrays.toString(arr4));

        // 5
        int[] arr5 = {1, 2, 3, 4, 5, 6};
        generatingSubarrays(arr5);
    }

    private static int missingNumber(int[] arr) {
        int n = arr.length;
        int actualNaturalSum = n * (n + 1) / 2;
        int arraySum = Arrays.stream(arr).sum();
        return actualNaturalSum - arraySum;
    }

    private static void reverseArray(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }

    private static int countPairs(int[] arr, int sum) {
        int cnt = -1;
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] < sum) {
                i++;
            } else if (arr[i] + arr[j] > sum) {
                j--;
            } else {
                cnt++;
                i++;
                j--;
            }
        }
        return cnt + 1;
    }

    private static void moveZeros(int[] arr) {
        int i = 0, n = arr.length;
        for (int j = 0; j < n; j++) {
            if (arr[j] > 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
    }

    private static void generatingSubarrays(int[] arr) {
        int n = arr.length;

        for (int startingIndex = 0; startingIndex < n; startingIndex++) {
            for (int endingIndex = startingIndex; endingIndex < n; endingIndex++) {

                for (int i = startingIndex; i <= endingIndex; i++) {
                    System.out.print(arr[i] + ", ");
                }
                System.out.println();

            }
        }
    }

}
