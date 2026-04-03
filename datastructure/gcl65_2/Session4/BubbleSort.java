package gcl65_2.Session4;

import java.util.Arrays;

class BubbleSort{
    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 1, 3};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        for (int end = arr.length - 1; end >= 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    int t = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = t;
                }
            }
        }
    }


}  