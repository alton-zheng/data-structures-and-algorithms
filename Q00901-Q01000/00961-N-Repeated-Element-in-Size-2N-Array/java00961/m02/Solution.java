package java00961.m02;

/**
 * @Author: alton
 * @Date: Created in 2021/7/25 上午11:30
 * @Description:
 * 961. N-Repeated Element in Size 2N Array
 *
 * In a array nums of size 2 * n, there are n + 1 unique elements, and exactly one of these elements is repeated n times.
 *
 * Return the element repeated n times.
 *
 *
 *
 * Example 1:
 *
 * Input: nums[1,2,3,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums[2,1,2,5,3,2]
 * Output: 2
 * Example 3:
 *
 * Input: nums[5,1,5,2,5,3,5,4]
 * Output: 5
 *
 *
 * Note:
 *
 * 4 <= nums.length <= 10000
 * 0 <= nums[i] < 10000
 * nums.length is even
 *
 * Time Complexity: O(N)
 * Space Complexity: O(10001)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for N-Repeated Element in Size 2N Array.
 * Memory Usage: 39.7 MB, less than 68.31% of Java online submissions for N-Repeated Element in Size 2N Array.
 *
 */
class Solution {
    public int repeatedNTimes(int[] nums) {

        int len = nums.length;

        for (int i = 0; i < len; i++) {

            for (int k = 1; k <= 3; k++) {
                if (i + k < len && (nums[i] ^ nums[i + k]) == 0) {
                    return nums[i];
                }
            }
        }

        return -1;
    }
}
