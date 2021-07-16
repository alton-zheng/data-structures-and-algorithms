package java00034.m01;

/**
 * @Author: alton
 * @Date: Created in 7/16/21 12:10 PM
 * @Description: 34. Find First and Last Position of Element in Sorted Array
 * <p>
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * If target is not found in the array, return [-1, -1].
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 * <p>
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums is a non-decreasing array.
 * -10^9 <= target <= 10^9
 * <p>
 * Time Complexity :O(logN)
 * Space Complexity : O(1)
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
 * Memory Usage: 41.9 MB, less than 93.95% of Java online submissions for Find First and Last Position of Element in Sorted Array.
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {

        int len = nums.length;
        int left = 0, right = len;
        int[] res = new int[]{-1, -1};

        if (len == 0) {
            return res;
        }

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                int pre = mid;
                res[0] = res[1] = mid;
                while (--pre >= 0 && nums[pre] == target) {
                    res[0] = pre;
                }

                pre = mid;
                while (++pre < len && nums[pre] == target) {
                    res[1] = pre;
                }

                return res;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return res;
    }
}
