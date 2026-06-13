package gcl65_2.Session8;

import gcl65_2.common.ListNode;

// https://leetcode.com/problems/intersection-of-two-linked-lists/
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = getLength(headA);
        int len2 = getLength(headB);

        ListNode currA = headA;
        ListNode currB = headB;

        if (len1 > len2) {
            int diff = len1 - len2;
            while (diff > 0) {
                currA = currA.next;
                diff--;
            }
        } else if (len2 > len1) {
            int diff = len2 - len1;
            while (diff > 0) {
                currB = currB.next;
                diff--;
            }
        }

        while (currA != null) {
            if (currA == currB) {
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }
        return null;
    }

    private int getLength(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }
}
