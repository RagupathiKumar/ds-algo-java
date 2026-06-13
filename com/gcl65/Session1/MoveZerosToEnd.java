package gcl65.Session1;

import java.util.Arrays;

public class MoveZerosToEnd {

    public static void main(String[] args) {

        int[] arr = {1, 0, 3, 2, 0};
        moveZeros2(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{0, 0, 3, 1, 0};
        moveZeros2(arr);
        System.out.println(Arrays.toString(arr));
    }

    // BIG O of N square
    private static void moveZeros(int[] arr) {
        boolean traverse = true;
        while (traverse) {
            traverse = false;

            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == 0 && arr[i + 1] > 0) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    traverse = true;
                }
            }
        }
    }

    // BIG O of N
    private static void moveZeros2(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }

}
