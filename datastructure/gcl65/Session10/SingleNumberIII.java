package gcl65.Session10;

import java.util.Arrays;

public class SingleNumberIII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
        System.out.println(Arrays.toString(singleNumber(new int[]{5, 1, 2, 1, 2, 3, 5, 7})));
    }

    public static int[] singleNumber(int[] nums) {

        int res = 0;
        for (int num : nums) {
            res ^= num;
        }

        int pos = 0;
        while ((res & 1) != 1) {
            pos++;
            res = res>>1;
        }

        int mask = 1<<pos;
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & mask) > 1) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        return new int[] {num1, num2};
    }
}
