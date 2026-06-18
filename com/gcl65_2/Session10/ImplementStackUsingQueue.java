package gcl65_2.Session10;

import java.util.LinkedList;
import java.util.Queue;

/***
    Chaman's comment
    using 2 queues and 1 queue
    in 1 queue -- i) push efficient, ii) pop efficient
*/

public class ImplementStackUsingQueue {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private boolean useQ1 = true;

    public ImplementStackUsingQueue() {

    }

    public void push(int x) {
        if (useQ1) {
            q1.add(x);
        } else {
            q2.add(x);
        }
    }

    public int pop() {
        if (useQ1) {
            for (int i = 0, n = q1.size(); i < n - 1; i++) {
                q2.add(q1.poll());
            }
            useQ1 = false;
            return q1.poll();
        } else {
            for (int i = 0, n = q2.size(); i < n - 1; i++) {
                q1.add(q2.poll());
            }
            useQ1 = true;
            return q2.poll();
        }
    }

    public int top() {
        if (useQ1) {
            for (int i = 0, n = q1.size(); i < n - 1; i++) {
                q2.add(q1.poll());
            }
            return q1.peek();
        } else {
            for (int i = 0, n = q2.size(); i < n - 1; i++) {
                q1.add(q2.poll());
            }
            return q2.peek();
        }
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

}
