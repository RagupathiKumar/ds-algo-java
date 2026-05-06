package gcl65_2.Session6;

// https://leetcode.com/problems/generate-parentheses/

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis2(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n, 0, 0, "", result);
        return result;
    }

    private void generateParenthesis(int n, int o, int c, String path, List<String> result) {
        // base case
        if (path.length() == n * 2) {
            result.add(path);
            return;
        }

        // recursive case
        if (o < n) {
            generateParenthesis(n, o + 1, c, path + "(", result); // open
        }
        if (c < o) {
            generateParenthesis(n, o, c + 1, path + ")", result); // close
        }
    }

    private boolean valid(String path) {
        int num = 0;
        char[] chars = path.toCharArray();
        for (char ch : chars) {
            if (ch == '(') {
                num++;
            } else {
                num--;
            }
            if (num < 0) {
                return false;
            }
        }
        return num == 0;
    }

    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        generateParenthesis2(n, 0, 0, path, result);
        return result;
    }

    private void generateParenthesis2(int n, int o, int c, StringBuilder path, List<String> result) {
        // base case
        if (path.length() == n * 2) {
            result.add(path.toString());
            return;
        }

        // recursive case
        if (o < n) {
            path.append("(");
            generateParenthesis2(n, o + 1, c, path, result); // open
            path.deleteCharAt(path.length() - 1); // backtracking
        }
        if (c < o) {
            path.append(")");
            generateParenthesis2(n, o, c + 1, path, result); // close
            path.deleteCharAt(path.length() - 1); // backtracking
        }
    }


}
