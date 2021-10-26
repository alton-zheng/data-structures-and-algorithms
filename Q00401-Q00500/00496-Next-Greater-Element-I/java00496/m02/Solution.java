package java00496.m02;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Alton
 * @Date: 2021/10/26 9:03 上午
 * @Description:
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> help = new HashMap<>();

        Deque<Integer> stk = new ArrayDeque<>();

        for (int i = nums2.length - 1; i >= 0; i--) {

            int num = nums2[i];

            while (!stk.isEmpty() && num >= stk.peek()) {
                stk.pop();
            }

            help.put(num, stk.isEmpty() ? -1 : stk.peek());
            stk.push(num);

        }
        for (int i = 0; i < nums1.length; ++i) {
            nums1[i] = help.get(nums1[i]);
        }
        return nums1;
    }
}
