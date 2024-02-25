package gcl65.Session10;

import java.util.LinkedList;
import java.util.Queue;

/***
    Chaman's comment
    using 2 queues and 1 queue
    in 1 queue -- i) push efficient, ii) pop efficient
*/

public class ImplementStackUsingQueue {

    public static void main(String[] args) {
        ImplementStackUsingQueue stack = new ImplementStackUsingQueue();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.empty());
        System.out.println(stack.top());
        System.out.println(stack.pop());

        System.out.println(stack.empty());
        System.out.println(stack.top());
        System.out.println(stack.pop());

        System.out.println(stack.empty());
        System.out.println(stack.top());
        System.out.println(stack.pop());

        System.out.println(stack.empty());
    }

    private Queue<Integer> q = new LinkedList<>();

    public void push(int x) {
        q.add(x);
    }

    public int pop() {
        int n = q.size() - 1;
        while (n > 0) {
            q.add(q.poll());
            n--;
        }
        return q.poll();
    }

    public int top() {
        int n = q.size() - 1;
        while (n > 0) {
            q.add(q.poll());
            n--;
        }
        int last = q.peek();
        q.add(q.poll());
        return last;
    }

    public boolean empty() {
        return q.isEmpty();
    }

}
