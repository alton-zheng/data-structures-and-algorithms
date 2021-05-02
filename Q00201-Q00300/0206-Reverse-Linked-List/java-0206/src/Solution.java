/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * 206. Reverse Linked List
 * Easy
 *
 * 6867
 *
 * 130
 *
 * Add to List
 *
 * Share
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: [2,1]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 *
 *
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
class Solution {

    public ListNode reverseList(ListNode head) {

        /**
         * 思路：
         * 1. 先构建空 ListNode temp / result, temp 用来存储临时变量， result 用来存储结果变量
         * 2. 每次去除头元素，构造除头元素为 head, 头元素的新 ListNode
         * 3. 将 新 ListNode 的 next 赋值给 result
         * 4. 新 ListNode 重新赋值给 result
         * 5. 最后，原 ListNode 排除元素， 进入下一个循环， 直到遍历完为止
         */

        ListNode temp = null, result = null;

        while (head != null) {
            temp = new ListNode(head.val);
            temp.next = result;
            result = temp;
            heap = head.next;
        }

        return result;
    }

}