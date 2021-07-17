package java0042.m02;

/**
 * @Author: alton
 * @Date: Created in 7/17/21 5:43 PM
 * @Description:
 *
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗： 45 MB , 在所有 Java 提交中击败了 30.14% 的用户
 */
class Solution {
    public int maxSubArray(int[] nums) {

        int pre = 0, res = Integer.MIN_VALUE;
        for (int num: nums) {

            // 将方法一中的场景进行代码层级优化， 当 pre + num 小于 pre 时，截断之前的元素
            // 将 pre 赋值为当前元素，之前的值毫无意义
            pre = Math.max(num, pre + num);
            res = Math.max(res, pre);

        }
        return res;
    }
}
