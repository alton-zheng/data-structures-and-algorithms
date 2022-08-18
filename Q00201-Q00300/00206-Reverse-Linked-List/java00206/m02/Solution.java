package java00206.m02;

import java00000.ListNode;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-08-18 22:06
 * @Update Date Time: 2022-08-18 22:06
 * @Updated-By: alton_z
 * @Update-Location:
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

            temp = head.next;
            head.next = res;
            res = head;
            head = temp;

        }

        // 返回 res
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseList(new ListNode(1, new ListNode(2))));
    }
}
