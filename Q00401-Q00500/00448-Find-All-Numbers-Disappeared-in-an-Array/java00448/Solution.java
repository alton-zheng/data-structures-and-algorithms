package java00448;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: alton
 * @Date: Created in 6/10/21 2:31 PM
 * @Description:
 * 448. Find All Numbers Disappeared in an Array #95
 *
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * Example 2:
 *
 * Input: nums = [1,1]
 * Output: [2]
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 *
 *
 * Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Runtime: 5 ms, faster than 77.48% of Java online submissions for Find All Numbers Disappeared in an Array.
 * Memory Usage: 47.6 MB, less than 87.87% of Java online submissions for Find All Numbers Disappeared in an Array.
 *
 *
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> res = new ArrayList<>();

        int len = nums.length;
        
        for (int num: nums) {
            int i = (num - 1) % len;
            nums[i] += len;
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] <= len) {
                res.add(i + 1);
            }
        }

        return res;
    }
}
