package gcl65_2.Session6;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("23"));;
    }

    public List<String> letterCombinations(String digits) {
        char[][] buttons = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };
        char[] chars = digits.toCharArray();

        List<String> result = new ArrayList<>();
        letterCombinations(buttons, chars, 0, chars.length, new StringBuilder(), result);
        return result;
    }

    private void letterCombinations(char[][] buttons, char[] chars, int i, int n, StringBuilder path, List<String> result) {
        // base case
        if (i == n) {
            result.add(path.toString());
            return;
        }

        // recursive case
        for (char c : buttons[chars[i] - '2']) {
            path.append(c);
            letterCombinations(buttons, chars, i + 1, n, path, result);
            path.deleteCharAt(path.length() - 1); // backtracking
        }
    }

}
