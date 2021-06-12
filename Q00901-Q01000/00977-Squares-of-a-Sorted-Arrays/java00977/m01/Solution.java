package java00977.m01;

import java.util.Arrays;

/**
 * @Author: alton
 * @Date: Created in 6/12/21 4:27 PM
 * @Description:
 * 977. Squares of a Sorted Array #102
 *
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 *
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 *
 *
 * Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
 *
 * Time Complexity: O(NlogN)
 * Space Complexity: O(NLogN)
 *  Array sort
 * Runtime: 2 ms, faster than 58.44% of Java online submissions for Squares of a Sorted Array.
 * Memory Usage: 40.6 MB, less than 71.15% of Java online submissions for Squares of a Sorted Array.
 *
 */
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i] * nums[i];
        }

        Arrays.sort(res);
        return res;
    }
}
