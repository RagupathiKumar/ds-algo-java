package leetcode.practice4;

public class SmallestDivisibleDigitProductI {

    // 15 3
    public int smallestNumber(int n, int t) {
        for (int i = n; i <= 100; i++) {
            int prod = 1;
            for (int num = i; num > 0; num /= 10) {
                prod *= num % 10;
            }
            if (prod % t == 0) {
                return i;
            }
        }
        return -1;
    }

}
