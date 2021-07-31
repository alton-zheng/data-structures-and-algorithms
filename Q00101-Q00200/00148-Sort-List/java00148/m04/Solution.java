package java00148.m04;

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
 * Time Complexity: O(N*logN)
 * Space Complexity: O(N)
 *
 * Runtime: 6 ms, faster than 84.60% of Java online submissions for Sort List.
 * Memory Usage: 47.5 MB, less than 52.79% of Java online submissions for Sort List.
 */

import java00000.ListNode;

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

        // 进入归并
        return  cut(head);
    }

    private ListNode cut(ListNode cutNode) {
        // 处理归并排序的边界问题,下面两种场景都不需要进行分合操作
        if (cutNode == null || cutNode.next == null) {
            return cutNode;
        }

        // 下面将他们分割开来
        ListNode s = cutNode, f = cutNode.next;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }

        // 这时候，f 指针已经指向 null, 已经到链表的尾部了，这时候 s 指针在链表的中部
        // 接下来开始链表进行分
        ListNode rightNode =  s.next;
        // 这里将 cutNode 从 s 位置切割了， cutNode 就剩下前部分不
        s.next = null;

        ListNode left = sortList(cutNode);
        ListNode right = sortList(rightNode);

        // 分割完后，进行合并部分操作
        return merge(left, right);
    }

    private ListNode merge (ListNode left, ListNode right) {

        // 构建虚拟头结点
        ListNode dummyHead = new ListNode(-1);

        // 构建， t, l, r 分别指向， dummyHead, left, right
        ListNode t = dummyHead, l = left, r = right;

        // 开始合并操作
        while (l != null && r != null) {

            // l 在前， r 在后
            if (l.val >= r.val) {
                t.next = r;
                r = r.next;
            } else {
                t.next = l;
                l = l.next;
            }
            t = t.next;
        }

        // 如 l， r 还存在不为空的链表，将剩余部分赋值给 t.next
        // 这时候，只会有其中之一不为 null
        t.next = l != null ? l : r;

        return dummyHead.next;
    }
}
