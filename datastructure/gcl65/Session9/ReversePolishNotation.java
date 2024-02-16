package gcl65.Session9;

import java.util.*;
import java.util.function.BiFunction;

public class ReversePolishNotation {

    public static void main(String[] args) {

        System.out.println(new ReversePolishNotation().evalRPN(new String[] {"2","1","+","3","*"}));;
        System.out.println(new ReversePolishNotation().evalRPN(new String[] {"4","13","5","/","+"}));;
        System.out.println(new ReversePolishNotation().evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));;
    }

    public int evalRPN(String[] tokens) {

        Stack<Integer> s = new Stack<>();

        for (String t : tokens) {
            switch (t) {
                case "+":
                    s.push(s.pop() + s.pop());
                    break;
                case "-":
                    s.push(-s.pop() + s.pop());
                    break;
                case "*":
                    s.push(s.pop() * s.pop());
                    break;
                case "/":
                    int b = s.pop();
                    int a = s.pop();
                    s.push(a / b);
                    break;
                default:
                    s.push(Integer.valueOf(t));
                    break;
            }
        }

        return s.pop();
    }

    public int evalRPNNg(String[] tokens) {

        Map<String, BiFunction<Integer, Integer, Integer>> map = new HashMap<>();
        map.put("+", (a, b) -> a + b);
        map.put("-", (a, b) -> a - b);
        map.put("*", (a, b) -> a * b);
        map.put("/", (a, b) -> a / b);

        Stack<Integer> s = new Stack<>();

        for (String t : tokens) {
            if (map.get(t) != null) {
                int b = s.pop();
                int a = s.pop();
                s.push(map.get(t).apply(a, b));
            } else {
                s.push(Integer.valueOf(t));
            }
        }

        return s.pop();
    }

}
