package java00000;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        ListNode temp = next;
        sb.append("head: ").append(this.val).append(", ");
        while (temp != null) {
            sb.append(temp.val).append(", ");
            temp = temp.next;
        }
        return sb.toString();
    }
}