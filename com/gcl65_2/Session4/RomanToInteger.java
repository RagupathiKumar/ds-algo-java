package gcl65_2.Session4;

//https://leetcode.com/problems/roman-to-integer/

import java.util.HashMap;
import java.util.Map;

class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int n = s.length();
        int num = 0;
        for (int i = 0; i < n; i++) {
            int curr = getInt(s.charAt(i));
            int next = (i + 1 < n) ? getInt(s.charAt(i + 1)) : 0;
            if (curr < next) {
                num += (next - curr);
                i++;
            } else {
                num += curr;
            }
        }
        return num;
    }

    public int getInt(char c) {
        if (c == 'I') {
            return 1;
        } else if (c == 'V') {
            return 5;
        } else if (c == 'X') {
            return 10;
        } else if (c == 'L') {
            return 50;
        } else if (c == 'C') {
            return 100;
        } else if (c == 'D') {
            return 500;
        } else {
            return 1000;
        }
    }

}