package leetcode.practice3;

public class ConcatenateNonZeroDigitsAndMultiplyBySumI {

    public static void main(String[] args) {
        System.out.println(sumAndMultiply(10203004)); // 12340
        System.out.println(sumAndMultiply(1000)); // 1
    }

    static long sumAndMultiply(int n) {
        long x = 0, sum = 0, mul = 1;
        while (n > 0) {
            int last = n % 10;
            x += last * mul;
            sum += last;
            if (last > 0) {
                mul *= 10;
            }
            n /= 10;
        }
        return x * sum;
    }

}
