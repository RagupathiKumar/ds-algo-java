package gcl65_2.Session8;

public class MergeTwoSortedLists {

    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // base case
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        // recursive case
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode head = null;
        ListNode curr = null;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                if (curr == null) {
                    curr = list1;
                } else {
                    curr.next = list1;
                    curr = curr.next;
                }
                list1 = list1.next;
            } else {
                if (curr == null) {
                    curr = list2;
                } else {
                    curr.next = list2;
                    curr = curr.next;
                }
                list2 = list2.next;
            }

            if (head == null) {
                head = curr;
            }
        }

        if (list1 != null) {
            curr.next = list1;
        } else if (list2 != null) {
            curr.next = list2;
        }

        return head;
    }

}
