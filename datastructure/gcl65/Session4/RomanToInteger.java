package gcl65.Session4;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {

        System.out.println(romanToInt("XXVII"));
        System.out.println(romanToInt("IV"));
    }

    public static int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        Map<Character, Character> relationMap = new HashMap<>() {{
            put('V', 'I');
            put('X', 'I');
            put('L', 'X');
            put('C', 'X');
            put('D', 'C');
            put('M', 'C');
        }};

        int sum = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            sum += map.get(c);

            if (i - 1 >= 0 && relationMap.get(c) != null && s.charAt(i - 1) == relationMap.get(c)) {
                i--;
                sum -= map.get(s.charAt(i));
            }
        }

        return sum;
    }

}
