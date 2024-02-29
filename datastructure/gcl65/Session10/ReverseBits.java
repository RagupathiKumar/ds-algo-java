package gcl65.Session10;

public class ReverseBits {

    public static void main(String[] args) {

        System.out.println(reverseBits(6));

        System.out.println(reverseBits(964176192));
        System.out.println(reverseBits(43261596));
    }

    public static int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans |= (n&1);
            n >>= 1;
        }
        return ans;
    }

}
