package java0203.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/3/10 3:55 PM
 * @Description:
 * 203. Remove Linked List Elements
 * Given the head of a linked list and an integer val,
 * remove all the nodes of the linked list that has Node.val == val, and return the new head.
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 * <p>
 * Example 2:
 * Input: head = [], val = 1
 * Output: []
 * <p>
 * Example 3:
 * Input: head = [7,7,7,7], val = 7
 * Output: []
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 10^4].
 * 1 <= Node.val <= 50
 * 0 <= k <= 50
 */

import java00203.ListNode;

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
class Solution {

    /**
     * @param head the head of a linked list
     * @param val  The number to be deleted
     * @return the new head of  linked list that does not contain `val` number
     */
    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return head;
        }

        ListNode cur = head;

        while (cur.next != null) {

            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        if (head.val == val) {
            return head.next;
        }

        return head;
    }

    public static void main(String[] args) {

        int[] vals = {2,1,2,4,2,2};

        ListNode listNode = new ListNode(vals);
        System.out.println(listNode);

        System.out.println((new Solution()).removeElements(listNode, 2));
    }
}
