package gcl65.Session2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MaxProductOf3Numbers {

    public static void main(String[] args) {

        int[] arr = {-3, 0, 7, -4, -8, 2, 1};

        int max = findMaxProductsOf3Numbers(arr);
        System.out.println(max);

        max = findMaxProductsOf3Numbers2(arr);
        System.out.println(max);

        max = findMaxProductsOf3Numbers3(arr);
        System.out.println(max);

    }

    // O(N)
    private static int findMaxProductsOf3Numbers3(int[] arr) {

        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

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

        int product1 = max1 * max2 * max3;
        int product2 = max1 * min1 * min2;

        return Math.max(product1, product2);
    }

    // O(NlogN) -- sort
    private static int findMaxProductsOf3Numbers2(int[] arr) {

        List<Integer> list = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        Integer[] copyOfArr = new Integer[arr.length];
        list.toArray(copyOfArr);

        int product1 = copyOfArr[0] * copyOfArr[1] * copyOfArr[2];
        int product2 = copyOfArr[0] * copyOfArr[copyOfArr.length - 1] * copyOfArr[copyOfArr.length - 2];

        return Math.max(product1, product2);
    }

    // O(N cube) -- brute force approach
    private static int findMaxProductsOf3Numbers(int[] arr) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int i1 = i + 1; i1 < arr.length - 1; i1++) {
                for (int i2 = i1 + 1; i2 < arr.length; i2++) {
                    max = Math.max(max, arr[i] * arr[i1] * arr[i2]);
                }
            }
        }

        return max;
    }


}
