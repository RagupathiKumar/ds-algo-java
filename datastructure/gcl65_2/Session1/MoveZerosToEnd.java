package gcl65_2.Session1;

import java.util.Arrays;

public class MoveZerosToEnd {

    public static void main(String[] args) {
        moveZerosToEnd(new int[] {1, 0, 3, 2, 0});
        moveZerosToEnd(new int[] {0, 0, 3, 1, 0});
        moveZerosToEnd(new int[] {0, 2, 0, 0, 1, 4, 0});
        moveZerosToEnd(new int[] {0, 0, 2, 4, 0, 5});
    }

    private static void moveZerosToEnd(int[] arr) {

        int n = arr.length;
        int j = 0; // index of non-zero element

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                j++;
            }
        }

        System.out.println(Arrays.toString(arr) + "\n");
    }

}
