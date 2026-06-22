package gcl65_2.Session10;
// https://leetcode.com/problems/add-binary/description/
public class AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1")); // 100
        System.out.println(addBinary("1010", "1011")); // 10101
        System.out.println(addBinary("1011", "1")); // 1100
        System.out.println(addBinary("11", "1010")); // 1101
    }

    static String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        char carry = '0';

        StringBuilder sb = new StringBuilder();

        while (i >= 0 && j >= 0) {
            if (a.charAt(i) != b.charAt(j)) {
                sb.append(carry == '0' ? '1' : '0');
            } else {
                sb.append(carry);
                carry = a.charAt(i);
            }
            i--;
            j--;
        }

        while (i >= 0) {
            if (a.charAt(i) != carry) {
                sb.append('1');
                carry = '0';
            } else {
                sb.append('0');
            }
            i--;
        }

        while (j >= 0) {
            if (b.charAt(j) != carry) {
                sb.append('1');
                carry = '0';
            } else {
                sb.append('0');
            }
            j--;
        }

        if (carry == '1') {
            sb.append('1');
        }

        return sb.reverse().toString();
    }

}
