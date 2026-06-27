package gcl65_2.Session10;
// https://leetcode.com/problems/hamming-distance/description/
public class HammingDistance {

    public static void main(String[] args) {
        System.out.println(hammingDistance2(1, 4)); // 2
        System.out.println(hammingDistance2(3, 1)); // 1
    }

    static int hammingDistance(int x, int y) {
        int n = x ^ y, ham = 0;
        while (n > 0) {
            ham += n&1;
            n >>= 1;
        }
        return ham;
    }

    static int hammingDistance2(int x, int y) {
        int ham = 0;
        for (int i = 0; i < 32; i++) {
            ham += (x&1) ^ (y&1);
            x >>= 1;
            y >>= 1;
        }
        return ham;
    }

}
