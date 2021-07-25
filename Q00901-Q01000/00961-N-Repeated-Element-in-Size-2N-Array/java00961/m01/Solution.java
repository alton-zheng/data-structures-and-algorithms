package java00961.m01;

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
 * Runtime: 3 ms, faster than 42.88% of Java online submissions for N-Repeated Element in Size 2N Array.
 * Memory Usage: 51.7 MB, less than 15.14% of Java online submissions for N-Repeated Element in Size 2N Array.
 */
class Solution {
    public int repeatedNTimes(int[] nums) {
        int[] help = new int[10001];

        for (int num: nums) {
            help[num]++;
            if (help[num] > 1) {
                return num;
            }
        }

        return -1;
    }
}
