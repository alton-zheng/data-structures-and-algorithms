package java00148.m05;

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
 * Space Complexity: O(1)
 *
 * Runtime: 9 ms, faster than 43.17% of Java online submissions for Sort List.
 * Memory Usage: 47.1 MB, less than 78.42% of Java online submissions for Sort List.
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

        // 将 空 head 场景返回
        if (head == null) {
            return null;
        }

        // 获取链表的长度
        int len = 0;

        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        // 获取长度信息后，就可以按照自定义的方式进行分合操作
        // 首先定义 dummyHead, 将 它的 next, 指向 链表 head
        ListNode dummyHead = new ListNode(-1, head);

        // 归并的有效处理长度，最小为 1
        for (int part = 1; part < len; part <<= 1) {

            // 为了更好的实现迭代，定义 pre ， cur 分别指向 dummyHead, dummyHead.next
            ListNode pre = dummyHead, cur = dummyHead.next;

            // 当 cur 不为空时
            while (cur != null) {

                // 定义当前链表， left 指向 cur
                ListNode left = cur;

                // 当 i 等于 1 时，cur 不需要指向后下一个链表
                // 其余情况，cur 在链表 cur 不为空的情况, 向后移动 part - 1 个位置
                for (int i = 1; i < part && cur.next != null; i++) {
                    cur = cur.next;
                }

                ListNode right = cur.next;

                // 切断链表，第一部分长度为 part,
                cur.next = null;

                // 第二部分为 head 除 left 以外的部分
                cur = right;

                // 将 cur 在满足 cur.next 不为空的情况下， 又往后移动 part 长度
                for (int i = 1; i < part && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }

                // 定义 remain 链表，指向 null
                ListNode remain = null;

                // 当移动完 part 后，仍不为空，next 等于 cur.next;
                if (cur != null) {
                    remain = cur.next;
                    // 切断链表， 这时候 right 的长度与 left 一致
                    cur.next = null;
                }

                // merge , 然后 pre的 next 指针指向将 merge 后的子链表
                pre.next = merge(left, right);

                // 然后将 pre 指向与 merge 完成后的链表位置
                while (pre.next != null) {
                    pre = pre.next;
                }
                // 然后当前节点位置指向 remain 部分链表
                cur = remain;

                // 进入下一批次的归并排序操作，直到将相同 part 的全部处理完,才会退出此处 while
                // 再进入到下轮 part , part 以 1 -> 2 -> 4 -> 8 的方法进行，符合自低向上不断迭代，直到找到最终答案
                // 其实递归底层本质也是一样的，到最细的1，才开始合并，不断合并，到最终结果
            }
        }


        return dummyHead.next;
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
