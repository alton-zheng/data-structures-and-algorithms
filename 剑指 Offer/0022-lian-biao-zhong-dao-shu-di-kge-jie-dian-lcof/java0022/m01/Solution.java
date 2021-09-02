package java0022.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/9/2 8:59 上午
 * @Description:
 *
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 */

import java00000.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗： 36.4 MB , 在所有 Java 提交中击败了 23.46% 的用户
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int len = 0;

        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        temp = head;

        int i = 0;
        while (temp != null) {
            if (k + i >= len) {
                return temp;
            }

            temp = temp.next;
            i++;
        }

        return temp;
    }
}
