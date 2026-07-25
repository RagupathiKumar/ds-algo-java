package leetcode.practice4;

public class MaximumProductOfTwoDigits {

    public int maxProduct(int n) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        while (n > 0) {
            int num = n % 10;
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
            n /= 10;
        }
        return max1 * max2;
    }

}
