package java0042.m01;

/**
 * @Author: alton
 * @Date: Created in 7/17/21 3:12 PM
 * @Description:
 * 42-lian-xu-zi-shu-zu-de-zui-da-he-lcof #215
 *
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *  
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * 执行用时： 1 ms , 在所有 Java 提交中击败了 98.83% 的用户
 * 内存消耗： 45.1 MB , 在所有 Java 提交中击败了 17.37% 的用户
 */
class Solution {
    public int maxSubArray(int[] nums) {

        int pre = 0, res = Integer.MIN_VALUE;

        for (int num: nums) {

            if (pre <= 0) {
                res = Math.max(res, num);
                pre = 0;
            } else {
                res = Math.max(res, pre + num);
            }

            pre += num;

        }

        return res;

    }
}
