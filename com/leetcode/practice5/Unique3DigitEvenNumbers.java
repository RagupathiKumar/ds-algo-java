package leetcode.practice5;

import java.util.HashSet;
import java.util.Set;

public class Unique3DigitEvenNumbers {

    public static void main(String[] args) {
        System.out.println(totalNumbers(new int[]{1, 2, 3, 4})); // 12
        System.out.println(totalNumbers(new int[]{0, 2, 2})); // 2
        System.out.println(totalNumbers(new int[]{6, 6, 6})); // 1
        System.out.println(totalNumbers(new int[]{1, 3, 5})); // 0
    }

    static int totalNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        int n = digits.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (num > 99 && num % 2 == 0) {
                        set.add(num);
                    }
                }
            }
        }
        return set.size();
    }

}
