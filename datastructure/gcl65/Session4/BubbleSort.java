package gcl65.Session4;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {7, 5, 2, 8, 1, 4, 3};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));

    }

}
