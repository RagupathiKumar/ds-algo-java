package gcl65.Session9;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {


    public static void main(String[] args) {
        int[] ints = new DailyTemperatures().dailyTemperaturesChaman(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(ints));
    }

    public int[] dailyTemperaturesChaman(int[] temperatures) {

        int n = temperatures.length;
        int[] arr = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                arr[s.peek()] = i - s.pop();
            }
            s.push(i);
        }

        return arr;
    }

    public int[] dailyTemperatures(int[] temperatures) {

        int i = 0, n = temperatures.length;
        int[] arr = new int[n];
        Stack<Integer> s = new Stack<>();

        while (i < n) {
            if (!s.isEmpty()) {
                if (temperatures[i] > temperatures[s.peek()]) {
                    arr[s.peek()] = i - s.pop();
                } else {
                    s.push(i++);
                }
            } else {
                s.push(i++);
            }
        }

        return arr;
    }

}
