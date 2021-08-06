package java00179.m01;

import java.util.Arrays;

/**
 * @Author: alton
 * @Date: Created in 2021/8/6 5:52 下午
 * @Description:
 * 179. Largest Number #278
 * Given a list of non-negative integers nums, arrange them such that they form the largest number.
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 * Example 3:
 *
 * Input: nums = [1]
 * Output: "1"
 * Example 4:
 *
 * Input: nums = [10]
 * Output: "10"
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 *
 * Time Complexity: O(N*logN)
 * Space Complexity: O(logN)
 *
 * Runtime: 3 ms, faster than 99.67% of Java online submissions for Largest Number.
 * Memory Usage: 37 MB, less than 99.79% of Java online submissions for Largest Number.
 *
 */
class Solution {
    public String largestNumber(int[] nums) {

        int len = nums.length;

        Integer[] help = new Integer[len];

        for (int i = 0; i < len; i++) {
            help[i] = nums[i];
        }

        Arrays.sort(help, (a, b)  ->   {
            long x = 10, y = 10;
            while (x <= a) {
                x *= 10;
            }

            while (y <= b) {
                y *= 10;
            }

            return (int) (x * b + a - (y * a + b));
        });

        if (help[0] == 0) {
            return "0";
        }

        StringBuilder res = new StringBuilder();

        for (int num: help) {
            res.append(num);
        }

        return res.toString();
    }
}
