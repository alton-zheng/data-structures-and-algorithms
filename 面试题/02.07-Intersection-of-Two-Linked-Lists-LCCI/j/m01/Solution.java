package j.m01;

import java00000.ListNode;

import java.util.HashSet;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-08-29 16:13
 * @Update Date Time: 2022-08-29 16:13
 * @Updated-By: alton_z
 * @Update-Location:
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // 使用容器进行辅助
        HashSet<ListNode> help = new HashSet<>();

        ListNode temp = headA;

        while (temp != null) {
            help.add(temp);
            temp = temp.next;
        }

        temp = headB;

        while (temp != null) {
            if (help.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }
}
