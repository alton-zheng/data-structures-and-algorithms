package java00896.m01;

/**
 * @Author: alton
 * @Date: Created in 2021/7/23 下午10:45
 * @Description:
 * 896. Monotonic Array #233
 *
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 *
 * An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j].  An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
 *
 * Return true if and only if the given array nums is monotonic.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,3]
 * Output: true
 * Example 2:
 *
 * Input: nums = [6,5,4,4]
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,3,2]
 * Output: false
 * Example 4:
 *
 * Input: nums = [1,2,4,5]
 * Output: true
 * Example 5:
 *
 * Input: nums = [1,1,1]
 * Output: true
 *
 *
 * Note:
 *
 * 1 <= nums.length <= 50000
 * -100000 <= nums[i] <= 100000
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 *
 * Runtime: 1 ms, faster than 99.96% of Java online submissions for Monotonic Array.
 * Memory Usage: 47.5 MB, less than 62.20% of Java online submissions for Monotonic Array.
 */
class Solution {
    public boolean isMonotonic(int[] nums) {

        int pre = nums[0];
        int flag = 0;
        for(int i = 1; i < nums.length; i++) {

            if (flag == 0 && pre != nums[i]) {
                flag = nums[i] > pre ? 1 : -1;
            }

            if (!(flag > 0 ? nums[i] >= pre : nums[i] <= pre)) {
                return false;
            }

            pre = nums[i];
        }

        return true;
    }
}
