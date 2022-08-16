package java00002.m01;

import java00000.ListNode;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-08-10 22:33
 * @Update Date Time: 2022-08-10 22:33
 * @Updated-By: alton_z
 * @Update-Location: 2. Add Two Numbers #422
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 * 解题思路：
 * 中文： 两数相加
 * 思路：
 * 1. 将两个链表对其成相同长度，进行遍历：
 * 如果一个 ListNode 短则在前面补 00
 * 2. 每一位计算的同时需要考虑上一位的进阶问题，而当前位计算结束后同样需要更新进阶值
 * 3. 如果两个链表全部遍历完毕后， 进阶值为 11， 则在新链表最前面添加节点 11
 * 4. 小技巧： 对于链表问题，返回结果为头结时，通常需要先初始化为 预先指针 pre
 * 该指针的下一个节点指向真实的头结点 head,
 * 使用 pre 指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 预先初始化预先指针 pre
        ListNode pre = new ListNode(0);

        // 将 cur 引用到 pre 地址
        ListNode cur = pre;

        // 进位值
        int carry = 0;

        // 进入循环
        while (l1 != null || l2 != null) {

            // l1 或 l2 为空， 以 0 进行计算
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            // 统计相同位的和，注意，这里加了进位值，第一次默认为 0
            int sum = x + y + carry;

            // 如果和超过 10， 则 carry 等于 1， 否则 0
            carry = sum / 10;

            // 这时候的和只需要保留个数，作为节点的值
            sum = sum % 10;

            // 创建 ListNode  节点（val = sum）赋值给 cur.next
            cur.next = new ListNode(sum);

            // cur 指针指向下一个元素，也就是上面新建的 ListNode
            cur = cur.next;

            // 边界场景 1： l1 不为空，说明更高位的数字，指向它
            if (l1 != null) {
                l1 = l1.next;
            }

            // 边界场景 2： l2 不为空，说明更高位的数字，指向它
            if (l2 != null) {
                l2 = l2.next;
            }

        }

        // 计算后， carry 还等于 1， 说明进位
        if (carry == 1) {
            // 最高位，补一个 val = 1 的 ListNode
            cur.next = new ListNode(carry);
        }

        // 将整个 pre.next 返回, 即为答案
        return pre.next;

    }
}

