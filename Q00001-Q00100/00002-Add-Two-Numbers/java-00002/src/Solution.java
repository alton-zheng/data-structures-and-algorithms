/**
 * @Author: alton
 * @Date: Created in 4/29/21 3:20 PM
 * @Description:
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
class Solution {
    /**
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807.
     * Example 2:
     *
     * Input: l1 = [0], l2 = [0]
     * Output: [0]
     * Example 3:
     *
     * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * Output: [8,9,9,9,0,0,0,1]
     *
     * 中文： 两数相加
     * 思路：
     * 1. 将两个链表对其成相同长度，进行遍历：
     *    如果一个 ListNode 短则在前面补 00
     * 2. 每一位计算的同时需要考虑上一位的进阶问题，而当前位计算结束后同样需要更新进阶值
     * 3. 如果两个链表全部遍历完毕后， 进阶值为 11， 则在新链表最签名添加节点 11
     * 4. 小技巧： 对于链表问题，返回结果为头结时，通常需要先初始化为 预先指针 pre
     *    该指针的下一个节点指向真相的头结点 head,
     *    使用 pre 指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode pre = new ListNode(0);
        ListNode cur = pre;

        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum);

            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }

        }

        if (carry == 1) {
            cur.next = new ListNode(carry);
        }

        return pre.next;

    }
}
