package gcl65_2.Session10;

public class ReverseBits {

    public static void main(String[] args) {
        System.out.println(reverseBits(12)); // 805306368
        System.out.println(reverseBits(43261596)); // 964176192
        System.out.println(reverseBits(2147483644)); // 1073741822
    }

    static int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = (ans<<1)|(n&1);
            n >>= 1;
        }
        return ans;
    }
}
