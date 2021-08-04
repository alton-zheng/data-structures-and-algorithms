package java00611.m01;

import java.util.Arrays;

/**
 * @Author: alton
 * @Date: Created in 2021/8/4 8:46 上午
 * @Description:
 * 611. Valid Triangle Number
 *
 * Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,3,4]
 * Output: 3
 * Explanation: Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * Example 2:
 *
 * Input: nums = [4,2,3,4]
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 *
 * Time Complexity: O(N^2*logN)
 * Space Complexity: O(logN)
 */
class Solution {
    public int triangleNumber(int[] nums) {

        int len = nums.length;

        Arrays.sort(nums);

        int res = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {

                int left = j, right = len - 1, k = j;

                while (left <= right) {
                    int mid = left + ((right - left) >> 1);
                    if (nums[i] + nums[j] > nums[mid]) {
                        k = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }

                res += k - j;
            }
        }

        return res;
    }
}
