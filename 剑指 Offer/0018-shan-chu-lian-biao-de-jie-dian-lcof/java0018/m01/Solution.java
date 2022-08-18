package java0018.m01;

import java00000.ListNode;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-08-18 22:50
 * @Update Date Time: 2022-08-18 22:50
 * @Updated-By: alton_z
 * @Update-Location:
 * 0018-shan-chu-lian-biao-de-jie-dian-lcof #433
 *
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {


        // 排除边界情况， 也就是 head 的头节点的值为 val 的场景
        // 创建一个 prev listNode ,  将它指向 head 引用
        // prev 的首元素和 val 初始不相等
        ListNode prev = new ListNode(val + 1);
        prev.next = head;


        // 创建两个辅助 ListNode , 将他们指向同一个 prev 地址
        // 初始状态，他们是相等的
        // 下面的整个处理过程中，仅仅对 cur = cur.next
        // 所以它仅仅是不断的指向 next
        // cur = cur.next
        // head 跟随 temp 进行变化而变化
        ListNode temp = prev;
        ListNode cur = prev;

        // 进入循环，即便是 head 为空，这里也能进入循环
        while (cur != null) {
            // 首次进行判断，肯定是不相等的，因为 prev 的首元素和 val 初始不相等
            if (cur.val == val) {

                // 将需要删除的元素节点排除
                temp.next = cur.next;
            } else {

                // 执行完后， temp 和 cur 始终是相等的
                temp = cur;
            }

            // 处理下一个节点
            cur = cur.next;
        }

        // 返回符合条件的 ListNode 节点
        return prev.next;

    }

    public static void main(String[] args) {
        new Solution().deleteNode(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3)))), 2);
    }
}
