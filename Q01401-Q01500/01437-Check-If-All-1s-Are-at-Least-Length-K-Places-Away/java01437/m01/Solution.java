package java01437.m01;

/**
 * @Author: alton
 * @Date: Created in 6/29/21 9:32 PM
 * @Description:
 * 1437. Check If All 1's Are at Least Length K Places Away #159
 *
 * Given an array nums of 0s and 1s and an integer k, return True if all 1's are at least k places away from each other, otherwise return False.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: nums = [1,0,0,0,1,0,0,1], k = 2
 * Output: true
 * Explanation: Each of the 1s are at least 2 places away from each other.
 * Example 2:
 *
 *
 *
 * Input: nums = [1,0,0,1,0,1], k = 2
 * Output: false
 * Explanation: The second 1 and third 1 are only one apart from each other.
 * Example 3:
 *
 * Input: nums = [1,1,1,1,1], k = 0
 * Output: true
 * Example 4:
 *
 * Input: nums = [0,1,0,1], k = 1
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 0 <= k <= nums.length
 * nums[i] is 0 or 1
 *
 * Time Complexity : O()
 * Space Complexity : O()
 */
class Solution {
    public boolean kLengthApart(int[] nums, int k) {

        int count = 0;
        int start = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (start == 1 && count < k) {
                    return false;
                }
                start = 1;
                count = 0;
            } else {
                // 1 的间隔意味着 中间 0 的个数
                if (start == 1) {
                    count++;
                }
            }
        }

        return true;
    }
}
