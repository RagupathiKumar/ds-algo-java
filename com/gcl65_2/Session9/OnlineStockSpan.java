package gcl65_2.Session9;

// https://leetcode.com/problems/online-stock-span/description/

import java.util.Stack;

public class OnlineStockSpan {

    private class StockSpanner {

        private Stack<Pair> stack = new Stack<>();

        public StockSpanner() {}

        public int next(int price) {
            int span = 1;
            while (!stack.isEmpty() && price > stack.peek().price) {
                span += stack.pop().span;
            }
            stack.push(new Pair(price, span));
            return span;
        }

        private class Pair {
            int price;
            int span;
            Pair(int p, int s) {
                this.price = p;
                this.span = s;
            }
        }

    }

}

