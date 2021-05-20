package java00082;

/**
 * @Author: alton
 * @Date: Created in 5/20/21 5:22 PM
 * @Description:
 */

import java.util.HashMap;
import java.util.Map;


/**
 * 性能差，遍历 2 遍
 * Time Complexity : O(2N)
 * Space Complexity: O(N) map
 */
class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode pre = new ListNode(-1, head);
        ListNode cur = head;

        Map<Integer, Integer> help = new HashMap<>();

        while (cur != null) {
            help.put(cur.val, help.getOrDefault(cur.val, 0) + 1);
            cur = cur.next;
        }

        cur = pre;

        while (cur.next != null) {

            if (help.get(cur.next.val) > 1) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return pre.next;
    }

    public static void main(String[] args) {
        new Solution2().deleteDuplicates(new ListNode(1, new ListNode(1)));
    }
}
