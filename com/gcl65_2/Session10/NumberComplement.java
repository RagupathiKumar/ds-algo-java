package gcl65_2.Session10;

// https://leetcode.com/problems/number-complement/description/
public class NumberComplement {

    public static void main(String[] args) { // (no leading zero bits)
        System.out.println(findComplement(5)); // 2
        System.out.println(findComplement(1)); // 0
    }

    static int findComplement(int num) {
        int n = num, mask = 0;
        while (n > 0) {
            mask = (mask<<1)|1;
            n >>= 1;
        }
        return num ^ mask;
    }

}
