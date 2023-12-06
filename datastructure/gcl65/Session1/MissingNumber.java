package gcl65.Session1;

import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {
        int[] arr = {3, 1, 0, 4};
        int size = 4;

        // this is to find the SUM OF N NATURAL NUMBERS -- (N * (N + 1))/2
        int actualSum = (size * (size + 1)) / 2;
        int arraySum = Arrays.stream(arr).sum();

        System.out.println("Missing number is " + (actualSum - arraySum));
    }

}
