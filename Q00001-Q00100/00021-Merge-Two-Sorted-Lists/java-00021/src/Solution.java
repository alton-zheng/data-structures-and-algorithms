/**
 * 21. Merge Two Sorted Lists
 * Easy
 *
 * 6643
 *
 * 765
 *
 * Add to List
 *
 * Share
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 *
 * Input: l1 = [], l2 = []
 * Output: []
 * Example 3:
 *
 * Input: l1 = [], l2 = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both l1 and l2 are sorted in non-decreasing order.
 */
class Solution {

    /**
     * 递归玩法， 链表过长时，会栈溢出
     * 但由于题目限制了节点数
     * 此数据就不存在， 性能高
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    /*public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        *//**
         * 双迭代玩法, 性能差
         *//*
        ListNode result = new ListNode(-1);
        ListNode temp = result;

        // 两个链表都不为空时，头元素才有比较的需要，才进行迭代
        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }

            temp = temp.next;

        }


        if (l1 != null) {
            temp.next = l1;
        }

        if (l2 != null) {
            temp.next = l2;
        }


        return result.next;

    }*/
}