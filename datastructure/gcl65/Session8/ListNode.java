package gcl65.Session8;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print() {
        for (ListNode node = this; node != null; node = node.next) {
            System.out.print(node.val + " -> ");
        }
        System.out.print(null + "\n");
    }

}
