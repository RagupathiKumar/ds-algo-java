package gcl65.Session1;

import gcl65.Common.Util;

public class ReverseArray {

    public static void main(String[] args) {

        int[] arr = {1, 6, 3, 2, 5};
        Util.print(arr);

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        Util.print(arr);
    }

}
