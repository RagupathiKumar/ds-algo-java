package leetcode.practice3;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/process-string-with-special-operations-ii/description/
public class ProcessStringWithSpecialOperationsII {

    public static void main(String[] args) {
        ProcessStringWithSpecialOperationsII process = new ProcessStringWithSpecialOperationsII();
        System.out.println(process.processStr2("a#b%*", 1)); // a
        System.out.println(process.processStr2("cd%#*#", 3)); // d
        System.out.println(process.processStr2("z*#", 0)); // .
        System.out.println(process.processStr2("fwp*m*#a%%", 5)); // .
        System.out.println(process.processStr2("%#bz%xum##i##vzo#pwc*#dkwbh####%uf%s*%cgppqhqa%h#l##o%ij%%cz%iga##e###u%#e####jfwx##%%*x%m*%#", 6523)); // z
    }

    public char processStr(String s, long k) {
        s = s.replace("%%", "");

        StringBuilder sb = new StringBuilder();
        for (int i = 0, n = s.length(); i < n; i++) {
            char c = s.charAt(i);

            if ((c < 'a' || c > 'z') && sb.length() <= 0) {
                continue;
            }


            if (c == '*') {
                sb.deleteCharAt(sb.length() - 1);
            } else if (c == '#') {
                sb = sb.append(sb);
            } else if (c == '%') {
                sb = sb.reverse();
            } else {
                sb.append(c);
            }
        }
        return (sb.length() == 0 || sb.length() <= k) ? '.' : sb.charAt((int) k);
    }

    public char processStr2(String s, long k) {
        Deque<Character> deque = new ArrayDeque<>();
        boolean reversed = false;
        for (int i = 0, n = s.length(); i < n; i++) {
            char c = s.charAt(i);
            if (c == '*') {
                if (reversed) {
                    deque.removeFirst();
                } else {
                    deque.removeLast();
                }
            } else if (c == '#') {
                for (int j = 0, m = deque.size(); j < m; j++) {
                    Character c1 = deque.pollFirst();
                    deque.addLast(c1);
                    deque.addLast(c1);
                }
            } else if (c == '%') {
                reversed = !reversed;
            } else {
                if (reversed) {
                    deque.addFirst(c);
                } else {
                    deque.addLast(c);
                }
            }
        }

        for (long i = 0; i < k; i++) {
            if (reversed) {
                deque.pollLast();
            } else {
                deque.pollFirst();
            }
        }
        return deque.size() == 0 ? '.' : (reversed ? deque.pollLast() : deque.pollFirst());
    }

}
