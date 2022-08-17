package java00148.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/7/31 3:18 下午
 * @Description:
 * 148. Sort List #258
 *
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * Example 2:
 *
 *
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 5 * 10^4].
 * -10^5 <= Node.val <= 10^5
 *
 * Time Complexity: O(NlogN)
 * Space Complexity: O(N)
 *
 * Runtime: 10 ms, faster than 33.88% of Java online submissions for Sort List.
 * Memory Usage: 49 MB, less than 21.98% of Java online submissions for Sort List.
 */

import java00000.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {

        if (head == null) {
            return head;
        }
        List<Integer> help = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            help.add(temp.val);
            temp = temp.next;
        }

        Collections.sort(help);
        ListNode res = new ListNode(help.get(help.size() - 1));

        for (int i = help.size() - 2; i >= 0; i--) {
            int cur = help.get(i);
            ListNode newListNode = new ListNode(cur);
            newListNode.next = res;
            res = newListNode;
        }

        return res;
    }
}
