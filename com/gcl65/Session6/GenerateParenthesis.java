package gcl65.Session6;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    // p - parenthesis String
    // o - openCount
    // c - closeCount

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        parenthesis("", 3, 0, 0, result);
        result.forEach(System.out::println);
    }

    private static void parenthesis(String p, int n, int o, int c, List<String> result) {
        // base case
        if (p.length() == n * 2) {
            result.add(p);
            return;
        }

        // recursive case
        if (o < n) {
            parenthesis(p + "(", n, o + 1, c, result);
        }

        if (c < o) {
            parenthesis(p + ")", n, o, c + 1, result);
        }
    }

}
