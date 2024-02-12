package gcl65.Session8;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {

    // O(N ^ 2), O (1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        for (ListNode nodeA = headA; nodeA != null; nodeA = nodeA.next) {
            for (ListNode nodeB = headB; nodeB != null; nodeB = nodeB.next) {
                if (nodeA == nodeB) {
                    return nodeA;
                }
            }
        }
        return null;
    }

    // O (N + M) , O (N)
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        Set<ListNode> set = new HashSet<>();
        for (ListNode nodeA = headA; nodeA != null; nodeA = nodeA.next) {
            set.add(nodeA);
        }

        for (ListNode nodeB = headB; nodeB != null; nodeB = nodeB.next) {
            if (set.contains(nodeB)) {
                return nodeB;
            }
        }

        return null;
    }

    // O (N + M), O (1)
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {

        int lenA = 0;
        for (ListNode nodeA = headA; nodeA != null; nodeA = nodeA.next) {
            lenA++;
        }

        int lenB = 0;
        for (ListNode nodeB = headB; nodeB != null; nodeB = nodeB.next) {
            lenB++;
        }

        int diff = lenA > lenB ? lenA - lenB : lenB - lenA;

        ListNode nodeA = headA;
        ListNode nodeB = headB;
        if (lenA > lenB) {
            while (0 < diff--) {
                nodeA = nodeA.next;
            }
        } else if (lenB > lenA) {
            while (0 < diff--) {
                nodeB = nodeB.next;
            }
        }

        while (nodeA != null) {
            if (nodeA == nodeB) {
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        return null;
    }

}
