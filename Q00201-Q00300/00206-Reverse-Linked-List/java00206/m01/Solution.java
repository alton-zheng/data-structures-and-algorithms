package java00206.m01;

import java00000.ListNode;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-08-18 21:49
 * @Update Date Time: 2022-08-18 21:49
 * @Updated-By: alton_z
 * @Update-Location:
 * 206. Reverse Linked List #431
 * https://leetcode.cn/problems/reverse-linked-list/
 *
 */
public class Solution {

    public ListNode reverseList(ListNode head) {

        /**
         * 思路：
         * 1. 先构建 2 个空的 ListNode, 1 个 temp 用来存储临时变量， res 存储结果变量
         */
        ListNode temp = null, res = null;

        // 当 head 不为空进入循环，直到 head 为空为止
        while (head != null) {
            // 每次进入循环 temp 都使用 head.val 构建的 ListNode 来进行初始化
            temp = new ListNode(head.val);

            //  将 temp.next 指向 res
            // 第一次进入循环时， res 为空， 也就是说首次 temp.next 指向 null
            temp.next = res;

            // res 重新赋值为 temp
            // 每次重新赋值后， res 都是当前位置的反转结果
            res = temp;

            // 下次循环处理 head 下一个节点
            head = head.next;

        }

        // 返回 res
        return res;
    }
}
