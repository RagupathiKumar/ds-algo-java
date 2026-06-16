package leetcode.practice3;
// https://leetcode.com/problems/process-string-with-special-operations-i/description/
public class ProcessStringWithSpecialOperationsI {

    public static void main(String[] args) {
        ProcessStringWithSpecialOperationsI process = new ProcessStringWithSpecialOperationsI();
        System.out.println(process.processStr("a#b%*")); // ba
        System.out.println(process.processStr("z*#")); // ""
        System.out.println(process.processStr("*%")); // ""
    }

    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, n = s.length(); i < n; i++) {
            char c = s.charAt(i);
            if (c == '*') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else if (c == '#') {
                sb = new StringBuilder(sb.toString()).append(sb);
            } else if (c == '%') {
                sb = sb.reverse();
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
