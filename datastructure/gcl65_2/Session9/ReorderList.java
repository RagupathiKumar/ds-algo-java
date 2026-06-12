package gcl65_2.Session9;

import gcl65_2.common.ListNode;

public class ReorderList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reorderList(head);

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        reorderList(head);
        System.out.println(head);
    }

    static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = mid(head);
        ListNode head2 = mid.next;
        mid.next = null;

        head2 = reverse(head2);

        merge(head, head2);
    }

    static void merge(ListNode head, ListNode head2) {
        while (head2 != null) {
            ListNode n1 = head.next;
            ListNode n2 = head2.next;
            head.next = head2;
            head2.next = n1;
            head = n1;
            head2 = n2;
        }
    }


    static ListNode reverse(ListNode head) {
        ListNode p = null;
        ListNode c = head;
        while (c != null) {
            ListNode n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        return p;
    }

    static ListNode mid(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        while (f.next != null && f.next.next != null) {
            f = f.next.next;
            s = s.next;
        }
        return s;
    }
}
