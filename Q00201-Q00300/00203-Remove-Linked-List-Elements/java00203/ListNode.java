package java00203;

/**
 * @Author: alton
 * @Date: Created in 2021/3/10 3:41 PM
 * @Description: Leetcode java0203.ListNode
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] vals) {

        if (vals == null || vals.length == 0) {
            throw new IllegalArgumentException("items can't empty");
        }

        ListNode cur = this;

        cur.val = vals[0];

        for (int i = 1; i < vals.length; i++) {

            cur.next = new ListNode(vals[i]);
            cur = cur.next;

        }

    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

        ListNode cur = this;
        while (cur != null) {

            res.append(cur.val).append(" -> ");
            cur = cur.next;

        }

        res.append(" NULL ");
        return res.toString();

    }
}
