package leetcode.practice2;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/

public class RemoveDuplicatesFromSortedListII {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(3, new ListNode(3, new ListNode(4, null))))));
        head = deleteDuplicates2(head);
        System.out.println(head);
    }

    static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode lastDuplicateNode = null;
        ListNode uniqueList = null;
        ListNode uniqueCurr = null;

        ListNode curr = head;
        while (curr != null) {
            ListNode node = curr;
            curr = curr.next;
            node.next = null;

            if (curr != null && node.val == curr.val) {
                lastDuplicateNode = node;
            } else if (lastDuplicateNode != null && node.val == lastDuplicateNode.val) {
                lastDuplicateNode = node;
            } else {
                if (uniqueCurr == null) {
                    uniqueList = node;
                    uniqueCurr = node;
                } else {
                    uniqueCurr.next = node;
                    uniqueCurr = uniqueCurr.next;
                }
            }
        }

        return uniqueList;
    }

    static ListNode deleteDuplicates2(ListNode head) {
        return deleteDuplicates2(head, null);
    }

    static ListNode deleteDuplicates2(ListNode head, ListNode duplicate) {
        // base case
        if (head == null) {
            return null;
        }

        // recursive case
        ListNode node = head;
        head = head.next;
        node.next = null;

        if ((head != null && node.val == head.val) || (duplicate != null && node.val == duplicate.val)) {
            return deleteDuplicates2(head, node);
        } else {
            node.next = deleteDuplicates2(head, duplicate);
            return node;
        }
    }

}
