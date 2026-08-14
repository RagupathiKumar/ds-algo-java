package leetcode.practice4;

public class SmallestDivisibleDigitProductII {

    public static void main(String[] args) {
//        System.out.println(smallestNumber("1234", 256)); // 1488
//        System.out.println(smallestNumber("12355", 50)); // 12355
        System.out.println(smallestNumber("11111", 26)); // -1
    }

    static String smallestNumber(String num, long t) {
        for (int i = Integer.valueOf(num); i <= Integer.MAX_VALUE; i++) {
            int prod = 1;
            for (int num1 = i; num1 > 0; num1 /= 10) {
                prod *= num1 % 10;
            }
            if (prod == 0) {
                continue;
            }
            if (prod % t == 0) {
                return String.valueOf(i);
            }
        }
        return "-1";
    }

}
