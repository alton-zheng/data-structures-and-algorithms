package java00069.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/24 8:54 下午
 * @Description:
 *
 * 69. Sqrt(x) #338
 *
 * Given a non-negative integer x, compute and return the square root of x.
 *
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 *
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 *
 *  
 *
 * Example 1:
 *
 * Input: x = 4
 * Output: 2
 * Example 2:
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 *  
 *
 * Constraints:
 *
 * 0 <= x <= 231 - 1
 *
 * Time Complexity: O()
 * Space Complexity: O()
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Sqrt(x).
 * Memory Usage: 35.7 MB, less than 98.30% of Java online submissions for Sqrt(x).
 */
class Solution {
    public int mySqrt(int x) {
        return (int)Math.sqrt(x);
    }
}
