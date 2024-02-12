package gcl65.Session8;

public class MergeTwoSortedLists {

    public static void main(String[] args) {

        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));

        ListNode listNode = new MergeTwoSortedLists().mergeTwoListsRecursive(list1, list2);
        for (ListNode node = listNode; node != null; node = node.next) {
            System.out.print(node.val + " -> ");
        }
    }

    public ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {

        // base case
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        // recursive case
        if (list1.val <= list2.val) {
            return new ListNode(list1.val, mergeTwoLists(list1.next, list2));
        }
        return new ListNode(list2.val, mergeTwoLists(list1, list2.next));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = null;
        ListNode curr = null;

        ListNode node1 = list1;
        ListNode node2 = list2;

        while (node1 != null && node2 != null) {
            ListNode node;
            if (node1.val <= node2.val) {
                node = new ListNode(node1.val, null);
                node1 = node1.next;
            } else {
                node = new ListNode(node2.val, null);
                node2 = node2.next;
            }

            if (head == null) {
                head = node;
                curr = head;
            } else {
                curr.next = node;
                curr = curr.next;
            }
        }

        while (node1 != null) {
            curr.next = new ListNode(node1.val, null);
            node1 = node1.next;
        }

        while (node2 != null) {
            curr.next = new ListNode(node2.val, null);
            node2 = node2.next;
        }

        return head;
    }

}
