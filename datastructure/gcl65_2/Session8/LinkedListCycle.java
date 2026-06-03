package gcl65_2.Session8;

import gcl65_2.common.ListNode;

// https://leetcode.com/problems/linked-list-cycle/submissions/1172448731/

public class LinkedListCycle {

    public static void main(String[] args) {

    }

    static boolean hasCycle(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
            if (s == f) {
                return true;
            }
        }
        return false;
    }

}
