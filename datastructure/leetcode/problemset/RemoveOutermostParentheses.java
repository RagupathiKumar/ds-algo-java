package leetcode.problemset;

// https://leetcode.com/problems/remove-outermost-parentheses/description/

public class RemoveOutermostParentheses {

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses2("(()())(())")); // ()()()
        System.out.println(removeOuterParentheses2("(()())(())(()(()))")); // ()()()()(())
        System.out.println(removeOuterParentheses2("()()")); // EMPTY
    }

    static String removeOuterParentheses(String s) {
        int open = 0, close = 0;
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int i = 0;
        for (int j = 0, n = chars.length; j < n; j++) {
            if (chars[j] == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                for (int k = i + 1; k < j; k++) {
                    sb.append(chars[k]);
                }
                i = j + 1;
                open = 0;
                close = 0;
            }
        }
        return sb.toString();
    }

    static String removeOuterParentheses2(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for (int i = 0, n = chars.length; i < n; i++) {
            if (chars[i] == '(') {
                if (open > 0) {
                    sb.append('(');
                }
                open++;
            } else {
                open--;
                if (open > 0) {
                    sb.append(')');
                }
            }
        }
        return sb.toString();
    }

}
