package java00503.m01;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: alton
 * @Date: Created in 6/16/21 10:16 AM
 * @Description:
 * 503. Next Greater Element II #117
 *
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
 *
 * The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number.
 * The second 1's next greater number needs to search circularly, which is also 2.
 * Example 2:
 *
 * Input: nums = [1,2,3,4,3]
 * Output: [2,3,4,-1,4]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 *
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * Runtime: 10 ms, faster than 60.75% of Java online submissions for Next Greater Element II.
 * Memory Usage: 40.6 MB, less than 69.71% of Java online submissions for Next Greater Element II.
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;

        int[] res = new int[len];

        Arrays.fill(res, -1);

        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < 2 * len - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len]) {
                res[stack.peek()] = nums[i % len];
                stack.pop();
            }
            stack.push(i % len);
        }

        return res;

    }
}
