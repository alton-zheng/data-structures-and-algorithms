package java00148.m02;

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
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 *
 * Runtime: 3 ms, faster than 99.92% of Java online submissions for Sort List.
 * Memory Usage: 48.3 MB, less than 26.36% of Java online submissions for Sort List.
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

        // 开始递归
        return cut(head, null);
    }

    private ListNode cut(ListNode cutNode, ListNode judge) {

        // 如果 cutNode 为空，说明不需要分割了，到底了， 返回 cutNode
        if (cutNode == null) {
            return cutNode;
        }

        // cutNode.next = judge 时， 说明此时只有一个元素需要切割了
        // 但一个元素没法再切割，此时将 cutNode.next 指向 null， 即可返回
        // 压根不需要再进行切割操作，
        if (cutNode.next == judge) {

            // 将 cut
            cutNode.next = null;
            return cutNode;
        }

        // 定义快慢指针, s -> slow, f -> fast
        // s 每次在链表中向后移动一次
        // f 每次在链表中向后移动2次
        ListNode s = cutNode, f = cutNode.next;

        // 第一次递归时， judge 为空
        // f 移动到原始链表尾部
        // 后续递归时，不断地分割 cutNode 部分， judge 只用来分割判断用
        // 底层原理时，实际上原链表并没有做实际意义上的分割，只是不断产生分割后的链表，不断的 merge
        while (f != judge) {
            s = s.next;
            f = f.next;
            if (f != judge) {
                f = f.next;
            }
        }

        // 此时的 s -> slow 指针指向链表的后半部分
        ListNode mid = s;

        // 于是到此为止，已经将链表分割成 2 部分 list1, list2

        // list1 为前半部分，继续递归排序的结果
        ListNode list1 = cut(cutNode, mid);

        // list2 为后半部分，继续递归排序，合并的结果
        ListNode list2 = cut(mid, judge);

        // merge 部分，将排序后的， list1, list2 进行 merge 操作
        return merge(list1, list2);

    }

    private ListNode merge(ListNode left, ListNode right) {

        // 构建虚拟 dummyHead
        ListNode dummyHead = new ListNode(-1);

        // 创建 t 临时链表 t 指向 dummyHead 的引用位置
        // l,r 分别指向 left, right 引用位置
        ListNode t = dummyHead, l = left, r = right;

        // l, r 不为空时，进入 merge 阶段
        while (l != null && r != null) {

            // 当 l.val 小于 r.val 时，意味着 l 排在 r 的前边
            if (l.val <= r.val) {
                // t.next 指向 l
                t.next = l;
                l = l.next;
            } else {

                // 反之， 排在 r 排在 l 的前边
                t.next = r;
                r = r.next;
            }

            // 这时候 t.next 已经赋值， t 指向 t.next 引用位置
            t = t.next;
        }

        // 上述 merge 部分完成后，可能 l, r 还不为空，还有链表信息，这时候要么

        // l 不为空时，将 l 剩余部分，赋值给 t.next
        if (l != null) {
            t.next = l;
        }

        // r 不为空时, 将 r 的剩余部分，阈值给 t.next
        if (r != null) {
            t.next = r;
        }

        // 然后返回 dummyHead.next ，即合并后的结果
        return dummyHead.next;
    }
}


