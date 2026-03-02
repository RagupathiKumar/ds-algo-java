package gcl65_2.Session1;

import static java.lang.System.out;

public class GeneratingSubarrays {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                for (int k = i; k < j; k++) {
                    out.print(arr[k] + " ");
                }
                out.println();

            }
        }

    }

}
