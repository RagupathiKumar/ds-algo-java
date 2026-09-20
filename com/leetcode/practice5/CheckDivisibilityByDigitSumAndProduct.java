package leetcode.practice5;

public class CheckDivisibilityByDigitSumAndProduct {

    public static void main(String[] args) {
        System.out.println(checkDivisibility(99)); // true
        System.out.println(checkDivisibility(23)); // false
    }

    static boolean checkDivisibility(int n) {
        int sum = 0, prod = 1;
        for (int num = n; num > 0; num /= 10) {
            sum += num % 10;
            prod *= num % 10;
        }
        return n % (sum + prod) == 0;
    }
}
