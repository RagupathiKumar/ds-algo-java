package gcl65_2.Session1;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        int[] arr = {1, 6, 3, 2, 5};
        int i = 0, j = arr.length - 1;

        System.out.println(Arrays.toString(arr));
        while (i < j) {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
        System.out.println(Arrays.toString(arr));
    }
}
