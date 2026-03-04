package gcl65_2.Session2;

import static java.lang.Integer.*;
import static java.lang.System.out;

class MaxProductOf3Numbers {

    public static void main(String args[]) {
        out.println(maxProductOf3(new int[] {-3, 0, 7, -4, -8, 2, 1, 2, -8}));
        out.println(maxProductOf3(new int[] {-3, 10, 2, -8, 4, -6}));
    }

    private static int maxProductOf3(int[] arr) {
        int max1 = MIN_VALUE, max2 = MIN_VALUE, max3 = MIN_VALUE;
        int min1 = MAX_VALUE, min2 = MAX_VALUE;

        for (int num : arr) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return max(max1 * max2 * max3, min1 * min2 * max1);
    }
}  