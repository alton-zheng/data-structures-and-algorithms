package java00367.m02;

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

        // 初始 p 为 num >> 1
        int p = num >> 1;

        // 当 p * p 大于 num 时，试图不断的切线，不断与 x 轴相交，不断逼近 f(p) = 0 时的， p 值
        while (p * p > num) {
            // 牛顿迭代推导公式，求上述切线与 x 轴的交点
            p = (p + num / p) / 2;
        }

        // 判断是否满足条件，这种方法虽然代码简单，但它需要对牛顿迭代算法有比较深的认识，才可能将它推导出来
        // 对它不了解，用二分也是很不错的方法，两者性能没多大区别
        return p * p  == num;
    }
}