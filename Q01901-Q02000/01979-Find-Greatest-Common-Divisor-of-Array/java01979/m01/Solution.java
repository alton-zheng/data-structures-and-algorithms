package java01979.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/8/22 下午8:12
 * @Description:
 * 1979. Find Greatest Common Divisor of Array #332
 *
 * Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.
 *
 * The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,5,6,9,10]
 * Output: 2
 * Explanation:
 * The smallest number in nums is 2.
 * The largest number in nums is 10.
 * The greatest common divisor of 2 and 10 is 2.
 * Example 2:
 *
 * Input: nums = [7,5,6,8,3]
 * Output: 1
 * Explanation:
 * The smallest number in nums is 3.
 * The largest number in nums is 8.
 * The greatest common divisor of 3 and 8 is 1.
 * Example 3:
 *
 * Input: nums = [3,3]
 * Output: 3
 * Explanation:
 * The smallest number in nums is 3.
 * The largest number in nums is 3.
 * The greatest common divisor of 3 and 3 is 3.
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Greatest Common Divisor of Array.
 * Memory Usage: 38.8 MB, less than 28.57% of Java online submissions for Find Greatest Common Divisor of Array.
 */
class Solution {
    public int findGCD(int[] nums) {

        int minV = Integer.MAX_VALUE, maxV = Integer.MIN_VALUE;

        for (int num: nums) {
            if (num < minV) {
                minV = num;
            }

            if (num > maxV) {
                maxV = num;
            }
        }

        for (int i = minV; i > 0; i--) {
            if (minV % i == 0 && maxV % i == 0) {
                return i;
            }
        }

        return 1;
    }
}
