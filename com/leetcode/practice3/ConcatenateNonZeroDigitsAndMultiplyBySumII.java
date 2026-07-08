package leetcode.practice3;

import java.util.Arrays;

public class ConcatenateNonZeroDigitsAndMultiplyBySumII {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(sumAndMultiply("10203004", new int[][] {{0,7},{1,3},{4,6}})));       // [12340, 4, 9]
//        System.out.println(Arrays.toString(sumAndMultiply("1000", new int[][] {{0,3},{1,1}})));                 // [1, 0]
//        System.out.println(Arrays.toString(sumAndMultiply("9876543210", new int[][] {{0,9}})));                 // [444444137]
//        System.out.println(Arrays.toString(sumAndMultiply("941983443", new int[][] {{1, 8}})));                 // [511403941]
        System.out.println(Arrays.toString(sumAndMultiply("9223538386222334255", new int[][] {{0,18}})));       // [632582266]
    }

    static int[] sumAndMultiply(String s, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {

            String str = s.substring(queries[i][0], queries[i][1] + 1);

            long x = 0, sum = 0, mul = 1;
            for (int idx = str.length() - 1; idx >= 0; idx--) {
                int last = Character.getNumericValue(str.charAt(idx));
                x += last * mul;
                sum += last;
                if (last > 0) {
                    mul *= 10;
                }
            }

            result[i] = (int) ((x * sum) % ((int) Math.pow(10, 9) + 7));
        }
        return result;
    }

}
