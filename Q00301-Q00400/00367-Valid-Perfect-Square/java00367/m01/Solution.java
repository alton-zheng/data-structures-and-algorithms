package java00367.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/7/30 3:20 下午
 * @Description:
 * 367. Valid Perfect Square
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Follow up: Do not use any built-in library function such as sqrt.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 16
 * Output: true
 * Example 2:
 *
 * Input: num = 14
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= num <= 2^31 - 1
 *
 * Time Complexity: O(logN)
 * Space Complexity: O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Valid Perfect Square.
 * Memory Usage: 35.6 MB, less than 85.21% of Java online submissions for Valid Perfect Square.
 *
 */
class Solution {
    public boolean isPerfectSquare(int num) {

        // 等于 1 时，是个特例，不在半数约束内，直接返回即可
        if (num == 1) {
            return true;
        }

        // 定义二分左右边界， 1 是特例，所以 left = 2
        // right 为输入 num 的一半
        int left = 2, right = num >> 1;

        while (left <= right) {

            // 获取 p 值
            int p = ((right - left) >> 1) + left;

            // 由于 p * p 可能超出 int 的上限，强转 long
            // 相等值，说明 num 属于完全平方数
            if ((long) p * p == num) {

                // 这时候返回 true 即可
                return true;
            }

            // 如果 p 平方大于 num, 意味着当前值相比 num 的近似平方根要大
            // 此时将 right 左移
            if ((long)p * p > num) {
                right = p - 1;
            } else {

                // 反之 left 右移
                left = p + 1;
            }
        }

        // 都不满足条件时，说明 num 非完全平方根
        return false;
    }
}