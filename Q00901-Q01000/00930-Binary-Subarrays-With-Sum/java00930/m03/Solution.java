package java00930.m03;

/**
 * @Author: alton
 * @Date: Created in 7/8/21 8:40 AM
 * @Description:
 * 930. Binary Subarrays With Sum #185
 *
 * Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
 *
 * A subarray is a contiguous part of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,0,1,0,1], goal = 2
 * Output: 4
 * Explanation: The 4 subarrays are bolded and underlined below:
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * Example 2:
 *
 * Input: nums = [0,0,0,0,0], goal = 0
 * Output: 15
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 10^4
 * nums[i] is either 0 or 1.
 * 0 <= goal <= nums.length
 *
 * Time Complexity : O(N)
 * Space Complexity: O(1)
 * Runtime: 2 ms, faster than 87.18% of Java online submissions for Binary Subarrays With Sum.
 * Memory Usage: 42.1 MB, less than 78.37% of Java online submissions for Binary Subarrays With Sum.
 */
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        int len = nums.length;
        int left1 = 0, left2 = 0, right = 0;
        int sum1 = 0, sum2 = 0;
        int res = 0;

        while (right < len) {
            sum1 += nums[right];

            while (left1 <= right && sum1 > goal) {
                sum1 -= nums[left1];
                left1++;
            }

            sum2 += nums[right];
            while (left2 <= right && sum2 >= goal) {
                sum2 -= nums[left2];
                left2++;
            }

            res += left2 - left1;
            right++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSubarraysWithSum(new int[]{1, 2, 3, 2, 1}, 3));
    }
}