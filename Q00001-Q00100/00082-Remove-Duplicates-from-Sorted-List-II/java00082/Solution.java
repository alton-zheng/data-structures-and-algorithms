package java00082;

/**
 * @Author: alton
 * @Date: Created in 5/20/21 11:10 AM
 * @Description: 82. Remove Duplicates from Sorted List II #23
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 * <p>
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode pre = new ListNode(-1, head);
        ListNode cur = pre;

        while (cur.next != null && cur.next.next != null) {

            int curValue = cur.next.val;
            if (curValue == cur.next.next.val) {

                while (cur.next != null && curValue == cur.next.val) {
                    cur.next = cur.next.next;
                }

            } else {
                cur = cur.next;
            }
        }

        return pre.next;
    }

    public static void main(String[] args) {
        new Solution().deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3))))));
    }
}