package gcl65.Session10;

public class BitBasics {

    public static void main(String[] args) {
        System.out.println(isOdd(5)); // true
        System.out.println(isOdd(4)); // false

        System.out.println(getBit(5,2)); // 4
        System.out.println(getBit(4,2)); // 4

        System.out.println(setBit(5,1)); // 7
        System.out.println(setBit(4,1)); // 6

        System.out.println(clearBit(5,2)); // 1
        System.out.println(clearBit(4,2)); // 0
    }

    private static int clearBit(int n, int i) {
        int mask = ~(1<<i);
        return n&mask;
    }

    private static int setBit(int n, int i) {
        int mask = 1 << i;
        return n|mask;
    }

    private static int getBit(int n, int i) {
        int mask = 1 << i;
        return n&mask;
    }

    private static boolean isOdd(int n) {
        return (n&1) == 1;
    }

}
